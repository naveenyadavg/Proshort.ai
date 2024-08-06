package Supports;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


public class BrowserCreation {
    public static WebDriver driver;
    final PropertiesReader propertiesReader = new PropertiesReader();
    final ChromeOptions options = new ChromeOptions();

    @AfterClass
    public static void tearDown() {
        if (PropertiesReader.browserRequired.equals("true")) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void deleteHTML() throws IOException {
        File reportFile = new File("response_time_report.html");
        if (reportFile.exists()) {
            reportFile.delete();
        }
    }

    @Before
    public void setUp(Scenario scenario) throws IOException {
        propertiesReader.loadProperties();
        if (PropertiesReader.browserHeadless.equals("true")) {
            options.addArguments("--window-size=1920x1080");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");

            options.addArguments("force-device-scale-factor=1.2");

            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            System.out.println(scenario.toString());
        }
        if (PropertiesReader.browserRequired.equals("true")) {
            if (PropertiesReader.browserType.equals("chrome")) {
                options.addArguments("start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--silent");
                options.addArguments("--log-level=3");
                options.addArguments("--disable-extensions");
                options.addArguments("--test-type");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--enable-network-logging");
                options.addArguments("--no-sandbox");

                options.addArguments("force-device-scale-factor=1.2");

                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                // Code to get only the all performance entries-disable
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                options.setCapability("goog:loggingPrefs", logPrefs);
                driver = new ChromeDriver(options);
                System.out.println(scenario.toString());
            }

        } else if (PropertiesReader.browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            // need to add script for firefox
        }
        if (PropertiesReader.browserType.equals("edge")) {
            // Configure EdgeOptions
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--silent");
            options.addArguments("--log-level=3");
            options.addArguments("--disable-extensions");
            options.addArguments("--test-type");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--enable-network-logging");
            options.addArguments("--no-sandbox");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            // Create EdgeDriver instance with options
            driver = new EdgeDriver(options);
            // Additional configuration if needed...
            System.out.println(scenario.toString());
        }

        new PagesClass().driverClass();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws InterruptedException {
        //If test fails takes a screenshot and embeds it in the Cucumber report
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.attach(screenshot, "image/png", "Screenshot description");
                scenario.log(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

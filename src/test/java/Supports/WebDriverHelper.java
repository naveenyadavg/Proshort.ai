package Supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebDriverHelper {

    public static Wait<WebDriver> wait;
    private static WebDriver driver;
    static String defaultSnapshotLocation = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Proshort(Web)_Screenshots" + File.separator;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisible(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAttributeNotEmpty(WebElement element, String attribute, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public void waitUntilVisibilityOfAllElements(List<WebElement> element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitUntilInvisibilityOfAllElements(List<WebElement> element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    public void waitUntilAttributeContains(WebElement element, String attribute, String value, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public void waitUntilTextToBePresentInElement(WebElement element, Integer timeout, Integer pollingTime, String text) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitUntilInvisibilityOfElementLocated(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementToBeClickable(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void takeAScreenShot(String filename) {
        try {
            if (filename == null || filename.isEmpty()) {
                filename = "screenshot";
            }
            if (filename.indexOf(".") == -1) {
                filename = filename + ".jpg";
            }
            if (!filename.contains("Arable")) {
                String[] today = getCurrentDay();
                if (today != null && today.length == 3) {
                    filename = "T" + today[0] + today[1] + filename;
                }
            }
            File snapLocation = new File(defaultSnapshotLocation);
            if (!snapLocation.exists()) {
                snapLocation.mkdirs();
            }
            //Debugger.println("ScreenShotFile:"+filename);
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshot, new File(defaultSnapshotLocation + filename));

        } catch (Exception exp) {

        }
    }

    public static String[] getCurrentDay() {
        Calendar today = Calendar.getInstance();
        String year = "";
        String month = "";
        String day = "";
        int iyear = today.get(Calendar.YEAR);
        int imonth = today.get(Calendar.MONTH) + 1;
        int iday = today.get(Calendar.DATE);

        if (imonth < 10) {
            month = "0" + imonth;
        } else {
            month = "" + imonth;
        }
        year = "" + iyear;
        if (iday < 10) {
            day = "0" + iday;
        } else {
            day = "" + iday;
        }
        return new String[]{day, month, year};
    }

    public void writeToCSV(List<String> dataMap, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("email\n");
            for (String entry : dataMap) {
                writer.write(entry + "\n");
            }
        }
    }

    public void scrollToWebElement(WebElement element) {
        try {
            if (element == null) {
                return;
            }
            Point location = element.getLocation();
            String script = "scroll(" + location.x + "," + (location.y - 120) + ")";
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript(script);
        } catch (Exception e) {

        }
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(1000000);
    }

    public static String extractNumbers(String input) {
        Pattern pattern = Pattern.compile("\\d+"); // Regular expression to match one or more digits
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

}


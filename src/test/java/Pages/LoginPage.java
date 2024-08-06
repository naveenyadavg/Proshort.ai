package Pages;

import Supports.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static Supports.Constants.*;
import static Supports.PagesClass.activitiesPage;
import static Supports.PagesClass.webDriverHelper;
import static Supports.WebDriverHelper.wait;

public class LoginPage {

    @FindBy(xpath = "//button[@data-cky-tag='accept-button']")
    private WebElement acceptBtn;
    @FindBy(xpath = "//div/span[@class='text-primary cursor-pointer font-bold text-primary-900']")
    private WebElement signUpBtn;
    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement registerBtn;
    @FindBy(xpath = "(//div/input[@type='password'])[1]")
    private WebElement enterPassword;
    @FindBy(xpath = "(//div/input[@type='password'])[2]")
    private WebElement reEnterPassword;
    @FindBy(xpath = "//div/input[@name='accountName']")
    private WebElement enterAccountName;
    @FindBy(xpath = "//div/input[@name='fullName']")
    private WebElement enterName;
    @FindBy(xpath = "//div/input[@name='designation']")
    private WebElement enterDesignation;
    @FindBy(xpath = "//span[contains(text(),'Select')]")
    private WebElement selectDepartment;
    @FindBy(xpath = "//li[@class='relative cursor-default select-none rounded-2xl px-6 py-2 hover:bg-gray-50']/span")
    private List<WebElement> departmentList;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[@class='relative flex items-center']/textarea")
    private WebElement descriptionArea;
    @FindBy(xpath = "//form/div[@class=' cursor-default text-black']")
    private WebElement toastMsg;
    @FindBy(xpath = "//button[@type='button' and contains(text(),\"Let's begin\")]")
    private WebElement letsBeginBtn;
    @FindBy(xpath = "//div/button[contains(text(),'Continue')]")
    private WebElement continueBtn;
    @FindBy(xpath = "//div/video")
    private WebElement proShortVideoTab;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTheUrlOfApplication() {
        try {
            driver.get(PropertiesReader.webApplicationUrl);
        } catch (Exception exc) {
            Assert.fail("Failed to open the url of the application due to exception :-" + exc);
        }
    }

    public void enterTheUsernameAndVerify() {
        try {
            cookiesWindows();
            WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your email']")));
            enterEmail.sendKeys(PropertiesReader.applicationUsername);
        } catch (Exception exc) {
            Assert.fail("Failed to enter the username due to exception :-" + exc);
        }
    }

    public void cookiesWindows() {
        try {
            webDriverHelper.waitUntilVisible(acceptBtn, waitTime90Sec, pollingInterval1Sec);
            acceptBtn.click();
        } catch (Exception exc) {
            System.out.println("cookies popup is not displayed");
        }
    }

    public void verifyTheContinueBtnAndLogin() {
        try {
            try {
                webDriverHelper.waitUntilVisible(enterPassword, waitTime90Sec, pollingInterval1Sec);
                enterPassword.sendKeys(PropertiesReader.applicationPassword);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
                webDriverHelper.waitUntilVisible(continueBtn, waitTime90Sec, pollingInterval1Sec);
                webDriverHelper.waitUntilElementToBeClickable(continueBtn, waitTime90Sec, pollingInterval1Sec);
                continueBtn.click();
                webDriverHelper.waitUntilVisible(proShortVideoTab, waitTime90Sec, pollingInterval1Sec);
                activitiesPage.waitUntilLoadComplete();
            } catch (Exception exc) {
                System.out.println("Click on Register and enter the details");
            }
        } catch (Exception exc) {
            Assert.fail("Failed to verify continue btn and login into the application due to exception :-" + exc);
        }
    }

    public void clickOnRegisterAndLogin() throws InterruptedException {
        try {
            try {
                activitiesPage.waitUntilLoadComplete();
                if (proShortVideoTab.isDisplayed()) {
                    System.out.println("Already logged into the application and verified the proShort tab");
                }
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisible(registerBtn, waitTime90Sec, pollingInterval1Sec);
                registerBtn.click();
                webDriverHelper.waitUntilVisible(enterPassword, waitTime90Sec, pollingInterval1Sec);
                enterPassword.click();
                webDriverHelper.waitUntilVisible(reEnterPassword, waitTime90Sec, pollingInterval1Sec);
                reEnterPassword.click();
                webDriverHelper.waitUntilVisible(registerBtn, waitTime90Sec, pollingInterval1Sec);
                registerBtn.click();
                webDriverHelper.waitUntilVisible(descriptionArea, waitTime90Sec, pollingInterval1Sec);
                descriptionArea.sendKeys("Enter the details that required");
                webDriverHelper.waitUntilVisible(enterAccountName, waitTime90Sec, pollingInterval1Sec);
                enterAccountName.sendKeys("Demo");
                webDriverHelper.waitUntilVisible(enterName, waitTime90Sec, pollingInterval1Sec);
                enterName.sendKeys("userName");
                webDriverHelper.waitUntilVisible(selectDepartment, waitTime90Sec, pollingInterval1Sec);
                selectDepartment.click();
                for (WebElement element : departmentList) {
                    String departName = element.getText();
                    if (departName.equals("Other")) {
                        element.click();
                        break;
                    }
                }
                webDriverHelper.waitUntilVisible(enterDesignation, waitTime90Sec, pollingInterval1Sec);
                enterDesignation.sendKeys("Product Designer");
                webDriverHelper.waitUntilVisible(saveBtn, waitTime90Sec, pollingInterval1Sec);
                saveBtn.click();
                webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
                String Msg = toastMsg.getText();
                if (!Msg.equals("Your profile changes have been updated")) {
                    Assert.fail("Failed to verify the message");
                }
                webDriverHelper.waitUntilVisible(letsBeginBtn, waitTime90Sec, pollingInterval1Sec);
                letsBeginBtn.click();
                Thread.sleep(waitTime5000MillSec);
            }
        } catch (Exception exc) {
            Assert.fail("Failed to register and login into the application due to exception :-" + exc);
        }
    }
}

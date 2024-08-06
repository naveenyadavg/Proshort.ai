package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Supports.Constants.*;
import static Supports.PagesClass.webDriverHelper;

public class WorkSpaceSetUpPage {
    private final WebDriver driver;

    public WorkSpaceSetUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/admin/workspace-settings']")
    private WebElement workSpaceSettingBtn;
    @FindBy(xpath = "//input[@placeholder='Proshort']")
    private WebElement workSpaceName;
    @FindBy(xpath = "//input[@id='Edit-Image']")
    private WebElement organizationLogo;
    @FindBy(xpath = "//div[contains(@class,'text-base font-semibold')]")
    private WebElement workSpaceNameDisplayed;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[normalize-space()='Schedule']")
    private WebElement scheduleBtn;
    @FindBy(xpath = "//div[@class=' cursor-default text-black']")
    private WebElement successToastMessage;
    @FindBy(xpath = "//*[@class='cursor-pointer text-gray-850']")
    private WebElement closeToastMessage;

    public static String StoredName;

    public void navigateToWorkSpaceSetup() {
        try {
            webDriverHelper.waitUntilVisible(workSpaceSettingBtn, waitTime90Sec, pollingInterval1Sec);
            workSpaceSettingBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToWorkSpaceSetup.jpg");
            Assert.fail("Failed in the method navigateToWorkSpaceSetup due to exception :- " + exc);
        }
    }

    public void workSpaceName(String name) {
        try {
            webDriverHelper.waitUntilVisible(workSpaceName, waitTime90Sec, pollingInterval1Sec);
            workSpaceName.clear();
            StoredName = name + webDriverHelper.randomNumber();
            workSpaceName.sendKeys(StoredName);
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_workSpaceName.jpg");
            Assert.fail("Failed in the method workSpaceName due to exception :- " + exc);
        }
    }

    public void uploadOrganizationLogo() {
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(@class,'cursor-pointer items-center')]/*[local-name()='svg']"));
            webDriverHelper.waitUntilVisible(element, waitTime90Sec, pollingInterval1Sec);
            organizationLogo.sendKeys(imagePath);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_uploadOrganizationLogo.jpg");
            Assert.fail("Failed in the method uploadOrganizationLogo due to exception :- " + exc);
        }
    }

    public void verifyWorkSpaceName() {
        try {
            webDriverHelper.waitUntilVisible(workSpaceNameDisplayed, waitTime90Sec, pollingInterval1Sec);
            String actualName = workSpaceNameDisplayed.getText();
            Assert.assertTrue(StoredName.equalsIgnoreCase(actualName), "The work space Name is not matching");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyWorkSpaceName.jpg");
            Assert.fail("Failed in the method verifyWorkSpaceName due to exception :- " + exc);
        }
    }

    public void saveTheWorkspaceSettings() {
        try {
            webDriverHelper.waitUntilVisible(saveBtn, waitTime90Sec, pollingInterval1Sec);
            saveBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_saveTheWorkspaceSettings.jpg");
            Assert.fail("Failed in the method saveTheWorkspaceSettings due to exception :- " + exc);
        }
    }

    public void popUpForDetailUpdation() {
        try {
            webDriverHelper.waitUntilVisible(successToastMessage, waitTime90Sec, pollingInterval1Sec);
            String successMsg = successToastMessage.getText();
            Assert.assertEquals(successMsg, popUpMsgForWorkSpace, "The updated pop message is not matching");
            closeToastMessage.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_popUpForDetailUpdation.jpg");
            Assert.fail("Failed in the method popUpForDetailUpdation due to exception :- " + exc);
        }
    }
}

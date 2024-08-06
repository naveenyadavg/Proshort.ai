package Pages;

import Supports.PropertiesReader;
import org.openqa.selenium.By;
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

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/img[@src]")
    private WebElement userAccount;
    @FindBy(xpath = "//div/button[text()='Edit Profile']")
    private WebElement editProfileBtn;
    @FindBy(xpath = "//div[text()='Edit Profile']")
    private WebElement editProfileTitle;
    @FindBy(xpath = "//label[@for='profile-pic-input']")
    private WebElement changeBtn;
    @FindBy(xpath = "//label[@for='profile-pic-input']//following-sibling::input[@type='file']")
    private WebElement profileInput;
    @FindBy(xpath = "//div/textarea[@name='description']")
    private WebElement profileDescription;
    @FindBy(xpath = "//input[@name='accountName']")
    private WebElement enterAccountName;
    @FindBy(xpath = "//button[contains(@id,'headlessui-listbox-button')]")
    private WebElement departmentBtn;
    @FindBy(xpath = "//span[contains(@class,'block truncate ui-open:ui-selected')]")
    private List<WebElement> departmentList;
    @FindBy(xpath = "//input[@name='fullName']")
    private WebElement enterFullName;
    @FindBy(xpath = "//input[@name='designation']")
    private WebElement enterDesignation;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[@class='mt-2 xl:mt-3']")
    private WebElement profileDetails;
    @FindBy(xpath = "//*[local-name()='svg']")
    private WebElement settingsBtn;
    @FindBy(xpath = "//div[@class='p-8']/div[1]")
    private WebElement settingsPageTitle;
    @FindBy(xpath = "(//div/input[@placeholder='Current Password'])[1]")
    private WebElement currentPassword;
    @FindBy(xpath = "//div/input[@placeholder='New Password']")
    private WebElement newPassword;
    @FindBy(xpath = "(//div/input[@placeholder='Current Password'])[2]")
    private WebElement confirmPassword;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-tabs-tab')])[6]")
    private WebElement feedBackBtn;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-tabs-tab')])[5]")
    private WebElement supportBtn;
    @FindBy(xpath = "//div/textarea")
    private WebElement textBox;
    @FindBy(xpath = "//button[@data-tooltip-id='notification']")
    private WebElement notificationBtn;
    @FindBy(xpath = "//p[text()='Maybe Later']")
    private WebElement mayBeLaterBtn;
    @FindBy(xpath = "(//div[contains(@class,'mt-2 px-9 text-lg font-semibold leading')])[1]")
    private WebElement pageFirstHeader;
    @FindBy(xpath = "//div/a//div[2]/div[1]")
    private List<WebElement> notificationList;
    @FindBy(xpath = "//div[contains(@class,'font-semibold')]")
    private WebElement activityHeader;
    @FindBy(xpath = "//div[contains(@class,'overflow-hidden rounded-lg bg-gray')]/img")
    private List<WebElement> activityVideosList;
    public String notificationName;
    public String description;
    public String departName;
    public String designation;
    public String supportName;

    public void clickOnAccountProfile() {
        try {
            webDriverHelper.waitUntilVisible(userAccount, waitTime60Sec, pollingInterval1Sec);
            userAccount.click();
            activitiesPage.waitUntilLoadComplete();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnAccountProfile.jpg");
            Assert.fail("Failed in the method clickOnAccountProfile due to exception :- " + exc);
        }
    }

    public void clickOnEditProfile() {
        try {
            webDriverHelper.waitUntilVisible(editProfileBtn, waitTime60Sec, pollingInterval1Sec);
            editProfileBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnEditProfile.jpg");
            Assert.fail("Failed in the method clickOnEditProfile due to exception :- " + exc);
        }
    }

    public void verifyTheTitleAndClickOnChangeProfile() {
        try {
            webDriverHelper.waitUntilVisible(editProfileTitle, waitTime60Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(changeBtn, waitTime60Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheTitleAndClickOnChangeProfile.jpg");
            Assert.fail("Failed in the method verifyTheTitleAndClickOnChangeProfile due to exception :- " + exc);
        }
    }

    public void uploadAImageVerifyTheToastMsg() {
        try {
            profileInput.sendKeys(imagePath);
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime60Sec, pollingInterval1Sec);
            String successMsg = activitiesPage.toastMsg.getText();
            Assert.assertEquals(successMsg, "Profile Image updated successfully", "Failed to verify the toast message");
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_uploadAImageVerifyTheToastMsg.jpg");
            Assert.fail("Failed in the method uploadAImageVerifyTheToastMsg due to exception :- " + exc);
        }
    }

    public void editTheDetailsClickOnSave() {
        try {
            webDriverHelper.waitUntilVisible(profileDescription, waitTime60Sec, pollingInterval1Sec);
            profileDescription.clear();
            description = "Be happy forever";
            profileDescription.sendKeys(description);
            webDriverHelper.waitUntilVisible(enterAccountName, waitTime60Sec, pollingInterval1Sec);
            enterAccountName.clear();
            enterAccountName.sendKeys(PropertiesReader.applicationCreatedBy.toLowerCase() + "12");
            webDriverHelper.waitUntilVisible(enterFullName, waitTime60Sec, pollingInterval1Sec);
            enterFullName.clear();
            enterFullName.sendKeys(PropertiesReader.applicationCreatedBy);
            webDriverHelper.waitUntilVisible(departmentBtn, waitTime60Sec, pollingInterval1Sec);
            String department = departmentBtn.getText();
            departmentBtn.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(departmentList, waitTime60Sec, pollingInterval1Sec);
            for (WebElement element : departmentList) {
                departName = element.getText();
                if (!departName.equals(department)) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(enterDesignation, waitTime60Sec, pollingInterval1Sec);
            enterDesignation.clear();
            designation = "QA";
            enterDesignation.sendKeys(designation);
            webDriverHelper.waitUntilVisible(saveBtn, waitTime60Sec, pollingInterval1Sec);
            saveBtn.click();
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime60Sec, pollingInterval1Sec);
            String successMsg = activitiesPage.toastMsg.getText();
            Assert.assertEquals(successMsg, "Your profile changes have been updated", "Failed to verify the toast message");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_uploadAImageVerifyTheToastMsg.jpg");
            Assert.fail("Failed in the method uploadAImageVerifyTheToastMsg due to exception :- " + exc);
        }
    }

    public void verifyTheUpdatedDetailsInTheAccountProfile() {
        try {
            webDriverHelper.waitUntilVisible(profileDetails, waitTime60Sec, pollingInterval1Sec);
            String accountDetails = profileDetails.getText();
            System.out.println(accountDetails);
            String details = PropertiesReader.applicationCreatedBy + " • " + designation + " • " + departName + "\n" + description;
            System.out.println(details);
            Assert.assertEquals(accountDetails, details, "Failed to verify the details");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheUpdatedDetailsInTheAccountProfile.jpg");
            Assert.fail("Failed in the method verifyTheUpdatedDetailsInTheAccountProfile due to exception :- " + exc);
        }
    }

    public void clickOnSettings() {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(settingsBtn, waitTime60Sec, pollingInterval1Sec);
            settingsBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnSettings.jpg");
            Assert.fail("Failed in the method clickOnSettings due to exception :- " + exc);
        }
    }

    public void verifyThePageTitle() {
        try {
            webDriverHelper.waitUntilVisible(settingsPageTitle, waitTime60Sec, pollingInterval1Sec);
            String pageTitle = settingsPageTitle.getText();
            Assert.assertEquals(pageTitle, "Account Settings", "Failed to verify the title");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyThePageTitle.jpg");
            Assert.fail("Failed in the method verifyThePageTitle due to exception :- " + exc);
        }
    }

    public void updatePasswordSubmitVerifyTitle() {
        try {
            webDriverHelper.waitUntilVisible(currentPassword, waitTime60Sec, pollingInterval1Sec);
            currentPassword.sendKeys(PropertiesReader.applicationPassword);
            webDriverHelper.waitUntilVisible(newPassword, waitTime60Sec, pollingInterval1Sec);
            newPassword.sendKeys(PropertiesReader.applicationNewPassword);
            webDriverHelper.waitUntilVisible(confirmPassword, waitTime60Sec, pollingInterval1Sec);
            confirmPassword.sendKeys(PropertiesReader.applicationNewPassword);
            webDriverHelper.waitUntilVisible(submitBtn, waitTime60Sec, pollingInterval1Sec);
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime60Sec, pollingInterval1Sec);
            String msg = activitiesPage.toastMsg.getText();
            Assert.assertEquals(msg, "Password updated successfully", "Failed to verify the toast message");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_updatePasswordSubmitVerifyTitle.jpg");
            Assert.fail("Failed in the method updatePasswordSubmitVerifyTitle due to exception :- " + exc);
        }
    }

    public void clickEnterTheFeedback() {
        try {
            webDriverHelper.waitUntilVisible(feedBackBtn, waitTime60Sec, pollingInterval1Sec);
            supportName = feedBackBtn.getText();
            feedBackBtn.click();
            webDriverHelper.waitUntilVisible(textBox, waitTime60Sec, pollingInterval1Sec);
            textBox.sendKeys("The application is too good");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickEnterTheFeedback.jpg");
            Assert.fail("Failed in the method clickEnterTheFeedback due to exception :- " + exc);
        }
    }

    public void submitVerifyTheMsg() {
        try {
            webDriverHelper.waitUntilVisible(submitBtn, waitTime60Sec, pollingInterval1Sec);
            submitBtn.click();
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime60Sec, pollingInterval1Sec);
            String msg = activitiesPage.toastMsg.getText();
            if (supportName.equalsIgnoreCase("Feedback")) {
                Assert.assertEquals(msg, "Thank you. Your feedback has been received.", "Failed to verify the toast msg");
            }
            if (supportName.equalsIgnoreCase("Help and Support")) {
                Assert.assertEquals(msg, "Message received. Someone from our team will contact you soon.", "Failed to verify the toast msg");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickEnterTheFeedback.jpg");
            Assert.fail("Failed in the method clickEnterTheFeedback due to exception :- " + exc);
        }
    }

    public void clickOnNotification() {
        try {
            webDriverHelper.waitUntilVisible(notificationBtn, waitTime60Sec, pollingInterval1Sec);
            notificationBtn.click();
            try {
                webDriverHelper.waitUntilVisible(mayBeLaterBtn, waitTime60Sec, pollingInterval1Sec);
                mayBeLaterBtn.click();
                webDriverHelper.waitUntilVisible(notificationBtn, waitTime60Sec, pollingInterval1Sec);
                notificationBtn.click();
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisible(pageFirstHeader, waitTime60Sec, pollingInterval1Sec);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNotification.jpg");
            Assert.fail("Failed in the method clickOnNotification due to exception :- " + exc);
        }
    }

    public void selectAnyNotification() {
        try {
            webDriverHelper.waitUntilVisible(pageFirstHeader, waitTime60Sec, pollingInterval1Sec);
            for (WebElement element : notificationList) {
                notificationName = element.getText();
                element.click();
                break;
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAnyNotification.jpg");
            Assert.fail("Failed in the method selectAnyNotification due to exception :- " + exc);
        }
    }

    public void checkWhetherItWasNavigatingToRespectiveCourse() {
        try {
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(activityHeader, waitTime60Sec, pollingInterval1Sec);
            String headerText = activityHeader.getText();
            Assert.assertTrue(notificationName.contains(headerText), "Failed to verify the header in notification and activity page ");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_checkWhetherItWasNavigatingToRespectiveCourse.jpg");
            Assert.fail("Failed in the method checkWhetherItWasNavigatingToRespectiveCourse due to exception :- " + exc);
        }
    }

    public void clickEnterTheSupportMessage() {
        try {
            webDriverHelper.waitUntilVisible(supportBtn, waitTime60Sec, pollingInterval1Sec);
            supportName = supportBtn.getText();
            supportBtn.click();
            webDriverHelper.waitUntilVisible(textBox, waitTime60Sec, pollingInterval1Sec);
            textBox.sendKeys("Can you pls help me out, how to use the application");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickEnterTheSupportMessage.jpg");
            Assert.fail("Failed in the method clickEnterTheSupportMessage due to exception :- " + exc);
        }
    }
}

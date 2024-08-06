package Pages;

import Supports.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Supports.Constants.*;
import static Supports.PagesClass.webDriverHelper;

public class ManageUsersPage {
    private static WebDriver driver;

    public ManageUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'User & Group')]")
    private WebElement userAndGroup;
    @FindBy(xpath = "//div[@id='headlessui-disclosure-panel-:r10:']//span[text()='Manage user']")
    private WebElement manageUser;
    @FindBy(xpath = "//div[@class='flex gap-3']//span[text()='Invite member']")
    private WebElement inviteMember;
    @FindBy(xpath = "//span[text()='Users']")
    private WebElement manageUserPageTitle;
    @FindBy(xpath = "//div[text()='Invite member']")
    private WebElement inviteMemberPageTitle;
    @FindBy(xpath = "//button[text()='Bulk invite']")
    private WebElement bulkInviteBtn;
    @FindBy(xpath = "//input[@placeholder='jane@proshort.ai']")
    private WebElement emailEmail;
    @FindBy(xpath = "//button[text()='Invite']")
    private WebElement inviteBtn;
    @FindBy(xpath = "//p[@class='text-lg font-semibold leading-22']")
    private WebElement successMsg;
    @FindBy(xpath = "//input[@placeholder='Type something to search']")
    private WebElement searchBar;
    @FindBy(xpath = "(//p[@class='max-w-[158px] truncate'])[1]")
    private WebElement firstEmail;
    @FindBy(xpath = "(//tbody/tr/td[3])[1]")
    private WebElement roleList;
    @FindBy(xpath = "//button[text()='Done']")
    private WebElement doneBtn;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-menu-button')])[1]")
    private WebElement menuBtn;
    @FindBy(xpath = "//button[text()= 'Edit details']")
    private WebElement editDetails;
    @FindBy(xpath = "//div[text()= 'Edit member details']")
    private WebElement editMemberDetailsTitle;
    @FindBy(xpath = "//input[@placeholder = 'jane doe']")
    private WebElement enterUsername;
    @FindBy(xpath = "//span[contains(@class,'block truncate ui-open:ui-selected')]")
    List<WebElement> departmentList;
    @FindBy(xpath = "//input[@placeholder= 'Product Design']")
    private WebElement designationField;
    @FindBy(xpath = "//button[text()= 'Save Changes']")
    private WebElement saveBtn;
    @FindBy(xpath = "//form/div[@class=' cursor-default text-black']")
    private WebElement toastMsg;
    @FindBy(xpath = "(//div[@class='flex items-center gap-2'])[3]")
    private WebElement enterDepartment;
    @FindBy(xpath = "(//tbody/tr/td)[1]")
    private WebElement firstMemberName;
    @FindBy(xpath = "(//tbody/tr/td)[3]")
    private WebElement firstMemberRole;
    @FindBy(xpath = "(//tbody/tr/td)[4]")
    private WebElement firstMemberDepartment;
    @FindBy(xpath = "(//tbody/tr/td)[5]")
    private WebElement firstMemberDesignation;
    @FindBy(xpath = "(//span[@class='flex items-center truncate '])[2]")
    private WebElement roleName;
    @FindBy(xpath = "//label[@for='videoUpload']/following-sibling::input[@type='file']")
    private WebElement uploadExcelFile;
    @FindBy(xpath = "//label[@for='videoUpload']")
    private WebElement fileUploadElement;
    @FindBy(xpath = "//p[contains(@class,'text-lg font-semibold leading')]")
    private WebElement inviteMsg;
    @FindBy(xpath = "//div[contains(@class,'items-center gap-1 text-gray')]//p")
    private List<WebElement> emailListInInviteTab;
    @FindBy(xpath = "//button[text()='Invite more users']")
    private WebElement inviteMoreBtn;
    @FindBy(xpath = "(//tbody/tr/td/a)[1]")
    private WebElement firstActivity;
    List<String> sampleEmailsList = new ArrayList<>();
    List<String> inviteSentEmailsList = new ArrayList<>();
    public SoftAssert softAssert = new SoftAssert();
    public String updatedDepartment;
    public String roleNameInPopUpPage;
    public String email;
    public String role;
    public String memberName;
    public String designationName;

    public void clickOnInviteMemberButton(String button) {
        try {
            Thread.sleep(waitTime5000MillSec);
            if (button.equals("Invite member")) {
                WebElement element = driver.findElement(By.xpath("//span[text()='" + button + "']"));
                webDriverHelper.waitUntilVisible(element, waitTime90Sec, pollingInterval1Sec);
                element.click();
            } else {
                webDriverHelper.waitUntilVisible(bulkInviteBtn, waitTime90Sec, pollingInterval1Sec);
                bulkInviteBtn.click();
            }
            WebElement elementHeader = driver.findElement(By.xpath("//div[text()='" + button + "']"));
            webDriverHelper.waitUntilVisible(elementHeader, waitTime90Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnInviteMemberButton.jpg");
            Assert.fail("Failed in method clickOnInviteMemberButton due to exception :-" + exc);
        }
    }

    public static String generateRandomName(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomName = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomName.append(characters.charAt(random.nextInt(characters.length())));
        }
        randomName.setCharAt(0, Character.toUpperCase(randomName.charAt(0)));
        return randomName.toString();
    }

    public void enterEmailIdAndClickDoneButton(String emailId) {
        try {
            webDriverHelper.waitUntilVisible(emailEmail, waitTime90Sec, pollingInterval1Sec);
            String randomName = generateRandomName(5);
            email = randomName + emailId;
            System.out.println("email " + email);
            emailEmail.sendKeys(email);
            webDriverHelper.waitUntilVisible(roleName, waitTime90Sec, pollingInterval1Sec);
            roleNameInPopUpPage = roleName.getText();
            webDriverHelper.waitUntilVisible(inviteBtn, waitTime90Sec, pollingInterval1Sec);
            inviteBtn.click();
            webDriverHelper.waitUntilVisible(successMsg, waitTime90Sec, pollingInterval1Sec);
            doneBtn.click();
            driver.navigate().refresh();
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterEmailIdAndClickDoneButton.jpg");
            Assert.fail("Failed in method enterEmailIdAndClickDoneButton due to exception :-" + exc);
        }
    }

    public void verifyTheEmailInThePendingSection(String status) {
        try {
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            Thread.sleep(waitTime5000MillSec);
            WebElement element = driver.findElement(By.xpath("//button[text()='" + status + "']"));
            element.click();
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.clear();
            searchBar.sendKeys(email);
            boolean flag = false;
            webDriverHelper.waitUntilVisible(firstEmail, waitTime90Sec, pollingInterval1Sec);
            String emailName = firstEmail.getText();
            System.out.println("emailName " + emailName);
            if (emailName.contains(email.toLowerCase())) {
                role = roleList.getText().toUpperCase();
                Assert.assertEquals(role, roleNameInPopUpPage, "Failed to verify the role specified");
                flag = true;
            }
            if (!flag) {
                Assert.fail("The campaign name " + email + " is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheEmailInThePendingSection.jpg");
            Assert.fail("Failed in method verifyTheEmailInThePendingSection due to exception :-" + exc);
        }
    }

    public void uploadAExcelFileWhichAsMultiple(String emailId) {
        try {
            String randomName1 = generateRandomName(10);
            sampleEmailsList.add((randomName1 + emailId).toLowerCase());
            String randomName2 = generateRandomName(10);
            sampleEmailsList.add((randomName2 + emailId).toLowerCase());
            String randomName3 = generateRandomName(10);
            sampleEmailsList.add((randomName3 + emailId).toLowerCase());
            String randomName4 = generateRandomName(10);
            sampleEmailsList.add((randomName4 + emailId).toLowerCase());
            String randomName5 = generateRandomName(10);
            sampleEmailsList.add((randomName5 + emailId).toLowerCase());
            System.out.println("sampleEmailsList " + sampleEmailsList);

            webDriverHelper.writeToCSV(sampleEmailsList, excelFilePath);
            webDriverHelper.waitUntilVisible(fileUploadElement, waitTime90Sec, pollingInterval1Sec);
            uploadExcelFile.sendKeys(uploadExcelFilePath);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_uploadAExcelFile.jpg");
            Assert.fail("Failed in method uploadAExcelFile due to exception :-" + exc);
        }
    }

    public void clickOnInvite() {
        try {
            webDriverHelper.waitUntilVisible(roleName, waitTime90Sec, pollingInterval1Sec);
            roleNameInPopUpPage = roleName.getText();
            webDriverHelper.waitUntilVisible(inviteBtn, waitTime90Sec, pollingInterval1Sec);
            inviteBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnInvitee.jpg");
            Assert.fail("Failed in method clickOnInvite due to exception :-" + exc);
        }
    }

    public void verifyTheSentEmailsInTheInvitePage() {
        try {
            Thread.sleep(waitTime5000MillSec);
            for (WebElement element : emailListInInviteTab) {
                String emailName = element.getText();
                inviteSentEmailsList.add(emailName);
                System.out.println("inviteSentEmailsList " + inviteSentEmailsList);
            }
            boolean allEmailsMatch = true;
            for (String email : inviteSentEmailsList) {
                if (!sampleEmailsList.contains(email)) {
                    allEmailsMatch = false;
                    break;
                }
            }
            if (!allEmailsMatch) {
                Assert.fail("Failed because the emails in list and in the invite tab are not matching");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSentEmailsInTheInvitePage.jpg");
            Assert.fail("Failed in method verifyTheSentEmailsInTheInvitePage due to exception :-" + exc);
        }
    }

    public void verifyTheSuccessMessageClickOnDone() {
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'text-lg font-semibold leading')]")));
                String successMsg = toastMessage.getText();
                System.out.println("successMsg " + successMsg);
                Assert.assertEquals(successMsg, inviteSuccessMsg + inviteSentEmailsList.size() + " users.", "Failed to verify the success message after sending the invite");
            } catch (Exception exc) {
                softAssert.fail("Unable to verify the toast message due to " + exc.getMessage());
            }
            webDriverHelper.waitUntilVisible(doneBtn, waitTime90Sec, pollingInterval1Sec);
            doneBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSuccessMessageClickOnDone.jpg");
            Assert.fail("Failed in method verifyTheSuccessMessageClickOnDone due to exception :-" + exc);
        }
    }

    public void verifyTheSentEmailsInThePendingSection(String status) {
        try {
            driver.navigate().refresh();
            for (String emailNames : inviteSentEmailsList) {
                email = emailNames;
                verifyTheEmailInThePendingSection(status);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSentEmailsInThePendingSection.jpg");
            Assert.fail("Failed in method verifyTheSentEmailsInThePendingSection due to exception :-" + exc);
        }
    }

    public void editTheDetailsForExistingMember(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys("Member");
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(menuBtn, waitTime90Sec, pollingInterval1Sec);
            menuBtn.click();
            webDriverHelper.waitUntilVisible(editDetails, waitTime90Sec, pollingInterval1Sec);
            editDetails.click();
            webDriverHelper.waitUntilVisible(editMemberDetailsTitle, waitTime90Sec, pollingInterval1Sec);
            memberName = manageType + "_Auto" + webDriverHelper.randomNumber();
            webDriverHelper.waitUntilVisible(enterUsername, waitTime90Sec, pollingInterval1Sec);
            enterUsername.click();
            enterUsername.clear();
            Thread.sleep(waitTime3000MillSec);
            enterUsername.sendKeys(memberName);
            webDriverHelper.waitUntilVisible(enterDepartment, waitTime90Sec, pollingInterval1Sec);
            String departmentName = enterDepartment.getText();
            enterDepartment.click();
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisibilityOfAllElements(departmentList, waitTime90Sec, pollingInterval1Sec);
            for (WebElement department : departmentList) {
                String departmentNames = department.getText();
                if (!departmentNames.contains(departmentName)) {
                    webDriverHelper.scrollToWebElement(department);
                    updatedDepartment = departmentNames;
                    department.click();
                    break;
                }
            }
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(designationField, waitTime90Sec, pollingInterval1Sec);
            designationName = designationField.getAttribute("value");
            webDriverHelper.waitUntilVisible(saveBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.scrollToWebElement(saveBtn);
            saveBtn.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
            String successMsg = toastMsg.getText();
            Assert.assertEquals(successMsg, memberDetailsUpdateConfirmMsg, "Failed to verify the toast message");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_editTheDetailsForExistingMember.jpg");
            Assert.fail("Failed in method editTheDetailsForExistingMember due to exception :-" + exc);
        }
    }

    public void verifyTheDetailsAfterEditing() {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.clear();
            Thread.sleep(waitTime5000MillSec);
            searchBar.sendKeys(memberName);
            webDriverHelper.waitUntilVisible(firstMemberName, waitTime90Sec, pollingInterval1Sec);
            String updatedName = firstMemberName.getText();
            webDriverHelper.waitUntilVisible(firstMemberDepartment, waitTime90Sec, pollingInterval1Sec);
            String department = firstMemberDepartment.getText();
            webDriverHelper.waitUntilVisible(firstMemberDesignation, waitTime90Sec, pollingInterval1Sec);
            String updatedDesignation = firstMemberDesignation.getText();
            Assert.assertTrue(updatedName.contains(memberName), "Failed to verify the user name");
            Assert.assertEquals(department, updatedDepartment, "Failed to verify the department name");
            Assert.assertEquals(updatedDesignation, designationName, "Failed to verify the designation name");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsAfterEditing.jpg");
            Assert.fail("Failed in method verifyTheDetailsAfterEditing due to exception :-" + exc);
        }
    }
}

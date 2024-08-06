package Pages;

import Supports.Constants;
import Supports.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static Supports.Constants.*;
import static Supports.Constants.waitTime300MillSec;
import static Supports.PagesClass.*;
import static Supports.WebDriverHelper.wait;

public class ActivitiesPage {
    private WebDriver driver;

    public ActivitiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[local-name()='svg' and @preserveAspectRatio='xMidYMid meet']")
    public WebElement loadingXpath;
    @FindBy(xpath = "//div[@id='nav']//button[contains(@id,'headlessui-menu-button-:')]")
    private WebElement chevronIcon;
    @FindBy(xpath = "//span[normalize-space()='Admin']")
    private WebElement adminConsole;
    @FindBy(xpath = "//div[text()='Dashboard']")
    private WebElement adminHomePageTitle;
    @FindBy(xpath = "//tbody/tr/td/div/span")
    private WebElement recentActivity;
    @FindBy(xpath = "//span[@class='text-xs font-semibold']")
    private WebElement activitiesTab;
    @FindBy(xpath = "//div[@data-headlessui-state='open']/a")
    private List<WebElement> activitiesList;
    @FindBy(xpath = "(//div[contains(@class,'flex items-center')]//button)[2]")
    private WebElement createBtn;
    @FindBy(xpath = "//div[text()='Name your ']")
    private WebElement createActivityHeader;
    //    @FindBy(xpath = "(//div[@class='relative mt-1']/button)[2]")
    @FindBy(xpath = "//span[text()='Select participants group']")
    private WebElement participantGroupSearchBar;
    @FindBy(xpath = "//li[@role='option']")
    private List<WebElement> groupsList;
    @FindBy(xpath = "//div[contains(@class,'flex flex-wrap')]//div")
    private List<WebElement> groupsSelected;
    @FindBy(xpath = "//div[@class='w-full']//input")
    private WebElement enterActivityName;
    @FindBy(xpath = "//div[@class='relative flex items-center']/textarea")
    private WebElement descriptionArea;
    @FindBy(xpath = "//div[@class='p-1']/button[contains(text(),'Create')]")
    private WebElement create;
    @FindBy(xpath = "//div[@class='text-2xl font-semibold']")
    private WebElement courseNameAsTitle;
    @FindBy(xpath = "//div[@class='relative mt-7']/button")
    private WebElement modules;
    @FindBy(xpath = "//a/button")
    private WebElement addModule;
    @FindBy(xpath = "//div[text()='Video']")
    private WebElement addVideoBtn;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement enterModuleTitle;
    @FindBy(xpath = "//div[text()='Upload a Video']")
    public WebElement uploadVideoTab;
    @FindBy(xpath = "//div[text()='Upload a Video']/following-sibling::input[@type='file']")
    private WebElement uploadVideo;
    @FindBy(xpath = "(//div[normalize-space()='Saved'])[1]")
    private WebElement cloudIcon;
    @FindBy(xpath = "//button[text()='Add MCQ']")
    private WebElement addMCQBtn;
    @FindBy(xpath = "//div[text()='Name of module']")
    private WebElement quizModuleTitle;
    @FindBy(xpath = "(//div[@class='grow']//div/input)[1]")
    private WebElement enterQuizName;
    @FindBy(xpath = "(//div[@class='relative flex w-full items-center']/input)[1]")
    private WebElement enterQuestion;
    @FindBy(xpath = "(//div[@class='relative flex w-full items-center']/input)[2]")
    private WebElement enterOptions1;
    @FindBy(xpath = "(//div[@class='relative flex w-full items-center']/input)[3]")
    private WebElement enterOptions2;
    @FindBy(xpath = "(//div[@class='flex items-center gap-2 text-sm']/input)//..//div/input")
    private List<WebElement> selectOptions;
    @FindBy(xpath = "(//div[@class='flex items-center gap-2 text-sm']/input)//..//input[@type='radio']")
    private List<WebElement> option;
    @FindBy(xpath = "//button[contains(@id,'headlessui-listbox-button-')]")
    private WebElement choiceDropdown;
    @FindBy(xpath = "//li/span")
    private List<WebElement> choiceList;
    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    public WebElement publishBtn;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement publishForPollBtn;
    @FindBy(xpath = "//p[text()='Are you sure?']")
    private WebElement confirmMsg;
    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//button/span[contains(text(),'Lesson Details')]")
    private WebElement lessonDetailsTab;
    @FindBy(xpath = "//table[contains(@class,'w-full overflow-hidden')]/tbody[1]/tr/td[2]")
    private List<WebElement> modulesList;
    @FindBy(xpath = "//*[local-name() = 'svg']")
    private WebElement navigateBack;
    @FindBy(xpath = "//td[contains(@class,'border border-gray-50')]//a")
    private List<WebElement> activityNamesList;
    //    @FindBy(xpath = "//input[@placeholder='Type something to search']")
    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    private WebElement searchBar;
    @FindBy(xpath = "//div[contains(@class,'scrollbar-hidden mt-2')]//div/button")
    private List<WebElement> statusList;
    @FindBy(xpath = "(//div[@class='relative h-[368px] w-[658px]']//div)[3]")
    private WebElement welcomeBtn;
    @FindBy(xpath = "//div[@class='flex min-h-full items-center justify-center text-center sm:p-4']")
    private WebElement otherSpace;
    @FindBy(xpath = "//table/tbody[1]/tr/td[2]")
    private List<WebElement> groupNameList;
    @FindBy(xpath = "//table/tbody[1]/tr/td[3]")
    private List<WebElement> createdByList;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-menu-button')])[1]")
    private WebElement activityMenuBtn;
    @FindBy(xpath = "(//div[contains(@id,'headlessui-menu-item') and contains(text(),'Activate')])")
    private WebElement activateBtn;
    @FindBy(xpath = "(//div[contains(@id,'headlessui-menu-item') and contains(text(),'Deactivate')])")
    private WebElement deactivateBtn;
    @FindBy(xpath = "//form/div[@class=' cursor-default text-black']")
    public WebElement toastMsg;
    @FindBy(xpath = "(//div[@class='fixed inset-0 overflow-y-auto']//p)[1]")
    private WebElement deactivateMsg;
    @FindBy(xpath = "//table/tbody[1]/tr/td[4]/div/div")
    private WebElement activityStatus;
    @FindBy(xpath = "//button[contains(@id,'headlessui-tabs-tab')]//span")
    private List<WebElement> editTabs;
    @FindBy(xpath = "//div/p[@title]")
    private List<WebElement> activityList;
    @FindBy(xpath = "//div/p[@title]")
    private WebElement firstActivity;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//span[@class='block truncate py-1 text-gray-280']")
    private WebElement participantGroupTag;
    @FindBy(xpath = "//span[@class='block truncate ui-open:ui-selected:text-primary-900']")
    List<WebElement> participantGroupList;
    @FindBy(xpath = "//input[@name='tag'] ")
    private WebElement campaignTag;
    @FindBy(xpath = "//div[@class='ml-2 cursor-pointer']")
    private WebElement scheduleSectionTag;
    @FindBy(xpath = "//div[@class='mt-2 cursor-pointer']")
    private WebElement scheduleSectionTagForPoll;
    @FindBy(xpath = "//input[@placeholder='Start date']")
    private WebElement startDateCal;
    @FindBy(xpath = "//button[normalize-space()='Schedule']")
    private WebElement scheduleBtn;
    @FindBy(xpath = "//div[@class=' cursor-default text-black']")
    private WebElement successToastMessage;
    @FindBy(xpath = "//*[@class='cursor-pointer text-gray-850']")
    public WebElement closeToastMessage;
    @FindBy(xpath = "//tr[(contains(@class,'hover:bg-gray-'))]//p")
    List<WebElement> campaignNameList;
    @FindBy(xpath = "//*[@class='cursor-pointer']")
    private WebElement campaignDetailsBtn;
    @FindBy(xpath = "//button[text()='scheduled']")
    private WebElement scheduledTag;
    @FindBy(xpath = "//span[text()='Inactive']")
    private WebElement deactivateButton;
    @FindBy(xpath = "//span[text()='Settings']")
    private WebElement SettingsBtn;
    @FindBy(xpath = "//input[@placeholder='e.g. Preferred Training Time']")
    private WebElement pollsName;
    @FindBy(xpath = "//input[@placeholder='1. e.g. At what time would you prefer training sessions to be scheduled?']")
    private WebElement pollQuestion;
    @FindBy(xpath = "(//div[@class='mt-6 flex flex-col justify-items-stretch gap-5']//div[@class='relative flex w-full items-center']//input)[1]")
    private WebElement pollOption1;
    @FindBy(xpath = "(//div[@class='mt-6 flex flex-col justify-items-stretch gap-5']//div[@class='relative flex w-full items-center']//input)[2]")
    private WebElement pollOption2;
    @FindBy(xpath = "//button[normalize-space()='scheduled']")
    private WebElement scheduledBtn;
    @FindBy(xpath = "//span[@class='w-58 truncate']")
    List<WebElement> scheduledPollName;
    @FindBy(xpath = "//span[@class='w-58 truncate']")
    private WebElement scheduledPollNames;
    @FindBy(xpath = "//button[text()='inactive']")
    private WebElement inactiveBtn;
    @FindBy(xpath = "//p[(contains(@class,'text-lg font-bold'))]")
    private WebElement createActivityHeaderForCampaign;
    @FindBy(xpath = "//div[text()='Polls']")
    private WebElement headerForPoll;
    @FindBy(xpath = "//div[@class='relative flex w-full items-center']/input")
    private WebElement enterCourseName;
    @FindBy(xpath = "//div[@class='relative flex items-center']/textarea")
    private WebElement courseDescription;
    @FindBy(xpath = "//div[@class='flex items-center justify-center']//button")
    private WebElement menuBtn;
    @FindBy(xpath = "//tr[(contains(@class,'hover:bg-gray-'))]//p")
    private WebElement listOfName;
    //    @FindBy(xpath = "//span[@class='w-58 truncate']")
    @FindBy(xpath = "//tr[(contains(@class,'hover:bg-gray-'))]//p")
    private WebElement listOfPollsName;
    @FindBy(xpath = "//input[@placeholder='e.g. Register Now']")
    private WebElement labelName;
    @FindBy(xpath = "//input[@placeholder='Insert URL for event details']")
    private WebElement urlSendBtn;
    @FindBy(xpath = "//button[text()='active']")
    private WebElement activetag;
    @FindBy(xpath = "//div[@role='tablist']//button[@data-headlessui-state]")
    private List<WebElement> statusSection;
    @FindBy(xpath = "//div[@class='relative group']/button")
    private List<WebElement> relativeGroupBtn;
    @FindBy(xpath = "//div[contains(@id,'headlessui-menu-items')]/button/span")
    private List<WebElement> menuBtns;
    @FindBy(xpath = "//*[@class='cursor-pointer text-gray-850']")
    private WebElement popUpRemover;
    @FindBy(xpath = "//span[text()='Liked']")
    private WebElement likedBtn;
    @FindBy(xpath = "//span[text()='Saved']")
    private WebElement savedBtn;
    @FindBy(xpath = "//div[@id='my-profile-icon']")
    private WebElement profileBtn;
    @FindBy(xpath = "//div[@data-tooltip-id='like']//span")
    private WebElement likeCountNumber;
    @FindBy(xpath = "(//div[@class='cursor-pointer text-center'])[2]")
    private WebElement commendCountNumber;
    @FindBy(xpath = "(//div[@class='cursor-pointer text-center'])[3]")
    private WebElement savedCountNumber;
    @FindBy(xpath = " //div[normalize-space()='Pending']//parent::div[@role='button']//div")
    private WebElement pendingCountNumber;
    @FindBy(xpath = " //div[normalize-space()='Completed']//parent::div[@role='button']//div")
    private WebElement completedCountNumber;
    @FindBy(xpath = "//div[@class='text-xs font-semibold']")
    List<WebElement> pollInPendingSection;
    @FindBy(xpath = "//div[contains(@class,'text-sm')]//parent::div[@class='relative']")
    List<WebElement> listOfQaAndAnswer;
    @FindBy(xpath = "//div[@class='relative']//div[@class='home-reel group relative snap-start snap-always']//video")
    List<WebElement> videoId;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "(//div[@class='text-3xl'])[1]")
    private WebElement completedCountUI;
    @FindBy(xpath = "(//div[@class='text-3xl'])[2]")
    private WebElement startedCountUI;
    @FindBy(xpath = "(//div[@class='text-3xl'])[3]")
    private WebElement pendingCountUI;
    @FindBy(xpath = "//div[@class='text-xs font-semibold']")
    List<WebElement> listOfSection;
    @FindBy(xpath = "//div[@class='text-xs font-semibold']//span")
    private WebElement countOfSection;
    @FindBy(xpath = "//div[normalize-space()='Pending']")
    private WebElement pendingSection;
    @FindBy(xpath = "//button[text()='active']")
    private WebElement activeBtn;
    @FindBy(xpath = "//button[normalize-space()='Done']")
    private WebElement doneBtnForSingleVideo;
    @FindBy(xpath = "(//button[normalize-space()='Done'])[2]")
    private WebElement doneBtnForSingleVideo1;
    @FindBy(xpath = "//div[normalize-space(text())='Course']//..//..//button")
    private WebElement doneBtnAfterCourseCompletion;
    @FindBy(xpath = "((//div[contains(@class,'overflow-hidden text-ellipsis whitespace-nowrap')])//parent::*)[1]//*")
    private WebElement backBtnInsideTheCourseTab;
    @FindBy(xpath = "//div[contains(@class,'flex grow flex-col gap-')]")
    List<WebElement> listOfQuiz;
    @FindBy(xpath = "//button[@type='button' and text()='Participate']")
    private WebElement ParticipateTag;
    @FindBy(xpath = "//div[text()='Activities']")
    private WebElement activitiesTag;
    @FindBy(xpath = "//div[contains(@class,'ml-auto flex w-')]")
    List<WebElement> countActivitiesListInParticipate;
    @FindBy(xpath = "//div[@class='text-sm font-bold']")
    List<WebElement> activitiesListInsideParticipate;
    @FindBy(xpath = "//div[@class='line-clamp-1 text-xs font-semibold']")
    List<WebElement> listOfElementBelowTheActivities;
    @FindBy(xpath = "//div[@class='flex items-center']//p")
    private WebElement campaignName;
    @FindBy(xpath = "//div[@class='flex flex-col justify-between overflow-hidden']")
    List<WebElement> campaignVideoList;
    @FindBy(xpath = "//*[@class='cursor-pointer text-gray-0']")
    private WebElement newVideoAddTag;
    @FindBy(xpath = "//input[@id='videoUpload']")
    private WebElement videoUploadTag;
    @FindBy(xpath = "//p[@class='w-20 truncate text-left']")
    private WebElement tagName;
    @FindBy(xpath = "//button[text()='Publish']")
    private WebElement publishBtns;
    @FindBy(xpath = "(//div[contains(@class,'absolute bottom-')])[1]//div[@data-tooltip-id='like']//*[@fill='currentColor']")
    private WebElement afterLikeBtn;
    @FindBy(xpath = "(//div[contains(@class,'absolute bottom-')])[1]//div[@data-tooltip-id='like']//*[@fill='none']")
    private WebElement beforeLikeBtn;
    @FindBy(xpath = "(//div[contains(@class,'absolute bottom-')])[1]//div[@class='cursor-pointer text-center'][2]")
    private WebElement commendBtn;
    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    private WebElement commendPlaceholderBtn;
    @FindBy(xpath = "//*[@fill='#ADB5BD']")
    private WebElement sendBtn;
    @FindBy(xpath = "(//div[contains(@class,'absolute bottom-')])[1]//div[@class='cursor-pointer text-center'][3]")
    private WebElement tagBtn;
    @FindBy(xpath = "//div[@class=' cursor-default text-black']")
    private WebElement tagPopUp;
    @FindBy(xpath = "//*[@class='cursor-pointer']")
    private WebElement shareBtn;
    @FindBy(xpath = "//button[@aria-haspopup='menu']")
    public WebElement menuBtnInActivities;
    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editBtn;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteBtn;
    @FindBy(xpath = "//button[text()='Report']")
    public WebElement reportBtn;
    @FindBy(xpath = "//div[text()='This video will be permanently deleted.']")
    private WebElement deletePopUpPage;
    @FindBy(xpath = "//div[text()='Video has been deleted.']")
    private WebElement deletedPopUp;
    @FindBy(xpath = "//span[text()='Active']")
    private WebElement activateButton;
    @FindBy(xpath = "//div[text()='Sales Bot']")
    private WebElement salesBotTag;
    @FindBy(xpath = "//input[@placeholder='Type here...']")
    private WebElement inputTagForSalesBot;
    @FindBy(xpath = "//div[@class='flex cursor-pointer items-center']//*")
    private WebElement sndBtnTag;
    public SoftAssert softAssert = new SoftAssert();
    List<String> groupNames = new ArrayList<>();
    public String activity;
    public String activityName;
    public static String StoredName;
    public static String StoredEditedName;
    public int likeCount;
    public int afterLikeCount;
    public int savedCount;
    public int afterSavedCount;
    public int pendingCount;
    public int completedCount;
    public int startedCount;
    public int AfterPendingCount;
    public int AfterCompletedCount;
    int value;
    int increaseCount = 0;
    public String course = "";
    public String activities = "";
    private static final Logger log = LogManager.getLogger();

    public void waitUntilLoadComplete() throws InterruptedException {
        try {
            while (loadingXpath.isDisplayed()) {
                Thread.sleep(waitTime5000MillSec);
            }
        } catch (Exception exc) {
            Thread.sleep(waitTime5000MillSec);
        }
    }

//    public void clickOnTheChevronDownIcon() {
//        try {
//            activitiesPage.waitUntilLoadComplete();
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
//            WebElement chevronIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav']//button[contains(@id,'headlessui-menu-button-:')]")));
//            chevronIcon.click();
//        } catch (Exception exc) {
//            webDriverHelper.takeAScreenShot("_clickOnTheChevronDownIcon.jpg");
//            Assert.fail("Failed in the method clickOnTheChevronDownIcon due to exception :- " + exc);
//        }
//    }

    public void clickOnAdminConsoleAndVerify() {
        try {
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(adminConsole, waitTime90Sec, pollingInterval1Sec);
            adminConsole.click();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(adminHomePageTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(recentActivity, waitTime120Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnAdminConsoleAndVerify.jpg");
            Assert.fail("Failed in the method clickOnAdminConsoleAndVerify due to exception :- " + exc);
        }
    }


    public void insideActivitiesMenuSelectOption(String activities) {
        try {
            webDriverHelper.waitUntilVisible(activitiesTab, waitTime90Sec, pollingInterval1Sec);
            activitiesTab.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(activitiesList, waitTime90Sec, pollingInterval1Sec);
            Thread.sleep(waitTime5000MillSec);
            for (WebElement element : activitiesList) {
                String elementName = element.getText();
                if (elementName.contains(activities)) {
                    element.click();
                    activity = activities;
                    break;
                }
            }
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(activetag, waitTime90Sec, pollingInterval1Sec);
            if (activities.contains("Team Activity")) {
                String name = "Team activity";
                WebElement activityTabHeader = driver.findElement(By.xpath("//div[text()='" + name + "']"));
                webDriverHelper.waitUntilVisible(activityTabHeader, waitTime90Sec, pollingInterval1Sec);
                Assert.assertTrue(activityTabHeader.isDisplayed(), "Failed to verify the " + activities + " header.");
            } else {
                WebElement activityTabHeader = driver.findElement(By.xpath("//div[contains(text(),'" + activities + "')]"));
                webDriverHelper.waitUntilVisible(activityTabHeader, waitTime90Sec, pollingInterval1Sec);
                Assert.assertTrue(activityTabHeader.isDisplayed(), "Failed to verify the " + activities + " header.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_insideActivitiesMenuSelectOption.jpg");
            Assert.fail("Failed in the method insideActivitiesMenuSelectOption due to exception :- " + exc);
        }
    }

    public void clickOnCreateButton(String activities) {
        try {
            waitUntilLoadComplete();
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[(contains(@class,'flex items-center gap-'))]//button[text()]")));
            element.click();
            if (activities.contains("Campaign") || activities.contains("Team Activity") || activities.contains("Celebration") || activities.contains("Pitch Practice")) {
                webDriverHelper.waitUntilVisible(createActivityHeaderForCampaign, waitTime90Sec, pollingInterval1Sec);
                String headerText = createActivityHeaderForCampaign.getText().toLowerCase();
                Assert.assertTrue(headerText.toLowerCase().contains(activities.toLowerCase()), "Failed to verify the create " + activities + " title");
            } else if (activities.contains("Polls")) {
                webDriverHelper.waitUntilVisible(headerForPoll, waitTime90Sec, pollingInterval1Sec);
                String headerText = headerForPoll.getText().toLowerCase();
                Assert.assertTrue(headerText.contains("poll"), "Failed to verify the create " + activities + " title");
            } else {
                webDriverHelper.waitUntilVisible(createActivityHeader, waitTime90Sec, pollingInterval1Sec);
                String headerText = createActivityHeader.getText();
                Assert.assertTrue(headerText.contains(activities.toLowerCase()), "Failed to verify the create " + activities + " title");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnCreateButton.jpg");
            Assert.fail("Failed in the method clickOnCreateButton due to exception :- " + exc);
        }
    }

    public void enterTheNameAndDescription(String name) {
        try {
            webDriverHelper.waitUntilVisible(enterActivityName, waitTime90Sec, pollingInterval1Sec);
            activityName = name + "_Auto" + webDriverHelper.randomNumber();
            enterActivityName.sendKeys(activityName);
            webDriverHelper.waitUntilVisible(descriptionArea, waitTime90Sec, pollingInterval1Sec);
            String desMsg = activity + description;
            descriptionArea.sendKeys(desMsg);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheAndDescription.jpg");
            Assert.fail("Failed in the method enterTheAndDescription due to exception :- " + exc);
        }
    }

    public void assignTheCourseToTheOfGroups(int numberOfGroupsToSelect) {
        try {
            if (numberOfGroupsToSelect <= 0 || numberOfGroupsToSelect < groupsList.size()) {
                throw new IllegalArgumentException("Invalid number of groups to select");
            }
            webDriverHelper.waitUntilVisible(participantGroupSearchBar, waitTime90Sec, pollingInterval1Sec);
            participantGroupSearchBar.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(groupsList, waitTime90Sec, pollingInterval1Sec);
            Random random = new Random();

            for (int i = 0; i < numberOfGroupsToSelect; i++) {
                int randomIndex;
                WebElement randomElement;
                String randomElementText;
                do {
                    randomIndex = random.nextInt(groupsList.size());
                    randomElement = groupsList.get(randomIndex);
                    randomElementText = groupsList.get(randomIndex).getText();
                } while (randomElement.isSelected()); // Ensure the element is not already selected

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomElement);
                randomElement.click();
                groupNames.add(randomElementText);
            }
            webDriverHelper.waitUntilVisible(groupsSelected.get(0), waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < groupsSelected.size(); i++) {
                String elementText = groupsSelected.get(i).getText();
                Assert.assertEquals(groupNames.get(i), elementText, "Failed to verify the selected " + groupNames.get(i) + " course in the participant tab " + groupsSelected.get(i));
            }
            participantGroupSearchBar.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_assignTheCourseToTheOfGroups.jpg");
            Assert.fail("Failed in the method assignTheCourseToTheOfGroups due to exception :- " + exc);
        }
    }

    public void participantGroup(String groupName) {
        try {
            webDriverHelper.waitUntilVisible(participantGroupSearchBar, waitTime90Sec, pollingInterval1Sec);
            participantGroupSearchBar.click();
            for (WebElement groups : groupsList) {
                String groupNameText = groups.getText();
                if (groupNameText.contains(groupName)) {
                    webDriverHelper.scrollToWebElement(groups);
                    groupNames.add(groups.getText());
                    groups.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_participantGroup.jpg");
            Assert.fail("Failed in the method participantGroup due to exception :- " + exc);
        }
    }

    public void verifyTheTitleAfterClickingOnCreateBtn() {
        try {
            webDriverHelper.waitUntilVisible(create, waitTime90Sec, pollingInterval1Sec);
            create.click();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(courseNameAsTitle, waitTime90Sec, pollingInterval1Sec);
            String courseName = courseNameAsTitle.getText();
            Assert.assertEquals(courseName, activityName, "Failed to verify the course title and course name");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheTitleAfterClickingOnCreateBtn.jpg");
            Assert.fail("Failed in the method verifyTheTitleAfterClickingOnCreateBtn due to exception :- " + exc);
        }
    }

    public void selectOptionAndEnterModuleName(String module) {
        try {
//            webDriverHelper.waitUntilVisible(modules, waitTime90Sec, pollingInterval1Sec);
//            modules.click();
            WebElement addBtn = driver.findElement(By.xpath("//div[text()='" + module + "']"));
            webDriverHelper.waitUntilVisible(addBtn, waitTime90Sec, pollingInterval1Sec);
            addBtn.click();
            Thread.sleep(waitTime5000MillSec);
            if (module.equals("Video")) {
                webDriverHelper.waitUntilVisible(enterModuleTitle, waitTime90Sec, pollingInterval1Sec);
                enterModuleTitle.click();
                enterModuleTitle.clear();
                activityVideoName = activity + addVideoName;
                enterModuleTitle.sendKeys(activityVideoName + Keys.ENTER);
            }
            if (module.equals("Quiz")) {
                webDriverHelper.waitUntilVisible(enterModuleTitle, waitTime90Sec, pollingInterval1Sec);
                enterModuleTitle.click();
                enterModuleTitle.clear();
                activityQuizName = activity + addQuizName;
                enterModuleTitle.sendKeys(activityQuizName + Keys.ENTER);
            }
            Thread.sleep(waitTime5000MillSec);
//            Assert.assertEquals(addVideoText, attachVideoTitle, "Failed to verify the title for add video popup page");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAddAVideoOption.jpg");
            Assert.fail("Failed in the method selectAddAVideoOption due to exception :- " + exc);
        }
    }

    public void uploadAVideoAndEnterModuleName() {
        try {
            webDriverHelper.waitUntilVisible(uploadVideoTab, waitTime90Sec, pollingInterval1Sec);
            uploadVideo.sendKeys(filePath);
            webDriverHelper.waitUntilVisible(cloudIcon, waitTime90Sec, pollingInterval1Sec);
            WebElement enterVideoTitle = driver.findElement(By.xpath("//input[@placeholder='Enter " + activity + " name']"));
            webDriverHelper.waitUntilVisible(enterVideoTitle, waitTime90Sec, pollingInterval1Sec);
            enterVideoTitle.clear();
            String name = activity + addVideoName;
            enterVideoTitle.sendKeys(name);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_uploadAVideoAndEnterModuleName.jpg");
            Assert.fail("Failed in the method uploadAVideoAndEnterModuleName due to exception :- " + exc);
        }
    }

    public void selectModuleAndAddMCQ() {
        try {
            webDriverHelper.waitUntilVisible(modules, waitTime90Sec, pollingInterval1Sec);
            modules.click();
            webDriverHelper.waitUntilVisible(addMCQBtn, waitTime90Sec, pollingInterval1Sec);
            addMCQBtn.click();
            webDriverHelper.waitUntilVisible(quizModuleTitle, waitTime90Sec, pollingInterval1Sec);
            Assert.assertEquals(quizModuleTitle.getText(), quizModule, "Failed to verify the quiz module title");

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectModuleAndAddMCQ.jpg");
            Assert.fail("Failed in the method selectModuleAndAddMCQ due to exception :- " + exc);
        }
    }

    public void enterTheDetailsAndSelect(String choice) {
        try {
//            webDriverHelper.waitUntilVisible(enterQuizName, waitTime90Sec, pollingInterval1Sec);
//            enterQuizName.clear();
//            String name = activity + addQuizName;
//            enterQuizName.sendKeys(name);
            webDriverHelper.waitUntilVisible(choiceDropdown, waitTime90Sec, pollingInterval1Sec);
            wait.until(ExpectedConditions.elementToBeClickable(choiceDropdown)).click();
            webDriverHelper.waitUntilVisibilityOfAllElements(choiceList, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : choiceList) {
                String elementName = element.getText();
                if (elementName.contains(choice)) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(enterQuestion, waitTime90Sec, pollingInterval1Sec);
            enterQuestion.clear();
            enterQuestion.sendKeys(quizQuestion);
            webDriverHelper.waitUntilVisible(enterOptions1, waitTime90Sec, pollingInterval1Sec);
            enterOptions1.clear();
            enterOptions1.sendKeys(quizOption1);
            webDriverHelper.waitUntilVisible(enterOptions2, waitTime90Sec, pollingInterval1Sec);
            enterOptions2.clear();
            enterOptions2.sendKeys(quizOption2);
            webDriverHelper.waitUntilVisibilityOfAllElements(selectOptions, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < selectOptions.size(); i++) {
                String elementName = selectOptions.get(i).getAttribute("value");
                if (elementName.equals(quizOption1)) {
                    option.get(i).click();
                    break;
                }
            }
//            webDriverHelper.waitUntilVisible(cloudIcon, waitTime90Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheDetailsAndSelect.jpg");
            Assert.fail("Failed in the method enterTheDetailsAndSelect due to exception :- " + exc);
        }
    }

    public void clickOnThePublishCourseAndConfirm() {
        try {
            webDriverHelper.waitUntilVisible(publishBtn, waitTime90Sec, pollingInterval1Sec);
            publishBtn.click();
            webDriverHelper.waitUntilVisible(confirmMsg, waitTime90Sec, pollingInterval1Sec);
            String msg = confirmMsg.getText();
            Assert.assertEquals(msg, confirmMessage, "Failed to verify the confirm message after publishing");
            webDriverHelper.waitUntilVisible(confirmBtn, waitTime90Sec, pollingInterval1Sec);
            confirmBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnThePublishCourseAndConfirm.jpg");
            Assert.fail("Failed in the method clickOnThePublishCourseAndConfirm due to exception :- " + exc);
        }
    }

    public void verifyDetailsInLessonDetailsTab() {
        try {
            webDriverHelper.waitUntilVisible(lessonDetailsTab, waitTime90Sec, pollingInterval1Sec);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'w-full overflow-hidden')]/tbody[1]/tr/td[2]")));
            for (WebElement element : modulesList) {
                String moduleName = element.getText();
                String videoName = activity + addVideoName;
                String quizName = activity + addQuizName;
                if (!(moduleName.equals(quizName) || moduleName.equals(videoName))) {
                    Assert.fail("Failed to verify the details in the table " + moduleName + " are matching with " + quizName + " or " + videoName);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyDetailsInLessonDetailsTab.jpg");
            Assert.fail("Failed in the method verifyDetailsInLessonDetailsTab due to exception :- " + exc);
        }
    }

    public void navigateToDashboard(String activities) {
        try {
            webDriverHelper.waitUntilVisible(navigateBack, waitTime90Sec, pollingInterval1Sec);
            navigateBack.click();
            WebElement activityTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + activities + "')]")));
            Assert.assertTrue(activityTabHeader.isDisplayed(), "Failed to verify the " + activities + " header.");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToDashboard.jpg");
            Assert.fail("Failed in the method navigateToDashboard due to exception :- " + exc);
        }
    }

    public void verifyCreatedActivityInTable(String activities) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search " + activities + "')]")));
            element.click();
            element.sendKeys(activityName);
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(firstActivity, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(activityList, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            for (int i = 0; i < activityList.size(); i++) {
                String activity = activityList.get(i).getText();
                if (activity.equals(activityName)) {
                    flag = true;
                    String group = groupNameList.get(i).getText();
                    Assert.assertEquals(group, groupNames.get(0), "Failed to verify the " + groupNames.get(0) + " group in the table");
                    Assert.assertTrue(createdByList.get(i).getText().contains(PropertiesReader.applicationCreatedBy), "Failed to verify the created by " + createdByList.get(i).getText() + " name");
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the " + activityName + " name in the list.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyCreatedActivityInTable.jpg");
            Assert.fail("Failed in the method verifyCreatedActivityInTable due to exception :- " + exc);
        }
    }

    public void verifyThatCreatedIsDisplayedInScheduledState(String activities, String status) {
        try {
            Thread.sleep(waitTime5000MillSec);
            driver.navigate().refresh();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisibilityOfAllElements(statusSection, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            for (WebElement element : statusSection) {
                String selectedFilter = element.getText();
                if (selectedFilter.equalsIgnoreCase(status)) {
                    element.click();
                    verifyCreatedActivityInTable(activities);
                    flag = true;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the created activity " + activityName + ".");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsInDashboard.jpg");
            Assert.fail("Failed in the method verifyTheDetailsInDashboard due to exception :- " + exc);
        }
    }

    public void navigateToEditTab(String activity) {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisibilityOfAllElements(editTabs, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : editTabs) {
                String tabName = element.getText();
                if (tabName.contains(activity)) {
                    webDriverHelper.scrollToWebElement(element);
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsInDashboard.jpg");
            Assert.fail("Failed in the method verifyTheDetailsInDashboard due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "//span[text()='Modules']//../*[local-name()='svg']")
    private WebElement modulesBtn;

    public void editTheCreatedDetails() {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(modulesBtn, waitTime90Sec, pollingInterval1Sec);
            modulesBtn.click();
            activitiesPage.waitUntilLoadComplete();
//            navigateToEditTab(activity);
//            webDriverHelper.waitUntilVisible(enterActivityName, waitTime90Sec, pollingInterval1Sec);
//            enterActivityName.clear();
//            activityName = activity + "_Auto" + webDriverHelper.randomNumber();
//            enterActivityName.sendKeys(activityName);
//            webDriverHelper.waitUntilVisible(descriptionArea, waitTime90Sec, pollingInterval1Sec);
//            descriptionArea.clear();
//            String desMsg = activity + description;
//            descriptionArea.sendKeys(desMsg + "-edit");
//            webDriverHelper.waitUntilVisible(publishBtn, waitTime90Sec, pollingInterval1Sec);
//            publishBtn.click();
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
//                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
//                String successMsg = toastMsg.getText();
//                String msg = activity + updatedMsg;
//                Assert.assertEquals(successMsg, msg, "Failed to verify the toast message");
//            } catch (Exception exc) {
//                softAssert.fail("Unable to verify the toast message due to " + exc.getMessage());
//            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_editTheCreatedDetails.jpg");
            Assert.fail("Failed in the method editTheCreatedDetails due to exception :- " + exc);
        }
    }

    public void editTheLessonDetailsForCreated(String lesson) {
        try {
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            driver.navigate().refresh();
            webDriverHelper.waitUntilVisible(firstActivity, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(activityName);
            WebElement courseDetails = driver.findElement(By.xpath("//p[text()='" + activityName + "']"));
            webDriverHelper.waitUntilVisible(courseDetails, waitTime90Sec, pollingInterval1Sec);
            courseDetails.click();
            navigateToEditTab(lesson);
            webDriverHelper.waitUntilVisible(addModule, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.scrollToWebElement(addModule);
            Thread.sleep(waitTime5000MillSec);
            addModule.click();
            webDriverHelper.waitUntilVisible(cloudIcon, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(courseNameAsTitle, waitTime90Sec, pollingInterval1Sec);
            String courseName = courseNameAsTitle.getText();
            Assert.assertEquals(courseName, activityName, "Failed to verify the course title and course name");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_editTheLessonDetailsForCreated.jpg");
            Assert.fail("Failed in the method editTheLessonDetailsForCreated due to exception :- " + exc);
        }
    }

    public void statusNavigation(String status) {
        try {
            waitUntilLoadComplete();
            boolean flag = false;
            webDriverHelper.waitUntilVisibilityOfAllElements(statusSection, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : statusSection) {
                String elementName = element.getText();
                if (elementName.equals(status)) {
                    flag = true;
                    element.click();
                    exceptionHandling(firstActivity);
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify and click the " + status);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToScheduledState.jpg");
            Assert.fail("Failed in the method navigateToScheduledState due to exception :- " + exc);
        }
    }

    public void selectAnExisting(String activity) {
        try {
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(firstActivity, waitTime90Sec, pollingInterval1Sec);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search " + activity + "')]")));
            element.click();
            element.sendKeys(activity + "_Auto");
            for (WebElement webElement : activityList) {
                String activitiesName = webElement.getText();
                if (activitiesName.contains(activity + "_Auto")) {
                    webElement.click();
                    activityName = activitiesName;
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAnExisting.jpg");
            Assert.fail("Failed in the method selectAnExisting due to exception :- " + exc);
        }
    }

    public void verifyTheDetailsInActiveStateAfterActivatingTheCreated(String status, String activities) {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(relativeGroupBtn, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : relativeGroupBtn) {
                element.click();
                webDriverHelper.waitUntilVisibilityOfAllElements(menuBtns, waitTime90Sec, pollingInterval1Sec);
                for (WebElement element1 : menuBtns) {
                    String elementName = element1.getText();
                    System.out.println(elementName);
                    if (elementName.equals(status)) {
                        element1.click();
                        break;
                    }
                }
            }
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //form/div[@class=' cursor-default text-black']")));
                String successMsg = toastMsg.getText();
                String msg = activities + activatedMsg;
                Assert.assertEquals(successMsg, msg, "Failed to verify the toast message");
            } catch (Exception exc) {
                softAssert.fail("Unable to verify the toast message due to " + exc.getMessage());
            }
            Thread.sleep(waitTime5000MillSec);
            statusNavigation(status);
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search " + activities + "')]")));
            searchBar.clear();
            searchBar.sendKeys(activityName);
            webDriverHelper.waitUntilVisibilityOfAllElements(activityList, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            for (int i = 0; i < activityList.size(); i++) {
                String activity = activityList.get(i).getText();
                if (activity.equals(activityName)) {
                    flag = true;
                    Assert.assertTrue(createdByList.get(i).getText().contains(PropertiesReader.applicationCreatedBy), "Failed to verify the created by " + createdByList.get(i).getText() + " name");
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the " + activityName + " name in the list.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsInActiveStateAfterActivatingTheCreated.jpg");
            Assert.fail("Failed in the method verifyTheDetailsInActiveStateAfterActivatingTheCreated due to exception :- " + exc);
        }
    }

    public void verifyTheDetailsInInactiveStateAfterDeactivatingTheCreated(String status, String activities) {
        try {
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(firstActivity, waitTime90Sec, pollingInterval1Sec);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search " + activities + "')]")));
            element.click();
            element.sendKeys(activity);
            webDriverHelper.waitUntilVisible(firstActivity, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(activityList, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < activityList.size(); i++) {
                activityName = activityList.get(i).getText();
                if (activityName.contains(activities)) {
                    webDriverHelper.waitUntilVisibilityOfAllElements(relativeGroupBtn, waitTime90Sec, pollingInterval1Sec);
                    relativeGroupBtn.get(i).click();
                    webDriverHelper.waitUntilVisibilityOfAllElements(menuBtns, waitTime90Sec, pollingInterval1Sec);
                    for (WebElement element1 : menuBtns) {
                        String elementName = element1.getText();
                        System.out.println(elementName);
                        if (elementName.equals(status)) {
                            element1.click();
                            break;
                        }
                    }
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(deactivateMsg, waitTime90Sec, pollingInterval1Sec);
            String deactivateConfirmMsg = deactivateMsg.getText();
            Assert.assertEquals(deactivateConfirmMsg, "Do you want to deactivate this " + activity + "?", "Failed to verify the confirm message for deactivating");
            webDriverHelper.waitUntilVisible(confirmBtn, waitTime90Sec, pollingInterval1Sec);
            confirmBtn.click();
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //form/div[@class=' cursor-default text-black']")));
                String successMsg = toastMsg.getText();
                String msg = activities + deactivatedMsg;
                Assert.assertEquals(successMsg, msg, "Failed to verify the toast message");
            } catch (Exception exc) {
                softAssert.fail("Unable to verify the toast message due to " + exc.getMessage());
            }
            Thread.sleep(waitTime5000MillSec);
            statusNavigation(status);
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search " + activities + "')]")));
            searchBar.click();
            searchBar.sendKeys(activityName);
            webDriverHelper.waitUntilVisibilityOfAllElements(activityList, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            for (int i = 0; i < activityList.size(); i++) {
                String activity = activityList.get(i).getText();
                if (activity.equals(activityName)) {
                    flag = true;
                    Assert.assertTrue(createdByList.get(i).getText().contains(PropertiesReader.applicationCreatedBy), "Failed to verify the created by " + createdByList.get(i).getText() + " name");
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the " + activityName + " name in the list.");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsInInactiveStateAfterDeactivatingTheCreated.jpg");
            Assert.fail("Failed in the method verifyTheDetailsInInactiveStateAfterDeactivatingTheCreated due to exception :- " + exc);
        }
    }

    public void enterTheName(String activityName) {
        try {
            webDriverHelper.waitUntilVisible(inputName, waitTime90Sec, pollingInterval1Sec);
            StoredName = activityName + "_Auto" + webDriverHelper.randomNumber();
            inputName.sendKeys(StoredName);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheCampaignName.jpg");
            Assert.fail("Failed in the method enterTheCampaignName due to exception :- " + exc);
        }

    }

    public void enterTagName(String tagName) {
        try {
            webDriverHelper.waitUntilVisible(campaignTag, waitTime90Sec, pollingInterval1Sec);
            campaignTag.sendKeys(tagName + "Tag" + webDriverHelper.randomNumber());
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_theCampaignTag.jpg");
            Assert.fail("Failed in the method theCampaignTag due to exception :- " + exc);
        }
    }

    public void theScheduleSection() {
        try {
            webDriverHelper.waitUntilVisible(scheduleSectionTag, waitTime90Sec, pollingInterval1Sec);
            scheduleSectionTag.click();
            startDateCal.click();
            webDriverHelper.scrollToWebElement(startDateCal);
            startDateCal.clear();
            LocalDate currentDate = LocalDate.now();
            LocalDate nextDate = currentDate.plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            String formattedDate = nextDate.format(formatter);
            startDateCal.sendKeys(formattedDate);
            scheduleBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_theScheduleSection.jpg");
            Assert.fail("Failed in the method theScheduleSection due to exception :- " + exc);
        }
    }

    public void thePublishBtn() {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(publishBtn, waitTime90Sec, pollingInterval1Sec);
            publishForPollBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_thePublishBtn.jpg");
            Assert.fail("Failed in the method thePublishBtn due to exception :- " + exc);
        }
    }

    public void thePublishBtnOnPolls() {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(publishForPollBtn, waitTime90Sec, pollingInterval1Sec);
            publishForPollBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_thePublishBtn.jpg");
            Assert.fail("Failed in the method thePublishBtn due to exception :- " + exc);
        }
    }

    public void toastMessage(String activity) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            WebElement successToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' cursor-default text-black']")));
            String successMsg = successToastMessage.getText();
            String expectedMessage;
            if (activity.equals("Polls")) {
                expectedMessage = Constants.createdSuccessfullyForPolls;
            } else {
                expectedMessage = activity + Constants.createdSuccessfully;
            }
            Assert.assertEquals(successMsg.toLowerCase(), expectedMessage.toLowerCase(), "Failed to verify the success message");
            webDriverHelper.waitUntilVisible(closeToastMessage, waitTime90Sec, pollingInterval1Sec);
            closeToastMessage.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_toastMessage.jpg");
            Assert.fail("Failed in the method toastMessage due to exception :- " + exc);
        }
    }

    public void viewTheNewlyCreatedActivity(String activity) {
        try {
            webDriverHelper.waitUntilVisible(campaignDetailsBtn, waitTime90Sec, pollingInterval1Sec);
            campaignDetailsBtn.click();
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(scheduledTag, waitTime90Sec, pollingInterval1Sec);
            scheduledTag.click();
            boolean flag = false;
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(StoredName);
            Thread.sleep(waitTime10000MillSec); // due to for loading the table
            for (WebElement campaign : campaignNameList) {
                String campaignNames = campaign.getText();
                if (campaignNames.contains(StoredName)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Assert.fail("the new created " + activity + " name " + StoredName + " is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_viewTheNewlyCreatedCampaign.jpg");
            Assert.fail("Failed in the method viewTheNewlyCreatedCampaign due to exception :- " + exc);
        }
    }

    public void deactivateOption() {
        try {
            webDriverHelper.waitUntilVisible(activeBtn, waitTime90Sec, pollingInterval1Sec);
            activeBtn.click();
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            waitUntilLoadComplete();
            exceptionHandling(listOfName);
            StoredEditedName = listOfName.getText();
            searchBar.sendKeys(StoredEditedName);
            WebElement menuOption = driver.findElement(By.xpath("//p[@title='" + StoredEditedName + "']//..//*[contains(@class,'text-')]"));
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            menuOption.click();
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            deactivateButton.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_deactivateOption.jpg");
            Assert.fail("Failed in the method deactivateOption due to exception :- " + exc);
        }
    }

    public void inactiveOptionList(String activity) {
        try {
            driver.navigate().refresh();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(inactiveBtn, waitTime90Sec, pollingInterval1Sec);
            inactiveBtn.click();
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.click();
            searchBar.sendKeys(StoredEditedName);
            Thread.sleep(waitTime5000MillSec);
            boolean flag = false;
            for (WebElement campaign : campaignNameList) {
                String campaignNames = campaign.getText();
                if (campaignNames.contains(StoredEditedName)) {
                    flag = true;
                }
            }
            if (!flag) {
                Assert.fail("The modified " + activity + " name " + StoredEditedName + " is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_inactiveOptionList.jpg");
            Assert.fail("Failed in the method inactiveOptionList due to exception :- " + exc);
        }
    }

    public void editTheCreatedActivities(String editedName) {
        try {
            webDriverHelper.waitUntilVisible(SettingsBtn, waitTime90Sec, pollingInterval1Sec);
            //  the thread has been give to load the page
            Thread.sleep(waitTime5000MillSec);
            SettingsBtn.click();
            webDriverHelper.waitUntilVisible(inputName, waitTime90Sec, pollingInterval1Sec);
            inputName.clear();
            Thread.sleep(waitTime5000MillSec);
            StoredEditedName = editedName + "_Auto" + webDriverHelper.randomNumber();
            inputName.sendKeys(StoredEditedName);
            webDriverHelper.waitUntilVisible(publishForPollBtn, waitTime90Sec, pollingInterval1Sec);
            publishForPollBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_editTheCreatedActivities.jpg");
            Assert.fail("Failed in the method editTheCreatedActivities due to exception :- " + exc);
        }
    }

    public void enterThePollsName(String name) {
        try {
            webDriverHelper.waitUntilVisible(pollsName, waitTime90Sec, pollingInterval1Sec);
            StoredName = name + "_Auto" + webDriverHelper.randomNumber();
            pollsName.sendKeys(StoredName);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterThePollsName.jpg");
            Assert.fail("Failed in the method enterThePollsName due to exception :- " + exc);
        }
    }

    public void enterThePollsQuestionAndOptions() {
        try {
            webDriverHelper.waitUntilVisible(pollQuestion, waitTime90Sec, pollingInterval1Sec);
            pollQuestion.click();
            pollQuestion.sendKeys(Constants.pollQuestion);
            pollOption1.sendKeys(Constants.pollOption1);
            pollOption2.sendKeys(Constants.pollOption2);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterThePollsQuestionAndOptions.jpg");
            Assert.fail("Failed in the method enterThePollsQuestionAndOptions due to exception :- " + exc);
        }
    }

    public void setTimeForPolling() {
        try {
            webDriverHelper.waitUntilVisible(scheduleSectionTagForPoll, waitTime90Sec, pollingInterval1Sec);
            scheduleSectionTagForPoll.click();
            startDateCal.click();
            startDateCal.clear();
//          the thread to clear the old date and new date
            Thread.sleep(waitTime5000MillSec);
            LocalDate currentDate = LocalDate.now();
            LocalDate nextDate = currentDate.plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            String formattedDate = nextDate.format(formatter);
            startDateCal.sendKeys(formattedDate);
            scheduleBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_setTimeForPolling.jpg");
            Assert.fail("Failed in the method setTimeForPolling due to exception :- " + exc);
        }
    }

    public void verifyCreatingPolls(String activity) {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisible(campaignDetailsBtn, waitTime90Sec, pollingInterval1Sec);
            campaignDetailsBtn.click();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(scheduledBtn, waitTime90Sec, pollingInterval1Sec);
            wait.until(ExpectedConditions.elementToBeClickable(scheduledBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scheduledBtn);
            scheduledBtn.click();
            Thread.sleep(waitTime10000MillSec);
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(StoredName);
            boolean flag = false;
            for (WebElement campaign : campaignNameList) {
                String campaignNames = campaign.getText();
                if (campaignNames.contains(StoredName)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Assert.fail("The poll name is" + StoredName + " is not present in the list");
            }

        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyCreatingPolls.jpg");
            Assert.fail("Failed in the method verifyCreatingPolls due to exception :- " + exc);
        }
    }

    public void navigateBackToScheduledSection() {
        try {
            webDriverHelper.waitUntilVisible(scheduledBtn, waitTime90Sec, pollingInterval1Sec);
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.scrollToWebElement(scheduledBtn);
            scheduledBtn.click();
            waitUntilLoadComplete();
            exceptionHandling(listOfPollsName);
            StoredEditedName = listOfPollsName.getText();
            WebElement menuOption = driver.findElement(By.xpath("//p[@title='" + StoredEditedName + "']//..//*[contains(@class,'text-')]"));
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            menuOption.click();
            webDriverHelper.waitUntilVisible(deactivateButton, waitTime90Sec, pollingInterval1Sec);
            deactivateButton.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateBackToScheduledSection.jpg");
            Assert.fail("Failed in the method navigateBackToScheduledSection due to exception :- " + exc);
        }
    }

    public void inactiveOptionListInPollSection() {
        try {
            webDriverHelper.waitUntilVisible(inactiveBtn, waitTime90Sec, pollingInterval1Sec);
            inactiveBtn.click();
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(StoredEditedName);
            Thread.sleep(waitTime5000MillSec);
            boolean flag = false;
            for (WebElement campaign : campaignNameList) {
                String campaignNames = campaign.getText();
                if (campaignNames.contains(StoredEditedName)) {
                    flag = true;
                }
            }
            if (!flag) {
                Assert.fail("The polls name " + StoredEditedName + " is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_inactiveOptionListInPollSection.jpg");
            Assert.fail("Failed in the method inactiveOptionListInPollSection due to exception :- " + exc);
        }
    }

    public void navigateToScheduledSection() {
        try {
            webDriverHelper.waitUntilVisible(scheduledTag, waitTime90Sec, pollingInterval1Sec);
            scheduledTag.click();
            waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(listOfName, waitTime120Sec, pollingInterval1Sec);
            listOfName.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_pendingSection.jpg");
            Assert.fail("Failed in the method pendingSection due to exception :- " + exc);
        }
    }

    public void scheduledSection() {
        try {
            webDriverHelper.waitUntilVisible(scheduledBtn, waitTime90Sec, pollingInterval1Sec);
            scheduledBtn.click();
            waitUntilLoadComplete();
            exceptionHandling(listOfPollsName);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfPollsName);
            listOfPollsName.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_scheduledSection.jpg");
            Assert.fail("Failed in the method scheduledSection due to exception :- " + exc);
        }
    }

    public void verifyTheSuccessToastMessageForAfterUpdating(String activity) {
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement successToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
                String successMsg = successToastMessage.getText();
                String expectedMessage;
                if (activity.contains("Polls")) {
                    expectedMessage = Constants.updatedSuccessfullyForPolls;
                } else {
                    expectedMessage = activity + Constants.updatedSuccessfully;
                }
                Assert.assertEquals(successMsg.toLowerCase(), expectedMessage.toLowerCase(), "Failed to verify the updated pop message");
                WebElement closeToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cursor-pointer text-gray-850']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeToastMessage);
                closeToastMessage.click();
            } catch (Exception exc) {
                softAssert.fail("Unable to close the toast message that was displayed " + exc.getMessage());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSuccessToastMessageForAfterUpdating.jpg");
            Assert.fail("Failed in the method verifyTheSuccessToastMessageForAfterUpdating due to exception :- " + exc);
        }
    }

    public void toastMessageForDeactivation() {
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
                String successMsg = toastMsg.getText();
                String expectedMessage;
                if (activity.equals("Polls")) {
                    expectedMessage = "Poll " + StoredEditedName + Constants.deactivatedSuccessfullyForPolls;
                } else {
                    expectedMessage = activity + Constants.deactivatedSuccessfully;
                }
                Assert.assertEquals(successMsg.toLowerCase(), expectedMessage.toLowerCase(), "Failed to verify the popup message for the deactivated " + activity);
                WebElement closeToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cursor-pointer text-gray-850']")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeToastMessage);
                closeToastMessage.click();
            } catch (Exception exc) {
                softAssert.fail("Unable to close the toast message that was displayed " + exc.getMessage());
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_toastMessageForDeactivation.jpg");
            Assert.fail("Failed in the method toastMessageForDeactivation due to exception :- " + exc);
        }
    }

    public void exceptionHandling(WebElement element) throws InterruptedException {
        try {
            webDriverHelper.waitUntilVisible(element, waitTime200Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            driver.navigate().refresh(); // hard refresh
            activitiesPage.waitUntilLoadComplete();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("location.reload()");
            webDriverHelper.waitUntilVisible(element, waitTime200Sec, pollingInterval1Sec);
        }
    }

    public void enterUrl() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            WebElement labelName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='e.g. Register Now']")));
            labelName.clear();
            labelName.sendKeys(Constants.urlLabel);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterUrl.jpg");
            Assert.fail("Failed in the method _enterUrl due to exception :- " + exc);
        }
    }

    public void navigateToActivity(String activity) {
        try {
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(activitiesTag, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            webDriverHelper.waitUntilVisibilityOfAllElements(activitiesListInsideParticipate, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < activitiesListInsideParticipate.size(); i++) {
                String activityName = activitiesListInsideParticipate.get(i).getText();
                if (activityName.equalsIgnoreCase(activity) && activity.equalsIgnoreCase("Sales Bot")) {
                    activitiesListInsideParticipate.get(i).click();
                    flag = true;
                    break;
                } else if (activityName.equalsIgnoreCase(activity)) {
                    int activitie = Integer.parseInt(countActivitiesListInParticipate.get(i).getText());
                    if (activitie != 0) {
                        activitiesListInsideParticipate.get(i).click();
                        flag = true;
                        break;
                    } else {
                        activities = "NO activities";
                        System.out.println("The " + activity + " has no activity");
                    }
                }
            }
            if (!flag) {
                activities = "NO activities";
                System.out.println(activity + " activity tag is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToActivity.jpg");
            Assert.fail("Failed in the method navigateToActivity due to exception :- " + exc);
        }
    }

    public void navigateToCampaign(String activity) {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                if (activity.contains("Polls")) {
                    if (!Objects.equals(course, "there were no pending polls")) {
                        webDriverHelper.waitUntilVisibilityOfAllElements(pollInPendingSection, waitTime90Sec, pollingInterval1Sec);
                        StoredName = pollInPendingSection.get(0).getText();
                        pollInPendingSection.get(0).click();
                        Thread.sleep(waitTime3000MillSec);
                    }
                } else {
                    webDriverHelper.waitUntilVisibilityOfAllElements(listOfElementBelowTheActivities, waitTime90Sec, pollingInterval1Sec);
                    StoredName = listOfElementBelowTheActivities.get(0).getText();
                    listOfElementBelowTheActivities.get(0).click();
                    Thread.sleep(waitTime3000MillSec);
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToCampaign.jpg");
            Assert.fail("Failed in the method navigateToCampaign due to exception :- " + exc);
        }

    }

    public void ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin() {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                webDriverHelper.waitUntilVisible(campaignName, waitTime90Sec, pollingInterval1Sec);
                String name = campaignName.getText();
                if (!Objects.equals(name, StoredName)) {
                    Assert.fail("the tag name is not matching ");
                }
                Thread.sleep(waitTime5000MillSec);
                webDriverHelper.waitUntilVisibilityOfAllElements(campaignVideoList, waitTime90Sec, pollingInterval1Sec);
                campaignVideoList.get(0).click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin.jpg");
            Assert.fail("Failed in the method ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin due to exception :- " + exc);
        }
    }

    public void addNewVideo() {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                webDriverHelper.waitUntilVisible(newVideoAddTag, waitTime90Sec, pollingInterval1Sec);
                newVideoAddTag.click();
                Thread.sleep(waitTime5000MillSec);
                videoUploadTag.sendKeys(filePath);
                Thread.sleep(waitTime5000MillSec);
                webDriverHelper.waitUntilVisible(tagName, waitTime90Sec, pollingInterval1Sec);
                String name = tagName.getText();
                if (!Objects.equals(name, StoredName)) {
                    Assert.fail("the tag name is not matching while uploading video");
                }
                Thread.sleep(2000);
                webDriverHelper.waitUntilVisible(publishBtns, waitTime90Sec, pollingInterval1Sec);
                webDriverHelper.scrollToWebElement(publishBtns);
                publishBtns.click();
                webDriverHelper.waitUntilVisible(tagPopUp, waitTime90Sec, pollingInterval1Sec);
                String message = tagPopUp.getText();
                if (!message.contains(savedVideoMsg)) {
                    Assert.fail("the video uploaded popup message is not matching");
                }
                popUpRemover.click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_addNewVideo.jpg");
            Assert.fail("Failed in the method addNewVideo due to exception :- " + exc);
        }
    }

    public void toolTipVerification(String activity) {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                likeButton();
                commendButton();
                shareButton();
                tagButton();
                verifyLikedAndSavedVideo();
                clickOnParticipate();
                navigateToActivity(activity);
                navigateToCampaign(activity);
                ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin();
                menuButton();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_toolTipVerification.jpg");
            Assert.fail("Failed in the method toolTipVerification due to exception :- " + exc);
        }
    }

    public void likeButton() throws InterruptedException {
        int likedNumber;
        int afterLikedNumber;
        try {
            webDriverHelper.waitUntilVisible(beforeLikeBtn, waitTime90Sec, pollingInterval1Sec);
            likedNumber = Integer.parseInt(likeCountNumber.getText());
            beforeLikeBtn.click();
            int numbLiked = likedNumber + 1;
            afterLikeCount = likeCount + 1;
            Thread.sleep(waitTime3000MillSec);
            afterLikedNumber = Integer.parseInt(likeCountNumber.getText());
            Assert.assertEquals(numbLiked, afterLikedNumber, "the like count is not matching, which is displayed below the like option ");
        } catch (Exception exc) {
            webDriverHelper.waitUntilVisible(afterLikeBtn, waitTime90Sec, pollingInterval1Sec);
            likedNumber = Integer.parseInt(likeCountNumber.getText());
            afterLikeBtn.click();
            afterLikeCount = likeCount - 1;
            int numbLiked = likedNumber - 1;
            Thread.sleep(waitTime3000MillSec);
            afterLikedNumber = Integer.parseInt(likeCountNumber.getText());
            Assert.assertEquals(numbLiked, afterLikedNumber, "the like count is not matching, which is displayed below the like option ");
        }
    }

    public void commendButton() {
        try {
            int commendNumber;
            webDriverHelper.waitUntilVisible(commendBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(commendCountNumber, waitTime90Sec, pollingInterval1Sec);
            commendNumber = Integer.parseInt(commendCountNumber.getText());
            commendBtn.click();
            commendPlaceholderBtn.sendKeys(cmdMessage);
            sendBtn.click();
            Thread.sleep(waitTime3000MillSec);
            int afterCommendNumber = commendNumber + 1;
            commendNumber = Integer.parseInt(commendCountNumber.getText());
            Assert.assertEquals(afterCommendNumber, commendNumber, "the commend count is not matching, which is displayed below the commend option ");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_commendButton.jpg");
            Assert.fail("Failed in the method commendButton due to exception :- " + exc);
        }
    }

    public void tagButton() {
        try {
            int savedNumber;
            webDriverHelper.waitUntilVisible(tagBtn, waitTime90Sec, pollingInterval1Sec);
            savedNumber = Integer.parseInt(savedCountNumber.getText());
            tagBtn.click();
            webDriverHelper.waitUntilVisible(tagPopUp, waitTime90Sec, pollingInterval1Sec);
            String popUp = tagPopUp.getText();
            if (popUp.contains(tagSavedMessage)) {
                afterSavedCount = savedCount + 1;
                int savedNumb = savedNumber + 1;
                savedNumber = Integer.parseInt(savedCountNumber.getText());
                Assert.assertEquals(savedNumb, savedNumber, "the saved count is not matching, which is displayed below the saved option ");

            } else if (popUp.contains(tagRemovedMessage)) {
                afterSavedCount = savedCount - 1;
                int savedNumb = savedNumber - 1;
                savedNumber = Integer.parseInt(savedCountNumber.getText());
                Assert.assertEquals(savedNumb, savedNumber, "the saved count is not matching, which is displayed below the saved option ");
            } else {
                Assert.fail("PopUp message is not matching");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_commendButton.jpg");
            Assert.fail("Failed in the method commendButton due to exception :- " + exc);
        }
    }

    public void shareButton() {
        try {
            webDriverHelper.waitUntilVisible(shareBtn, waitTime90Sec, pollingInterval1Sec);
            shareBtn.isDisplayed();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_shareButton.jpg");
            Assert.fail("Failed in the method shareButton due to exception :- " + exc);
        }
    }

    public void menuButton() {
        try {
            webDriverHelper.waitUntilVisible(menuBtnInActivities, waitTime90Sec, pollingInterval1Sec);
            menuBtnInActivities.click();
            webDriverHelper.waitUntilVisible(deleteBtn, waitTime90Sec, pollingInterval1Sec);
            try {
                webDriverHelper.waitUntilVisible(editBtn, waitTime90Sec, pollingInterval1Sec);
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisible(reportBtn, waitTime90Sec, pollingInterval1Sec);
            }
            deleteBtn.click();
            webDriverHelper.waitUntilVisible(deletePopUpPage, waitTime90Sec, pollingInterval1Sec);
            deleteBtn.click();
            webDriverHelper.waitUntilVisible(deletedPopUp, waitTime90Sec, pollingInterval1Sec);
            String message = deletedPopUp.getText();
            Assert.assertTrue(message.contains(deletePopUpMsg), "the deleted video popup message is not matching");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_menuButton.jpg");
            Assert.fail("Failed in the method menuButton due to exception :- " + exc);
        }
    }

    public void verifyLikedAndSavedVideo() {
        try {
            webDriverHelper.waitUntilVisible(profileBtn, waitTime90Sec, pollingInterval1Sec);
            profileBtn.click();
            driver.navigate().refresh();
            activitiesPage.waitUntilLoadComplete();
            Thread.sleep(waitTime3000MillSec);
            webDriverHelper.waitUntilVisible(likedBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.scrollToWebElement(likedBtn);
            likedBtn.click();
            likeCount = campaignVideoList.size();
            Assert.assertEquals(likeCount, afterLikeCount, "the like count is not matching");
            webDriverHelper.waitUntilVisible(savedBtn, waitTime90Sec, pollingInterval1Sec);
            savedBtn.click();
            savedCount = campaignVideoList.size();
            Assert.assertEquals(savedCount, afterSavedCount, "the saved count is not matching");
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyLikedAndSavedVideo.jpg");
            Assert.fail("Failed in the method verifyLikedAndSavedVideo due to exception :- " + exc);
        }

    }

    public void getTheCountOfLikeAndSavedVideo() {
        try {
            webDriverHelper.scrollToWebElement(profileBtn);
            webDriverHelper.waitUntilVisible(profileBtn, 20, 1);
            profileBtn.click();
            Thread.sleep(3000);
            webDriverHelper.waitUntilVisible(likedBtn, 20, 1);
            webDriverHelper.scrollToWebElement(likedBtn);
            likedBtn.click();
            Thread.sleep(2000);
            likeCount = campaignVideoList.size();
            webDriverHelper.waitUntilVisible(savedBtn, 20, 1);
            savedBtn.click();
            Thread.sleep(2000);
            savedCount = campaignVideoList.size();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_getTheCountOfLikeAndSavedVideo.jpg");
            Assert.fail("Failed in the method getTheCountOfLikeAndSavedVideo due to exception :- " + exc);
        }
    }

    public void countOfCompleteAndPendingPolls() {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                Thread.sleep(waitTime3000MillSec);
                webDriverHelper.waitUntilVisible(completedCountNumber, waitTime90Sec, pendingCount);
                completedCount = Integer.parseInt(completedCountNumber.getText());
                webDriverHelper.waitUntilVisible(pendingCountNumber, waitTime90Sec, pendingCount);
                pendingCount = Integer.parseInt(pendingCountNumber.getText());
                if (pendingCount != 0) {
                    pendingCountNumber.click();
                } else {
                    course = "there were no pending polls";
                    System.out.println("there were no pending polls");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_countOfCompleteAndPendingVideo.jpg");
            Assert.fail("Failed in the method countOfCompleteAndPendingVideo due to exception :- " + exc);
        }
    }

    public void answerThePolls() {
        try {
            if ((!Objects.equals(course, "there were no pending polls")) && (!Objects.equals(activities, "NO activities"))) {
                webDriverHelper.waitUntilVisibilityOfAllElements(listOfQaAndAnswer, waitTime90Sec, pendingCount);
                for (int i = 1; i <= listOfQaAndAnswer.size(); i++) {
                    WebElement answer = driver.findElement(By.xpath("(//div[contains(@class,'text-sm text-gray-')])[" + i + "]//parent::div[@class='relative']//input[@type='radio']"));
                    answer.click();
                }
                webDriverHelper.waitUntilVisible(submitBtn, waitTime90Sec, pollingInterval1Sec);
                submitBtn.click();
                completedCount = completedCount + 1;
                pendingCount = pendingCount - 1;
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_answerThePolls.jpg");
            Assert.fail("Failed in the method answerThePolls due to exception :- " + exc);
        }
    }

    public void verifyTheCount(String activity) {
        try {
            if ((!Objects.equals(course, "there were no pending polls")) && (!Objects.equals(activities, "NO activities"))) {
                driver.findElement(By.xpath("//*[@class='cursor-pointer']")).click();
                Thread.sleep(waitTime3000MillSec);
                webDriverHelper.waitUntilVisible(completedCountNumber, waitTime90Sec, pendingCount);
                int afterActionCompletedCount = Integer.parseInt(completedCountNumber.getText());
                Assert.assertEquals(completedCount, afterActionCompletedCount, "the completed count is not matching in the polls");
                webDriverHelper.waitUntilVisible(pendingCountNumber, waitTime90Sec, pendingCount);
                int afterActionPendingCount = Integer.parseInt(pendingCountNumber.getText());
                Assert.assertEquals(pendingCount, afterActionPendingCount, "the pending count is not matching in the polls");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCount.jpg");
            Assert.fail("Failed in the method verifyTheCount due to exception :- " + exc);
        }
    }

    public void verifyPopUpMessageAfterAnswering() {
        try {
            if ((!Objects.equals(course, "there were no pending polls")) && (!Objects.equals(activities, "NO activities"))) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' cursor-default text-black']")));
                String successToastMessage = toastMsg.getText();
                Assert.assertEquals(successToastMessage, afterAnsweredQa, "the pop message is not matching after answering the qa");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCount.jpg");
            Assert.fail("Failed in the method verifyTheCount due to exception :- " + exc);
        }
    }

    public void clickOnParticipate() {
        try {
            webDriverHelper.waitUntilVisible(ParticipateTag, waitTime90Sec, pollingInterval1Sec);
            ParticipateTag.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnParticipate.jpg");
            Assert.fail("Failed in the method clickOnParticipate due to exception :- " + exc);
        }
    }

    public void getTheCountOfCompletedStartedAndPending(String activity) {
        try {
            if (!Objects.equals(activities, "NO activities")) {
                Thread.sleep(waitTime3000MillSec);
                webDriverHelper.waitUntilVisible(completedCountUI, waitTime90Sec, pollingInterval1Sec);
                completedCount = Integer.parseInt(completedCountUI.getText());
                webDriverHelper.waitUntilVisible(startedCountUI, waitTime90Sec, pollingInterval1Sec);
                startedCount = Integer.parseInt(startedCountUI.getText());
                webDriverHelper.waitUntilVisible(pendingCountUI, waitTime90Sec, pollingInterval1Sec);
                pendingCount = Integer.parseInt(pendingCountUI.getText());
                if (pendingCount == 0) {
                    System.out.println("there was no pending section to be completed for the " + activity + "");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_getTheCountOfCompletedStartedAndPending.jpg");
            Assert.fail("Failed in the method getTheCountOfCompletedStartedAndPending due to exception :- " + exc);
        }
    }

    public void selectTheFirstActivitiesInPendingSection() {
        try {
            if (pendingCount != 0) {
                Thread.sleep(waitTime3000MillSec);
                webDriverHelper.waitUntilVisible(pendingSection, waitTime90Sec, pollingInterval1Sec);
                pendingSection.click();
                webDriverHelper.waitUntilVisibilityOfAllElements(listOfSection, waitTime90Sec, pollingInterval1Sec);
                value = listOfSection.size();
                StoredName = listOfSection.get(increaseCount).getText();
                String numberOfCount = countOfSection.getText();
                String number = numberOfCount.substring(numberOfCount.lastIndexOf('/') + 1, numberOfCount.length() - 1);
                listOfSection.get(increaseCount).click();
                Thread.sleep(waitTime3000MillSec);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectTheFirstActivitiesInPendingSection.jpg");
            Assert.fail("Failed in the method selectTheFirstActivitiesInPendingSection due to exception :- " + exc);
        }
    }

    public void completeTheActivity() {
        try {
            if (pendingCount != 0) {
                Thread.sleep(waitTime5000MillSec);
                int videoSize = (videoId != null) ? videoId.size() : 0;
                int quizSize = (listOfQuiz != null) ? listOfQuiz.size() : 0;
                if ((videoSize >= 2 || quizSize >= 3) || (videoSize == 0 && quizSize == 0)) {
                    increaseCount++;
                    webDriverHelper.waitUntilVisible(backBtnInsideTheCourseTab, waitTime90Sec, pollingInterval1Sec);
                    backBtnInsideTheCourseTab.click();
                    Thread.sleep(waitTime3000MillSec);
                    webDriverHelper.waitUntilVisible(pendingSection, waitTime90Sec, pollingInterval1Sec);
                    pendingSection.click();
                    if ((listOfSection.size() > increaseCount || (videoSize == 0 && quizSize == 0)) && (value != increaseCount)) {
                        webDriverHelper.waitUntilVisibilityOfAllElements(listOfSection, waitTime90Sec, pollingInterval1Sec);
                        StoredName = listOfSection.get(increaseCount).getText();
                        listOfSection.get(increaseCount).click();
                        Thread.sleep(waitTime3000MillSec);
                        completeTheActivity();
                    } else {
                        System.out.println("there was no activity is as expected");
                        course = "there was no course";
                    }

                }
                //  only for video
                if (videoSize == 1 && quizSize == 0) {
                    for (int i = 0; i < videoId.size(); i++) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        String script = "return arguments[0].duration;";
                        Double duration = (Double) js.executeScript(script, videoId.get(i));
                        int totalSeconds = ((int) Math.round(duration)) + 1;
                        int total = totalSeconds * 1000;
                        ((JavascriptExecutor) driver).executeScript("arguments[0].play()", videoId.get(i));
                        boolean isVideoEnded = false;
                        long startTime = System.currentTimeMillis();
                        while (!isVideoEnded && (System.currentTimeMillis() - startTime) < (long) total) {
                            isVideoEnded = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].ended;", videoId.get(i));
                            if (!isVideoEnded) {
                                Thread.sleep(waitTime3000MillSec);
                            }
                        }

                    }
                    webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                    doneBtnForSingleVideo.click();
                }
                //  only for quiz
                if (videoSize == 0 && quizSize <= 2) {
                    if (quizSize == 2) {
                        for (int i = 1; i <= listOfQuiz.size(); i++) {
                            webDriverHelper.scrollToWebElement(listOfQuiz.get(i - 1));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfQuiz.get(i - 1));
                            List<WebElement> numberOfQuiz = driver.findElements(By.xpath("(//div[contains(@class,'flex grow flex-col gap-')])[" + i + "]//div[contains(@class,'text-sm')]//parent::div[@class='relative']"));
                            for (int j = 1; j <= numberOfQuiz.size(); j++) {
                                List<WebElement> answers = driver.findElements(By.xpath("(((//div[contains(@class,'flex grow flex-col gap-')])[" + i + "]//div[contains(@class,'text-sm')]//parent::div[@class='relative']//div[contains(@class,'flex flex-col gap-')])[" + j + "]//input[@type='radio'])[1]"));
                                for (WebElement answerClick : answers) {
                                    webDriverHelper.scrollToWebElement(answerClick);
                                    answerClick.click();
                                    Thread.sleep(waitTime300MillSec);
                                }

                            }
                            WebElement submitBtn = driver.findElement(By.xpath("(//button[text()='Submit'])[" + i + "]"));
                            submitBtn.click();
                            Thread.sleep(waitTime3000MillSec);
                            webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                            doneBtnForSingleVideo.click();
                            Thread.sleep(waitTime3000MillSec);
                        }
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                        doneBtnForSingleVideo.click();
                    }
                    if (quizSize == 1) {
                        for (int i = 1; i <= listOfQaAndAnswer.size(); i++) {
                            WebElement answer = driver.findElement(By.xpath("(//div[contains(@class,'pr-16 text-sm text-gray-')])[" + i + "]//parent::div[@class='relative']//input[@type='radio']"));
                            answer.click();
                        }
                        webDriverHelper.waitUntilVisible(submitBtn, waitTime90Sec, pollingInterval1Sec);
                        submitBtn.click();
                        Thread.sleep(waitTime3000MillSec);
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                        doneBtnForSingleVideo.click();
                        Thread.sleep(waitTime3000MillSec);
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                        doneBtnForSingleVideo.click();
                    }
                }
                // both video and quiz
                if (videoSize == 1 && quizSize >= 1) {
                    for (int i = 0; i < videoId.size(); i++) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        String script = "return arguments[0].duration;";
                        Double duration = (Double) js.executeScript(script, videoId.get(i));
                        int totalSeconds = ((int) Math.round(duration)) + 1;
                        int total = totalSeconds * 1000;
                        ((JavascriptExecutor) driver).executeScript("arguments[0].play()", videoId.get(i));
                        boolean isVideoEnded = false;
                        long startTime = System.currentTimeMillis();
                        while (!isVideoEnded && (System.currentTimeMillis() - startTime) < (long) total) {
                            isVideoEnded = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].ended;", videoId.get(i));
                            if (!isVideoEnded) {
                                Thread.sleep(waitTime3000MillSec);
                            }
                        }
                    }
                    if (quizSize == 1) {
                        for (int i = 1; i <= listOfQaAndAnswer.size(); i++) {
                            WebElement answer = driver.findElement(By.xpath("(//div[contains(@class,'text-sm text-gray-')])[" + i + "]//parent::div[@class='relative']//input[@type='radio']"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", answer);
                            answer.click();
                        }
                        webDriverHelper.waitUntilVisible(submitBtn, waitTime90Sec, pollingInterval1Sec);
                        submitBtn.click();
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo1, waitTime90Sec, pollingInterval1Sec);
                        webDriverHelper.scrollToWebElement(doneBtnForSingleVideo1);
                        doneBtnForSingleVideo1.click();
                        Thread.sleep(waitTime3000MillSec);
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                        webDriverHelper.scrollToWebElement(doneBtnForSingleVideo);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", doneBtnForSingleVideo);
                        doneBtnForSingleVideo.click();
                    }
                    if ((quizSize == 2)) {
                        for (int i = 1; i <= listOfQuiz.size(); i++) {
                            webDriverHelper.scrollToWebElement(listOfQuiz.get(i - 1));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listOfQuiz.get(i - 1));
                            List<WebElement> numberOfQuiz = driver.findElements(By.xpath("(//div[contains(@class,'flex grow flex-col gap-')])[" + i + "]//div[contains(@class,'text-sm')]//parent::div[@class='relative']"));
                            for (int j = 1; j <= numberOfQuiz.size(); j++) {
                                List<WebElement> answers = driver.findElements(By.xpath("(((//div[contains(@class,'flex grow flex-col gap-')])[" + i + "]//div[contains(@class,'text-sm')]//parent::div[@class='relative']//div[contains(@class,'flex flex-col gap-')])[" + j + "]//input[@type='radio'])[1]"));
                                for (WebElement answerClick : answers) {
                                    webDriverHelper.scrollToWebElement(answerClick);
                                    answerClick.click();
                                    Thread.sleep(waitTime300MillSec);
                                }

                            }
                            WebElement submitBtn = driver.findElement(By.xpath("(//button[text()='Submit'])[" + i + "]"));
                            submitBtn.click();
                            Thread.sleep(waitTime3000MillSec);
                            webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                            doneBtnForSingleVideo.click();
                            Thread.sleep(waitTime3000MillSec);
                        }
                        webDriverHelper.waitUntilVisible(doneBtnForSingleVideo, 60, 1);
                        doneBtnForSingleVideo.click();
                    }
                }
                AfterCompletedCount = completedCount + 1;
                AfterPendingCount = pendingCount - 1;
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_completeTheActivity.jpg");
            Assert.fail("Failed in the method completeTheActivity due to exception :- " + exc);
        }
    }

    public void verifyTheCourseCountAfterCompleting() {
        try {
            if (!(Objects.equals(course, "there was no course")) && ((pendingCount != 0))) {
                driver.navigate().refresh();
                waitUntilLoadComplete();
                Thread.sleep(waitTime5000MillSec);
                webDriverHelper.waitUntilVisible(completedCountUI, waitTime90Sec, pollingInterval1Sec);
                completedCount = Integer.parseInt(completedCountUI.getText());
                Assert.assertEquals(completedCount, AfterCompletedCount, "the completed count does not match after course completion");
                webDriverHelper.waitUntilVisible(startedCountUI, waitTime90Sec, pollingInterval1Sec);
                startedCount = Integer.parseInt(startedCountUI.getText());
                webDriverHelper.waitUntilVisible(pendingCountUI, waitTime90Sec, pollingInterval1Sec);
                pendingCount = Integer.parseInt(pendingCountUI.getText());
                Assert.assertEquals(pendingCount, AfterPendingCount, "the pending count does not match after course completion");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCourseCountAfterCompleting.jpg");
            Assert.fail("Failed in the method verifyTheCourseCountAfterCompleting due to exception :- " + exc);
        }
    }

    public void activateTheDeactivated() {
        try {
            WebElement menuOption = driver.findElement(By.xpath("//p[@title='" + StoredEditedName + "']//..//*[contains(@class,'text-')]"));
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            menuOption.click();
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            activateButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCourseCountAfterCompleting.jpg");
            Assert.fail("Failed in the method verifyTheCourseCountAfterCompleting due to exception :- " + exc);
        }
    }

    public void activateTheDeactivatedPolls() {
        try {
            WebElement menuOption = driver.findElement(By.xpath("//span[@title='" + StoredEditedName + "']//..//..//..//button[@class='flex content-center']"));
            webDriverHelper.waitUntilVisible(menuOption, waitTime90Sec, pollingInterval1Sec);
            menuOption.click();
            webDriverHelper.waitUntilVisible(activateButton, waitTime90Sec, pollingInterval1Sec);
            activateButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCourseCountAfterCompleting.jpg");
            Assert.fail("Failed in the method verifyTheCourseCountAfterCompleting due to exception :- " + exc);
        }
    }

    // new UI change
    @FindBy(xpath = "//button[text()='Add Modules']")
    private WebElement addModules;
    @FindBy(xpath = "//div[text()='Select 1 or multiple videos']")
    private WebElement uploadBtn;
    @FindBy(xpath = "//tr[contains(@class,'hover:bg-gray')]//td/div/input[@type='checkbox']")
    private List<WebElement> videosCheckboxList;
    @FindBy(xpath = "//tr[contains(@class,'hover:bg-gray')]//td[1]//p")
    private List<WebElement> videosList;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextBtn;
    public String videoName;
    public String activityVideoName;
    public String activityQuizName;

    public void enterTheNameAndClickOnAddModules(String name) {
        try {
            webDriverHelper.waitUntilVisible(enterActivityName, waitTime90Sec, pollingInterval1Sec);
            activityName = name + "_Auto" + webDriverHelper.randomNumber();
            enterActivityName.sendKeys(activityName);
            Thread.sleep(waitTime5000MillSec);
            enterActivityName.click();
//            if (addModules.isEnabled()) {
            webDriverHelper.waitUntilVisible(addModules, waitTime90Sec, pollingInterval1Sec);
            addModules.click();
//            } else {
//                webDriverHelper.waitUntilVisible(enterActivityName, waitTime90Sec, pollingInterval1Sec);
//                activityName = name + "_Auto" + webDriverHelper.randomNumber();
//                enterActivityName.sendKeys(activityName + Keys.ENTER);
//                Thread.sleep(waitTime5000MillSec);
//                webDriverHelper.waitUntilVisible(addModules, waitTime90Sec, pollingInterval1Sec);
//            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheNameAndClickOnAddModules.jpg");
            Assert.fail("Failed in the method enterTheNameAndClickOnAddModules due to exception :- " + exc);
        }
    }

    public void clickOnUploadButton() {
        try {
//            webDriverHelper.waitUntilVisible(enterModuleTitle, waitTime90Sec, pollingInterval1Sec);
//            enterModuleTitle.clear();
//            activityVideoName = activity + addVideoName;
//            enterModuleTitle.sendKeys(activityVideoName);
            webDriverHelper.waitUntilVisible(uploadBtn, waitTime90Sec, pollingInterval1Sec);
            uploadBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheModuleNameAndClickOnUploadButton.jpg");
            Assert.fail("Failed in the method enterTheModuleNameAndClickOnUploadButton due to exception :- " + exc);
        }
    }

    public void selectFolder(String type) {
        try {
            Thread.sleep(waitTime5000MillSec);
            WebElement folder = driver.findElement(By.xpath("//span[@title='" + type + "']//..//..//div[@class='cursor-pointer']"));
            webDriverHelper.waitUntilVisible(folder, waitTime60Sec, pollingInterval1Sec);
            folder.click();
//            Actions actions = new Actions(driver);
//            actions.doubleClick(folder).perform();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectFolder.jpg");
            Assert.fail("Failed in the method selectFolder due to exception :- " + exc);
        }
    }

    public void selectVideoAndClickOn(String addButton) {
        try {
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisibilityOfAllElements(videosCheckboxList, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < videosCheckboxList.size(); i++) {
                videoName = videosList.get(i).getText();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", videosCheckboxList.get(i));
                wait.until(ExpectedConditions.elementToBeClickable(videosCheckboxList.get(i))).click();
                break;
            }
            WebElement addBtn = driver.findElement(By.xpath("//div[text()=' " + addButton + "']"));
            addBtn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='" + videoName + "']")));
            webDriverHelper.waitUntilVisible(cloudIcon, waitTime120Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectVideoAndClickOnAddTo.jpg");
            Assert.fail("Failed in the method selectVideoAndClickOnAddTo due to exception :- " + exc);
        }
    }

    public void clickOnNextButton() {
        try {
            webDriverHelper.waitUntilVisible(nextBtn, waitTime90Sec, pollingInterval1Sec);
            nextBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNextButton.jpg");
            Assert.fail("Failed in the method clickOnNextButton due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "(//button[contains(@id,'headlessui-listbox-button')])[1]")
    private WebElement selectGroupBar;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-listbox-button')])[2]")
    private WebElement criteriaDropdown;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-listbox-button')])[3]")
    private WebElement revealAnswer;
    @FindBy(xpath = "//textarea")
    private WebElement enterDescription;
    @FindBy(xpath = "//button[text()='Continue to review']")
    private WebElement continueToReviewBtn;

    public void editTheOtherDetails() {
        try {
            webDriverHelper.waitUntilVisible(selectGroupBar, waitTime60Sec, pollingInterval1Sec);
            selectGroupBar.click();
            webDriverHelper.waitUntilVisible(criteriaDropdown, waitTime60Sec, pollingInterval1Sec);
            criteriaDropdown.click();
            for (WebElement element : choiceList) {
                String choiceName = element.getText();
                if (choiceName.equals("View all the modules only")) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(revealAnswer, waitTime60Sec, pollingInterval1Sec);
            revealAnswer.click();
            for (WebElement element : choiceList) {
                String choiceName = element.getText();
                if (choiceName.equals("Yes")) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNextButton.jpg");
            Assert.fail("Failed in the method clickOnNextButton due to exception :- " + exc);
        }
    }

    public void enterTheDescriptionForThe(String activity) {
        try {
            webDriverHelper.waitUntilVisible(enterDescription, waitTime60Sec, pollingInterval1Sec);
            enterDescription.sendKeys(activity + description);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheDescription.jpg");
            Assert.fail("Failed in the method enterTheDescription due to exception :- " + exc);
        }
    }

    public void clickOnContinueToReview() {
        try {
            webDriverHelper.waitUntilVisible(continueToReviewBtn, waitTime90Sec, pollingInterval1Sec);
            continueToReviewBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnContinueToReview.jpg");
            Assert.fail("Failed in the method clickOnContinueToReview due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "//div[contains(@class,'bg-red')]")
    private WebElement errorModule;
    @FindBy(xpath = "//div[contains(@class,'scrollbar-hidden')]//p[1]")
    private List<WebElement> modulesListInActivity;

    public void verifyTheModulesScheduleTheDateAndClickOnTheButton() {
        try {
            activitiesPage.waitUntilLoadComplete();
            Thread.sleep(waitTime5000MillSec);
            try {
                if (errorModule.isDisplayed()) {
                    Assert.fail("Failed because the module is not created properly");
                }
            } catch (Exception exc) {
                for (WebElement element : modulesListInActivity) {
                    String moduleName = element.getText();
                    if (!(moduleName.contains(videoName) || moduleName.contains(activityQuizName))) {
                        Assert.fail("Failed to verify the uploaded modules in review page");
                    }
                }
                webDriverHelper.waitUntilVisible(scheduleBtn, waitTime90Sec, pollingInterval1Sec);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scheduleBtn);
                scheduleBtn.click();
                webDriverHelper.waitUntilVisible(startDateCal, waitTime90Sec, pollingInterval1Sec);
//            startDateCal.click();
                webDriverHelper.scrollToWebElement(startDateCal);
                startDateCal.clear();
                LocalDate currentDate = LocalDate.now();
                LocalDate nextDate = currentDate.plusDays(1);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
                String formattedDate = nextDate.format(formatter);
                startDateCal.sendKeys(formattedDate);
                webDriverHelper.waitUntilVisible(scheduledPostBtn, waitTime90Sec, pollingInterval1Sec);
                scheduledPostBtn.click();
//                webDriverHelper.waitUntilVisible(publishBtn,waitTime90Sec,pollingInterval1Sec);
//                publishBtn.click();
                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
                String msg = toastMsg.getText();
                Assert.assertEquals(msg, "Course Scheduled Successfully!", "Failed to verify the toast message");
                activitiesPage.waitUntilLoadComplete();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheModulesAndClickOnPublishBtn.jpg");
            Assert.fail("Failed in the method verifyTheModulesAndClickOnPublishBtn due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "(//button[normalize-space()='Schedule'])[2]")
    private WebElement scheduledPostBtn;

    public void scheduleTheDate() {
        try {
            webDriverHelper.waitUntilVisible(scheduleBtn, waitTime90Sec, pollingInterval1Sec);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scheduleBtn);
            scheduleBtn.click();
            webDriverHelper.waitUntilVisible(startDateCal, waitTime90Sec, pollingInterval1Sec);
//            startDateCal.click();
            webDriverHelper.scrollToWebElement(startDateCal);
            startDateCal.clear();
            LocalDate currentDate = LocalDate.now();
            LocalDate nextDate = currentDate.plusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            String formattedDate = nextDate.format(formatter);
            startDateCal.sendKeys(formattedDate);
            scheduledPostBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_scheduleTheDate.jpg");
            Assert.fail("Failed in the method scheduleTheDate due to exception :- " + exc);
        }
    }

    public void scheduleTheDateAndClickOnButton() {
        try {
            activitiesPage.waitUntilLoadComplete();
            Thread.sleep(waitTime5000MillSec);
            try {
                if (errorModule.isDisplayed()) {
                    Assert.fail("Failed because the module is not created properly");
                }
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisible(scheduleBtn, waitTime90Sec, pollingInterval1Sec);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scheduleBtn);
                scheduleBtn.click();
                webDriverHelper.waitUntilVisible(startDateCal, waitTime90Sec, pollingInterval1Sec);
//            startDateCal.click();
                webDriverHelper.scrollToWebElement(startDateCal);
                startDateCal.clear();
                LocalDate currentDate = LocalDate.now();
                LocalDate nextDate = currentDate.plusDays(1);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
                String formattedDate = nextDate.format(formatter);
                startDateCal.sendKeys(formattedDate);
                webDriverHelper.waitUntilVisible(scheduledPostBtn, waitTime90Sec, pollingInterval1Sec);
                scheduledPostBtn.click();
//                webDriverHelper.waitUntilVisible(publishBtn,waitTime90Sec,pollingInterval1Sec);
//                publishBtn.click();
//                WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
//                String msg = toastMsg.getText();
//                Assert.assertEquals(msg, "Course Scheduled Successfully!", "Failed to verify the toast message");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_scheduleTheDateAndClickOnButton.jpg");
            Assert.fail("Failed in the method scheduleTheDateAndClickOnButton due to exception :- " + exc);
        }
    }

    public void clickOnInMenu(String manageType) {
        try {
            WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + manageType + "')]"));
            element.click();
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnInMenu.jpg");
            Assert.fail("Failed in the method clickOnInMenu due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "//div[contains(text(),'Sales Bot Setup')]")
    private WebElement salesBotSetUpBtn;
    @FindBy(xpath = "//div[contains(text(),'Setup Call Insights')]")
    private WebElement callInsightsSetUpMsg;
    public boolean videosFlag = false;

    public void verifyThePageAndSetup(String manageType) {
        try {
            try {
                if (callInsightsSetUpMsg.isDisplayed() || salesBotSetUpBtn.isDisplayed()) {
                    if (manageType.equals("Sales Bot")) {
                        salesBotSetUpBtn.click();
                    } else {
                        callInsightsSetUpMsg.click();
                    }
                }
            } catch (Exception exc) {
                System.out.println("It's already inside the sales bot");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyThePageAndSetup.jpg");
            Assert.fail("Failed in the method verifyThePageAndSetup due to exception :- " + exc);
        }
    }

    public void verifyTheSuccessMessageAfterUploadingTheVideoIn() {
        try {
            if(videosFlag) {
                webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
                String msg = toastMsg.getText();
                Assert.assertEquals(msg, salesBotSuccessMsg, "Failed to verify the toast message after uploading video");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSuccessMessageAfterUploadingTheVideoIn.jpg");
            Assert.fail("Failed in the method verifyTheSuccessMessageAfterUploadingTheVideoIn due to exception :- " + exc);
        }
    }

    public void selectVideoAndClickOnAddToSalesbotButton(String addButton) {
        try {
            Thread.sleep(waitTime5000MillSec);
//            webDriverHelper.waitUntilVisibilityOfAllElements(videosCheckboxList, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < videosCheckboxList.size(); i++) {
                videoName = videosList.get(i).getText();
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", videosCheckboxList.get(i));
                wait.until(ExpectedConditions.elementToBeClickable(videosCheckboxList.get(i))).click();
                videosFlag = true;
                break;
            }
            if (videosFlag) {
                WebElement addBtn = driver.findElement(By.xpath("//div[text()='" + addButton + "']"));
                addBtn.click();
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectVideoAndClickOnAddToSalesbotButton.jpg");
            Assert.fail("Failed in the method selectVideoAndClickOnAddToSalesbotButton due to exception :- " + exc);
        }
    }

    @FindBy(xpath = "(//div[contains(@class,'flex cursor-pointer')])[1]")
    private WebElement viewBtn;

    public void checkThe(String view) {
        try {
            webDriverHelper.waitUntilVisible(viewBtn, waitTime90Sec, pollingInterval1Sec);
            String viewText = viewBtn.getText();
            if (viewText.contains(view)) {
                viewBtn.click();
            } else {
                log.info("It's already in the View Insights");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_checkThe.jpg");
            Assert.fail("Failed in the method checkThe due to exception :- " + exc);
        }
    }
}

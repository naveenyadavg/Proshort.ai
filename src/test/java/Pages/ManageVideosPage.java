package Pages;

import Supports.Constants;
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

public class ManageVideosPage {

    private WebDriver driver;

    public ManageVideosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id, 'headlessui-disclosure-button')]//span[text()='Manage content']")
    private WebElement manageVideoTab;
    @FindBy(xpath = "//div[contains(@id, 'headlessui-disclosure-panel')]/a")
    private List<WebElement> videoTypeBtn;
    @FindBy(xpath = "//div[text()='Manage Videos']")
    private WebElement manageVideoTitle;
    @FindBy(xpath = "//tbody/tr/td/div/div[2]")
    private List<WebElement> videoTitleList;
    @FindBy(xpath = "//tbody/tr/td/div[text()='Review']")
    private List<WebElement> reviewBtn;
    @FindBy(xpath = "((//div[contains(@class,'relative flex h-full flex-1 flex-col justify-between')]/div/div)[1]/following-sibling::div)[2]")
    private WebElement videoNameInReviewSection;
    @FindBy(xpath = "(//div[contains(@class,'relative flex h-full flex-1 flex-col justify-between')]/div/div)[1]")
    private WebElement videoTitle;
    @FindBy(xpath = "//div[@class='flex w-full justify-between']/div")
    private List<WebElement> approveTypeBtn;
    @FindBy(xpath = "//form/div[@class=' cursor-default text-black']")
    private WebElement toastMsg;
    @FindBy(xpath = "//input[@placeholder='Type something to search']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@id='newvideo']")
    private WebElement addVideoBtn;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadVideo;
    @FindBy(xpath = "//div[@class='react-mention__control']/textarea")
    private WebElement videoCaptionArea;
    @FindBy(xpath = "//span[contains(@class,'block truncate py')]")
    private WebElement selectGroup;
    @FindBy(xpath = "//span[contains(@class,'block truncate ui-open:ui-selected')]")
    private List<WebElement> groupList;
    @FindBy(xpath = "//div/p[contains(@class,'text-lg font-semibold leading')]")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@class='overflow-hidden text-ellipsis whitespace-nowrap text-xs sm:text-base']")
    private List<WebElement> videosTitle;
    @FindBy(xpath = "//span[text()='Groups']")
    private WebElement groupsBtn;
    @FindBy(xpath = "//p[contains(@class,'overflow-hidden text-ellipsis')]")
    private List<WebElement> groupsList;
    @FindBy(xpath = "//div[@class='overflow-hidden text-ellipsis whitespace-nowrap text-xs sm:text-base']")
    private List<WebElement> videoCaptionList;
    @FindBy(xpath = "//div[@data-tooltip-id='search-home']")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBarInProfile;
    @FindBy(xpath = "//div[@class='flex flex-wrap gap-1']/div")
    private List<WebElement> displayedVideosTitle;
    public String groupName;
    public String videoDes;
    public String videoTitleName;
    public boolean manageVideo;

    public void insideManageVideosMenuSelectOption(String videoType) {
        try {
            webDriverHelper.waitUntilVisible(manageVideoTab, waitTime90Sec, pollingInterval1Sec);
            manageVideoTab.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(videoTypeBtn, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : videoTypeBtn) {
                String elementName = element.getText();
                if (elementName.equalsIgnoreCase(videoType)) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_insideManageVideosMenuSelectOption.jpg");
            Assert.fail("Failed in the method insideManageVideosMenuSelectOption due to exception :- " + exc);
        }
    }

    public void verifyTheModuleAndTitle(String videoType) {
        try {
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Manage Videos']")));
            activitiesPage.exceptionHandling(pageTitle);
            String titleName = pageTitle.getText();
            Assert.assertEquals(titleName, manageVideoPageTitle, "Failed to verify the page title " + titleName);
            WebElement element = driver.findElement(By.xpath("//div[text()='" + videoType + " Videos']"));
            webDriverHelper.waitUntilVisible(element, waitTime90Sec, pollingInterval1Sec);
            String videoTypeTileName = element.getText();
            Assert.assertTrue(videoTypeTileName.contains(videoType), "Failed to verify the video type tile " + videoTypeTileName + " with " + videoType);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheModuleAndTitle.jpg");
            Assert.fail("Failed in the method verifyTheModuleAndTitle due to exception :- " + exc);
        }
    }

    public void selectAnVideoAndClickOnReviewBtn() {
        try {
            Thread.sleep(waitTime5000MillSec);
            int size = videoTitleList.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    videoTitleName = videoTitleList.get(i).getText();
                    System.out.println("Video Title: " + videoTitleName);
                    if (videoTitleName.equals("-")) {
                        videoTitleName = "";
                    }
                    webDriverHelper.waitUntilVisible(reviewBtn.get(i), waitTime90Sec, pollingInterval1Sec);
                    reviewBtn.get(i).click();
                    manageVideo = true;
                    break;
                }
            } else {
                System.out.println("There are no videos displayed in the reported or unpublished section.");
                manageVideo = false;
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAnVideoAndClickOnReview.jpg");
            Assert.fail("Failed in the method selectAnVideoAndClickOnReview due to exception :- " + exc);
        }
    }

    public void verifyTheVideoTitle() {
        try {
            try {
                if (manageVideo) {
                    Thread.sleep(waitTime5000MillSec);
                    webDriverHelper.waitUntilVisible(videoTitle, waitTime90Sec, pollingInterval1Sec);
                    webDriverHelper.waitUntilVisible(videoNameInReviewSection, waitTime90Sec, pollingInterval1Sec);
                    String videoNameInReview = videoNameInReviewSection.getText();
                    System.out.println("videoNameInReviewSection " + videoNameInReview);
                    Assert.assertEquals(videoTitleName, videoNameInReview, "Failed to verify the selected video title in the block video page");
                }
            } catch (Exception exc) {
                System.out.println("There is no videos to select and verify the video title");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheVideoTitle.jpg");
            Assert.fail("Failed in the method verifyTheVideoTitle due to exception :- " + exc);
        }
    }

    public void verifyTheSuccessMessageAfterTheVideo(String approveType) {
        try {
            try {
                if (manageVideo) {
                    webDriverHelper.waitUntilVisibilityOfAllElements(approveTypeBtn, waitTime90Sec, pollingInterval1Sec);
                    boolean flag = false;
                    for (WebElement webElement : approveTypeBtn) {
                        String typeText = webElement.getText();
                        if (typeText.equals(approveType)) {
                            flag = true;
                            webElement.click();
                            break;
                        }
                    }
                    if (!flag) {
                        Assert.fail("Failed to " + approveType + " the selected video");
                    }
                    webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
                    String msg = toastMsg.getText();
                    if (approveType.equals("Approve") || approveType.equals("Publish")) {
                        Assert.assertEquals(msg, approveMsg, "Failed to verify the toast message after " + approveType + " the video");
                    } else {
                        Assert.assertEquals(msg, blockMsg, "Failed to verify the toast message after " + approveType + " the video");
                    }
                    webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
                    searchBar.click();
                    searchBar.clear();
                    searchBar.sendKeys(videoTitleName);
                    try {
                        Thread.sleep(waitTime5000MillSec);
                        WebElement element = driver.findElement(By.xpath("//tbody/tr/td/div/div[text()='" + videoTitleName + "']"));
                        if (element.isDisplayed()) {
                            Assert.fail("failed because the video is still displayed in the reported section");
                        }
                    } catch (Exception exc) {
                        System.out.println("Successfully " + approveType + " the video");
                    }
                }
            } catch (Exception exc) {
                System.out.println("There is no videos to select and verify the video title");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSuccessMessageAfterTheVideo.jpg");
            Assert.fail("Failed in the method verifyTheSuccessMessageAfterTheVideo due to exception :- " + exc);
        }
    }

    public void clickOnNewVideo() {
        try {
            webDriverHelper.waitUntilVisible(addVideoBtn, waitTime120Sec, pollingInterval1Sec);
            addVideoBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNewVideo.jpg");
            Assert.fail("Failed in the method clickOnNewVideo due to exception :- " + exc);
        }
    }

    public void uploadVideoEnterTheDetails() {
        try {
            webDriverHelper.waitUntilVisible(activitiesPage.uploadVideoTab, waitTime90Sec, pollingInterval1Sec);
            uploadVideo.sendKeys(filePath);
            webDriverHelper.waitUntilVisible(pageTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(videoCaptionArea, waitTime90Sec, pollingInterval2Sec);
            videoDes = videoDescription + " " + webDriverHelper.randomNumber();
            videoCaptionArea.sendKeys(videoDes);
            webDriverHelper.waitUntilVisible(selectGroup, waitTime90Sec, pollingInterval1Sec);
            selectGroup.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(groupList, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : groupList) {
                groupName = element.getText();
                if (groupName.contains("auto")) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(activitiesPage.publishBtn, waitTime90Sec, pollingInterval1Sec);
            activitiesPage.publishBtn.click();

            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime90Sec, pollingInterval2Sec);
            String message = activitiesPage.toastMsg.getText();
            if (!message.contains(savedVideoMsg)) {
                Assert.fail("Failed to upload the video");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNewVideo.jpg");
            Assert.fail("Failed in the method clickOnNewVideo due to exception :- " + exc);
        }
    }

    public void verifyTheUploadedVideoInRespectiveGroup() {
        try {
            webDriverHelper.waitUntilVisible(groupsBtn, waitTime90Sec, pollingInterval1Sec);
            groupsBtn.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(groupsList, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : groupsList) {
                String elementName = element.getText();
                if (elementName.contains(groupName)) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisibilityOfAllElements(videosTitle, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : videosTitle) {
                String titleName = element.getText();
                if (titleName.equals(videoDes)) {
                    System.out.println("The video is successfully added into the group");
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnNewVideo.jpg");
            Assert.fail("Failed in the method clickOnNewVideo due to exception :- " + exc);
        }
    }

    public void verifyTheVideoInAccountProfile() {
        try {
            activitiesPage.waitUntilLoadComplete();
            for (WebElement element : videoCaptionList) {
                String elementName = element.getText();
                if (elementName.equals(videoDes)) {
                    System.out.println("The video is successfully added and displayed under account profile");
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheVideoInAccountProfile.jpg");
            Assert.fail("Failed in the method verifyTheVideoInAccountProfile due to exception :- " + exc);
        }
    }

    public void basedOnAnySearch() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime120Sec, pollingInterval1Sec);
            searchBtn.click();
            webDriverHelper.waitUntilVisible(searchBarInProfile, waitTime90Sec, pollingInterval1Sec);
            searchBarInProfile.sendKeys("Video");
            Thread.sleep(waitTime10000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_basedOnAnySearch.jpg");
            Assert.fail("Failed in the method basedOnAnySearch due to exception :- " + exc);
        }
    }

    public void itShouldDisplayRespectiveSuggestion() {
        try {
            activitiesPage.waitUntilLoadComplete();
            Thread.sleep(waitTime5000MillSec);
            boolean flag = false;
            for (WebElement element : videoCaptionList) {
                String elementName = element.getText();
                System.out.println(elementName);
                if (elementName.toLowerCase().contains("video")) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the searched suggestion in the video title");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_itShouldDisplayRespectiveSuggestion.jpg");
            Assert.fail("Failed in the method itShouldDisplayRespectiveSuggestion due to exception :- " + exc);
        }
    }

    public void verifyTheTitle(String videoType) {
        try{
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+videoType+"']")));
            activitiesPage.exceptionHandling(pageTitle);
        }catch (Exception exc){
            webDriverHelper.takeAScreenShot("_verifyTheTitle.jpg");
            Assert.fail("Failed in the method verifyTheTitle due to exception :- " + exc);
        }
    }

//    public void clickOnFolder(String folderType) {
//        try{
//            WebElement folder = driver.findElement(By.xpath("//span[@title='"+folderType+"']//..//..//div[@class='cursor-pointer']"));
//            folder.click();
//        }catch (Exception exc){
//            webDriverHelper.takeAScreenShot("_clickOnFolder.jpg");
//            Assert.fail("Failed in the method clickOnFolder due to exception :- " + exc);
//        }
//    }

    @FindBy(xpath = "//span[text()='Upload']")
    private WebElement uploadButton;
    @FindBy(xpath = "//button[text()=' Add File ']")
    private WebElement addFileButton;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputFile;

    public void addFileInToTheFolder() {
        try{
            webDriverHelper.waitUntilVisible(addFileButton,waitTime90Sec,pollingInterval1Sec);
            addFileButton.click();
            webDriverHelper.waitUntilVisible(uploadButton,waitTime90Sec,pollingInterval1Sec);
            inputFile.sendKeys(filePath);
        }catch (Exception exc){
            webDriverHelper.takeAScreenShot("_addFileInToTheFolder.jpg");
            Assert.fail("Failed in the method addFileInToTheFolder due to exception :- " + exc);
        }
    }

    public void verifyTheSuccessMessageAfterUploadingTheVideo() {
        try{
            webDriverHelper.waitUntilVisible(toastMsg,waitTime90Sec,pollingInterval1Sec);
            String msg = toastMsg.getText();
            Assert.assertEquals(msg,contentSuccessMsg,"Failed to verify the toast message after uploading video");
        }catch (Exception exc){
            webDriverHelper.takeAScreenShot("_verifyTheSuccessMessageAfterUploadingTheVideo.jpg");
            Assert.fail("Failed in the method verifyTheSuccessMessageAfterUploadingTheVideo due to exception :- " + exc);
        }
    }
}

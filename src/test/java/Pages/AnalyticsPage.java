package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static Supports.Constants.*;
import static Supports.PagesClass.activitiesPage;
import static Supports.PagesClass.webDriverHelper;
import static Supports.WebDriverHelper.wait;

public class AnalyticsPage {
    @FindBy(xpath = "//a[@href='/admin/analytics']")
    private WebElement analyticsBtn;
    @FindBy(xpath = "//div[@class='flex gap-1 items-center text-gray-550']")
    private WebElement analyticsTag;
    @FindBy(xpath = "//*[@class='text-2xl font-semibold']")
    private WebElement analyticsName;
    @FindBy(xpath = "//div[@class='text-primary-900 text-xxxs flex gap-1 justify-end mt-0.5 cursor-pointer']")
    List<WebElement> viewMoreOptionBtn;
    @FindBy(xpath = "//p[@class='text-xs leading-5']")
    List<WebElement> analyticsList;
    @FindBy(xpath = "(//p[@class='text-xs leading-5'])[1]")
    private WebElement analyticsFirstElement;
    @FindBy(xpath = "(//button[contains(@id,'headlessui-menu-button')])[1]")
    private WebElement dropDownBtn;
    @FindBy(xpath = "//div[@role='menu']//span")
    List<WebElement> dropDowmList;
    @FindBy(xpath = "//div[@class='flex items-center justify-between gap-0']")
    List<WebElement> dropDowmNameList;
    @FindBy(xpath = "//div[@class='flex gap-1 h-10 font-medium text-gray-550']//button")
    List<WebElement> menuList;
    @FindBy(xpath = "//div[@class='flex h-10 gap-1 font-medium text-gray-550']//button")
    List<WebElement> menuListWithVideo;
    @FindBy(xpath = "(//div[@class='flex items-center gap-x-2 text-xs']//span)[4]")
    private WebElement pagination;
    @FindBy(xpath = "//div[@class='w-full rounded-xl bg-white grow flex justify-between items-center h-12.5 p-2.5']")
    List<WebElement> menuListForUsers;
    @FindBy(xpath = "//div[@class='w-full rounded-xl bg-white grow flex justify-between items-center h-12.5 p-2.5']//div[@class='text-xl leading-6 font-semibold text-gray-850']")
    List<WebElement> menuNumberListForUsers;
    @FindBy(xpath = "//div[@class='flex gap-1 relative']")
    private WebElement relativeTag;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[1]")
    private WebElement tablesColumnHeader1;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[2]")
    private WebElement tablesColumnHeader2;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[3]")
    private WebElement tablesColumnHeader3;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[4]")
    private WebElement tablesColumnHeader4;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[5]")
    private WebElement tablesColumnHeader5;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[6]")
    private WebElement tablesColumnHeader6;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[7]")
    private WebElement tablesColumnHeader7;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[8]")
    private WebElement tablesColumnHeader8;
    @FindBy(xpath = "(//div[@class='flex items-center justify-between gap-0'])[9]")
    private WebElement tablesColumnHeader9;
    @FindBy(xpath = "//div[normalize-space()='Overview' and @class='text-2xl font-semibold']")
    private WebElement overViewBtn;

    public AnalyticsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAnalytics() {
        try {
            webDriverHelper.waitUntilVisible(analyticsBtn, waitTime90Sec, pollingInterval1Sec);
            analyticsBtn.click();
            webDriverHelper.waitUntilVisible(analyticsBtn, waitTime90Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToAnalytics.jpg");
            Assert.fail("Failed in the method navigateToAnalytics due to exception :- " + exc);
        }
    }

    public void verifyTheActivityNameAndViewMoreOption() {
        try {
            activitiesPage.waitUntilLoadComplete();
            activitiesPage.exceptionHandling(overViewBtn);
            webDriverHelper.scrollToWebElement(overViewBtn);
            String name = overViewBtn.getText();
            Assert.assertTrue(name.contains("Overview"), "the overview tag is not present");
            int LoadMoreSize = viewMoreOptionBtn.size();
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(analyticsFirstElement, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.scrollToWebElement(analyticsFirstElement);
            Thread.sleep(waitTime5000MillSec);
            int analyticsSize = analyticsList.size();
            SoftAssert softAssert = new SoftAssert();
            for (WebElement analyticsName : analyticsList) {
                String nameList = analyticsName.getText();
                if (!(nameList.contains("Pitch Practice") || nameList.contains("Courses") || nameList.contains("Training") || nameList.contains("Celebration") ||
                        nameList.contains("Campaign") || nameList.contains("Team Activity") || nameList.contains("Polls") || nameList.contains("Users"))) {
                    softAssert.fail("the specified activity are not present in the list :  " + nameList);
                }
            }
            softAssert.assertAll();
            if (analyticsSize != LoadMoreSize) {
                Assert.fail("the view more option below the activity name is not matching");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyMoreOption.jpg");
            Assert.fail("Failed in the method verifyMoreOption due to exception :- " + exc);
        }
    }

    public void navigateToActivity(String activity) {
        try {
            webDriverHelper.waitUntilVisible(dropDownBtn, waitTime90Sec, pollingInterval1Sec);
            dropDownBtn.click();
            Thread.sleep(waitTime5000MillSec);
            boolean flag = false;
            for (WebElement activityName : dropDowmList) {
                String activityText = activityName.getText();
                if (activityText.contains(activity)) {
                    activityName.click();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Assert.fail(" the " + activity + " is not present in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToActivity.jpg");
            Assert.fail("Failed in the method navigateToActivity due to exception :- " + exc);
        }
    }

    public void verifyTheColumnName(String activity) {
        if (activity.contains("Courses") || activity.contains("Training")) {
            verifyColumnNameWithOutVideo(activity);
        } else if (activity.contains("Campaign") || activity.contains("Pitch Practice") || activity.contains("Celebration") || activity.contains("Team Activity")) {
            verifyTheColumnNameWithVideo(activity);
        } else if (activity.contains("Poll")) {
            verifyColumnNameForPolls(activity);
        } else {
            verifyColumnNameForUsers(activity);
        }
    }

    public void verifyTheColumnNameWithVideo(String activity) {
        try {
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(relativeTag, waitTime90Sec, pollingInterval1Sec);
            String activityName = relativeTag.getText();
            if (!activityName.toLowerCase().contains(activity.toLowerCase())) {
                Assert.fail(activity + " tag is not matching");
            }
            Thread.sleep(waitTime5000MillSec);
            SoftAssert softAssert = new SoftAssert();
            webDriverHelper.waitUntilVisible(tablesColumnHeader1, waitTime90Sec, pollingInterval1Sec);
            String headerName = tablesColumnHeader1.getText();
            softAssert.assertEquals(headerName, "Campaign", "The 1st column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader2.getText();
            softAssert.assertEquals(headerName, "Group", "The 2nd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader3.getText();
            softAssert.assertEquals(headerName, "Created by", "The 3rd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader4.getText();
            softAssert.assertEquals(headerName, "Start - end", "The 4th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader5.getText();
            softAssert.assertEquals(headerName, "Members", "The 5th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader6.getText();
            softAssert.assertEquals(headerName, "Creators", "The 6th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader7.getText();
            softAssert.assertEquals(headerName, "Videos", "The 7th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader8.getText();
            softAssert.assertEquals(headerName, "Views", "The 8th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader9.getText();
            softAssert.assertEquals(headerName, "Interactions", "The 9th column is not matching in the table for the " + activity);
            softAssert.assertAll();
            webDriverHelper.waitUntilVisible(pagination, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < menuListWithVideo.size(); i++) {
                String name = menuListWithVideo.get(i).getText();
                String[] parts = name.split("\\(|\\)");
                String overAllNumber = parts[1];
                String paginationName = pagination.getText();
                String[] part = paginationName.split("of");
                String paginationNumber = part[1].trim();
                if (i == menuListWithVideo.size() - 1) {
                    break;
                }
                Assert.assertEquals(overAllNumber, paginationNumber, "The Number in the pagination and Over all is not matching");
                menuListWithVideo.get(i + 1).click();
                if (!(name.contains("All") || name.contains("Active") || name.contains("Pending") ||
                        name.contains("Inactive") || name.contains("Groups"))) {
                    softAssert.fail("None of the specified strings are present: " + name);
                }
            }
            softAssert.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheColumnName.jpg");
            Assert.fail("Failed in the method verifyTheColumnName due to exception :- " + exc);
        }
    }

    public void verifyColumnNameWithOutVideo(String activity) {
        try {
            activitiesPage.waitUntilLoadComplete();
            activitiesPage.exceptionHandling(relativeTag);
            String activityName = relativeTag.getText();
            if (!activityName.contains(activity)) {
                Assert.fail(activity + " tag is not matching");
            }
            SoftAssert softAssert = new SoftAssert();
            Thread.sleep(waitTime5000MillSec);
            String headerName = tablesColumnHeader1.getText();
            softAssert.assertEquals(headerName, "Name", "The 1st column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader2.getText();
            softAssert.assertEquals(headerName, "Group", "The 2nd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader3.getText();
            softAssert.assertEquals(headerName, "Created by", "The 3rd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader4.getText();
            softAssert.assertEquals(headerName, "Start - end", "The 4th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader5.getText();
            softAssert.assertEquals(headerName, "Assigned To", "The 5th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader6.getText();
            softAssert.assertEquals(headerName, "Started By", "The 6th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader7.getText();
            softAssert.assertEquals(headerName, "Completed By", "The 7th column is not matching in the table for the " + activity);
            softAssert.assertAll();
            webDriverHelper.waitUntilVisible(pagination, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < menuList.size(); i++) {
                String name = menuList.get(i).getText();
                String[] parts = name.split("\\(|\\)");
                String overAllNumber = parts[1];
                String paginationName = pagination.getText();
                String[] part = paginationName.split("of");
                String paginationNumber = part[1].trim();
                Assert.assertEquals(overAllNumber, paginationNumber, "The Number in the pagination and Over all is not matching");
                Assert.assertEquals(overAllNumber, paginationNumber, "The Number in the pagination and Over all is not matching");
                if (i == menuList.size() - 1) {
                    break;
                }
                menuList.get(i + 1).click();
                if (!(name.contains("All") || name.contains("Active") || name.contains("Scheduled") || name.contains("Draft") ||
                        name.contains("Inactive") || name.contains("Groups"))) {
                    softAssert.fail("None of the specified strings are present: " + name);
                }
            }
            softAssert.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheColumnName.jpg");
            Assert.fail("Failed in the method verifyTheColumnName due to exception :- " + exc);
        }
    }

    public void verifyColumnNameForPolls(String activity) {
        try {
            activitiesPage.waitUntilLoadComplete();
            activitiesPage.exceptionHandling(relativeTag);
            String activityName = relativeTag.getText();
            if (!activityName.contains(activity)) {
                Assert.fail(activity + " tag is not matching");
            }
            Thread.sleep(waitTime5000MillSec);
            SoftAssert softAssert = new SoftAssert();
            String headerName = tablesColumnHeader1.getText();
            softAssert.assertEquals(headerName, "Poll", "The 1st column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader2.getText();
            softAssert.assertEquals(headerName, "Group", "The 2nd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader3.getText();
            softAssert.assertEquals(headerName, "Creator", "The 3rd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader4.getText();
            softAssert.assertEquals(headerName, "Start - end", "The 4th column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader5.getText();
            softAssert.assertEquals(headerName, "Responses", "The 5th column is not matching in the table for the " + activity);
            softAssert.assertAll();
            webDriverHelper.waitUntilVisible(pagination, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < menuListWithVideo.size(); i++) {
                String name = menuListWithVideo.get(i).getText();
                String[] parts = name.split("\\(|\\)");
                String overAllNumber = parts[1];
                String paginationName = pagination.getText();
                String[] part = paginationName.split("of");
                String paginationNumber = part[1].trim();
                if (i == menuListWithVideo.size() - 1) {
                    break;
                }
                Assert.assertEquals(overAllNumber, paginationNumber, "The Number in the pagination and Over all is not matching");
                menuListWithVideo.get(i + 1).click();
                if (!(name.contains("All") || name.contains("Active") || name.contains("Scheduled") || name.contains("Draft") ||
                        name.contains("Inactive") || name.contains("Groups"))) {
                    softAssert.fail("None of the specified strings are present: " + name);
                }
            }
            softAssert.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheColumnName.jpg");
            Assert.fail("Failed in the method verifyTheColumnName due to exception :- " + exc);
        }
    }

    public void verifyColumnNameForUsers(String activity) {
        try {
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(relativeTag, waitTime90Sec, pollingInterval1Sec);
            String activityName = relativeTag.getText();
            if (!activityName.contains(activity)) {
                Assert.fail(activity + " tag is not matching");
            }
            Thread.sleep(waitTime5000MillSec);
            SoftAssert softAssert = new SoftAssert();
            String headerName = tablesColumnHeader1.getText();
            softAssert.assertEquals(headerName, "Name", "The 1st column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader2.getText();
            softAssert.assertEquals(headerName, "Department", "The 2nd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader3.getText();
            softAssert.assertEquals(headerName, "Views", "The 3rd column is not matching in the table for the " + activity);
            headerName = tablesColumnHeader4.getText();
            softAssert.assertEquals(headerName, "Videos Created", "The 4th column is not matching in the table for the " + activity);
            softAssert.assertAll();
            webDriverHelper.waitUntilVisible(pagination, waitTime90Sec, pollingInterval1Sec);
            for (WebElement menuListForUser : menuListForUsers) {
                String name = menuListForUser.getText();
                if (!(name.contains("Active Users") || name.contains("Active Creators") || name.contains("Median Daily Usage") || name.contains("Video Created") ||
                        name.contains("Views"))) {
                    softAssert.fail("None of the specified strings are present: " + name);
                }
            }
            softAssert.assertAll();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheColumnName.jpg");
            Assert.fail("Failed in the method verifyTheColumnName due to exception :- " + exc);
        }
    }
}

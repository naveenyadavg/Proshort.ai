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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static Supports.Constants.*;
import static Supports.PagesClass.activitiesPage;
import static Supports.PagesClass.webDriverHelper;
import static Supports.WebDriverHelper.wait;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Sales bot']")
    private WebElement salesBotTitle;
    @FindBy(xpath = "//p[text()='Sales bot']//following-sibling::div/span")
    private List<WebElement> salesBotBtn;
    @FindBy(xpath = "//div[@class='text-[18px] font-bold text-gray-850']")
    private WebElement salesBotHeader;
    @FindBy(xpath = "//input[@placeholder='Search your files']")
    private WebElement searchBtn;
    @FindBy(xpath = "//div[contains(@id,'content-tile-')]")
    private List<WebElement> contentList;
    @FindBy(xpath = "//div[contains(@id,'content-tile-')]/div[@title]")
    private List<WebElement> contentListTile;
    @FindBy(xpath = "//input[@placeholder='Type question here']")
    private WebElement questionTextarea;
    @FindBy(xpath = "//div[contains(@id,'headlessui-dialog-panel')]//button[contains(text(),'Create Q and A from')]")
    private WebElement createQABtn;
    @FindBy(xpath = "//div[text()='Upload Content']")
    private WebElement uploadContent;
    @FindBy(xpath = "//div[text()='Upload Content']/following-sibling::input[@type='file']")
    private WebElement inputContent;
    @FindBy(xpath = "//a[text()=' Library']")
    private WebElement libraryBtn;
    @FindBy(xpath = "//div[@class='text-2xl font-semibold']")
    private WebElement libraryPageTitle;
    @FindBy(xpath = "//div[@class='flex justify-between']/span")
    private WebElement appIntegrationTitle;
    @FindBy(xpath = "//span[text()='App Integrations ']//..//..//p[contains(@class,'text-xxxs font-semibold leading')]")
    private List<WebElement> appIntegrationName;
    @FindBy(xpath = "//span[text()='App Integrations ']//..//..//button")
    private List<WebElement> appIntegrationBtn;
    @FindBy(xpath = "//p[@data-test-id='connect-to-hubspot-message']")
    private WebElement hubspotPage;
    @FindBy(xpath = "//div[@id='logo_wrapper']//span")
    private WebElement salesForcePage;
    @FindBy(xpath = "//a/img[@alt]")
    private WebElement slackPage;
    @FindBy(xpath = "//div[@id='page-wrapper']//img")
    private WebElement gongPage;
    @FindBy(xpath = "//h1/span")
    private WebElement googleDrivePage;
    @FindBy(xpath = "//div[contains(@id,'headlessui-dialog-panel')]/div/div")
    private WebElement viewSalesBotHeader;
    @FindBy(xpath = "//div[@class='flex flex-col gap-2']/div[1]")
    private List<WebElement> salesBotQuestion;
    @FindBy(xpath = "//div[text()='Done']")
    private WebElement doneBtn;
    @FindBy(xpath = "//div[text()='Sales Bot']")
    private WebElement salesBotTag;
    @FindBy(xpath = "//input[@placeholder='Type here...']")
    private WebElement inputTagForSalesBot;
    @FindBy(xpath = "//div[@class='flex cursor-pointer items-center']//*")
    private WebElement sndBtnTag;
    @FindBy(xpath = "//div[text()='Generating answer...']")
    private WebElement salesBotInputTag;
    @FindBy(xpath = "//div[contains(@id,'preview-question-')]//p")
    private WebElement listAnswer;

    public static String fileName;

    public void navigateOnLibrary() {
        try {
            webDriverHelper.waitUntilVisible(libraryBtn, waitTime90Sec, pollingInterval1Sec);
            libraryBtn.click();
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-2xl font-semibold']")));
            activitiesPage.exceptionHandling(pageTitle);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageTitle);
            String title = pageTitle.getText();
            Assert.assertEquals(title, "My Library", "Failed to verify the title");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateOnLibrary.jpg");
            Assert.fail("Failed in the method navigateOnLibrary due to exception :- " + exc);
        }
    }

    public void verifyTheUploadedVideoInTheLibrary() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime90Sec, pollingInterval1Sec);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
            searchBtn.sendKeys(PropertiesReader.applicationCreatedBy);
            webDriverHelper.waitUntilVisibilityOfAllElements(contentListTile, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : contentListTile) {
                String titleName = element.getAttribute("title");
                if (titleName.equals(fileName)) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheUploadedVideoInTheLibrary.jpg");
            Assert.fail("Failed in the method verifyTheUploadedVideoInTheLibrary due to exception :- " + exc);
        }
    }


    public void clickOnCreateSalesBot(String btn) {
        try {
            webDriverHelper.waitUntilVisible(salesBotTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(salesBotBtn, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : salesBotBtn) {
                String elementName = element.getText();
                if (elementName.equals(btn)) {
                    element.click();
                    break;
                }
            }
            webDriverHelper.waitUntilVisible(salesBotHeader, waitTime90Sec, pollingInterval1Sec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToDashboardPage.jpg");
            Assert.fail("Failed in the method navigateToDashboardPage due to exception :- " + exc);
        }
    }

    public void uploadAVideoContentVerifyTheMessage() {
        try {
            webDriverHelper.waitUntilVisible(uploadContent, waitTime90Sec, pollingInterval1Sec);
            inputContent.sendKeys(filePath);
            Path path = Paths.get(filePath);
            fileName = path.getFileName().toString();
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime90Sec, pollingInterval1Sec);
            String msg = activitiesPage.toastMsg.getText();
            Assert.assertEquals(msg, uploadContentMsg, "Failed to verify the toast message");
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_navigateToDashboardPage.jpg");
            Assert.fail("Failed in the method navigateToDashboardPage due to exception :- " + exc);
        }
    }

    public void addYourQuestion() {
        try {
            webDriverHelper.waitUntilVisible(questionTextarea, waitTime90Sec, pollingInterval1Sec);
            questionTextarea.sendKeys(salesBotQues);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_addYourQuestion.jpg");
            Assert.fail("Failed in the method addYourQuestion due to exception :- " + exc);
        }
    }

    public void clickOnCreateQAButtonVerifyTheMessage() {
        try {
            webDriverHelper.waitUntilVisible(createQABtn, waitTime90Sec, pollingInterval1Sec);
            Thread.sleep(waitTime3000MillSec);
            createQABtn.click();
            webDriverHelper.waitUntilVisible(activitiesPage.toastMsg, waitTime90Sec, pollingInterval1Sec);
            String msg = activitiesPage.toastMsg.getText();
            Assert.assertEquals(msg, QAMsg, "Failed to verify the toast message");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnCreateQAButtonVerifyTheMessage.jpg");
            Assert.fail("Failed in the method clickOnCreateQAButtonVerifyTheMessage due to exception :- " + exc);
        }
    }

    public void selectAVideoContent() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(contentListTile, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < contentListTile.size(); i++) {
                String titleName = contentListTile.get(i).getAttribute("title");
                try {
                    WebElement status = driver.findElement(By.xpath("//div[@title='" + titleName + "']//..//div[text()='Completed']"));
                    if (status.isDisplayed()) {
                        i++;
                    }
                } catch (Exception exc) {
                    if (titleName.contains(".mp4")) {
                        contentListTile.get(i).click();
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAVideoContent.jpg");
            Assert.fail("Failed in the method selectAVideoContent due to exception :- " + exc);
        }
    }

    public void selectPDFContent() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(contentListTile, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < contentListTile.size(); i++) {
                String titleName = contentListTile.get(i).getAttribute("title");
                try {
                    WebElement status = driver.findElement(By.xpath("//div[@title='" + titleName + "']//..//div[text()='Completed']"));
                    if (status.isDisplayed()) {
                        i++;
                    }
                } catch (Exception exc) {
                    if (titleName.contains(".pdf")) {
                        contentListTile.get(i).click();
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectPDFContent.jpg");
            Assert.fail("Failed in the method selectPDFContent due to exception :- " + exc);
        }
    }

    public void selectPPTContent() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(contentListTile, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < contentListTile.size(); i++) {
                String titleName = contentListTile.get(i).getAttribute("title");
                try {
                    WebElement status = driver.findElement(By.xpath("//div[@title='" + titleName + "']//..//div[text()='Completed']"));
                    if (status.isDisplayed()) {
                        i++;
                    }
                } catch (Exception exc) {
                    if (titleName.contains(".ppt")) {
                        contentListTile.get(i).click();
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectPPTContent.jpg");
            Assert.fail("Failed in the method selectPPTContent due to exception :- " + exc);
        }
    }

    public void selectDocumentContent() {
        try {
            webDriverHelper.waitUntilVisible(searchBtn, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(contentListTile, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < contentListTile.size(); i++) {
                String titleName = contentListTile.get(i).getAttribute("title");
                try {
                    WebElement status = driver.findElement(By.xpath("//div[@title='" + titleName + "']//..//div[text()='Completed']"));
                    if (status.isDisplayed()) {
                        i++;
                    }
                } catch (Exception exc) {
                    if (titleName.contains(".docx")) {
                        contentListTile.get(i).click();
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectDocumentContent.jpg");
            Assert.fail("Failed in the method selectDocumentContent due to exception :- " + exc);
        }
    }

    public void selectClickOnInstall(String app) {
        try {
            webDriverHelper.waitUntilVisible(appIntegrationTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(appIntegrationName, waitTime90Sec, pollingInterval1Sec);
            for (int i = 0; i < appIntegrationName.size(); i++) {
                String appName = appIntegrationName.get(i).getText();
                if (appName.equals(app)) {
                    appIntegrationBtn.get(i).click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectClickOnInstall.jpg");
            Assert.fail("Failed in the method selectClickOnInstall due to exception :- " + exc);
        }
    }

    public void verifyTheOnceInstalled(String app) {
        try {
            switch (app) {
                case "Hubspot":
                    webDriverHelper.waitUntilVisible(hubspotPage, waitTime90Sec, pollingInterval1Sec);
                    Assert.assertTrue(hubspotPage.getText().contains("HubSpot"), "Failed to verify the page");
                    break;
                case "Salesforce":
                    webDriverHelper.waitUntilVisible(salesForcePage, waitTime90Sec, pollingInterval1Sec);
                    Assert.assertTrue(salesForcePage.getText().contains(app), "Failed to verify the page");
                    break;
                case "Slack":
                    webDriverHelper.waitUntilVisible(slackPage, waitTime90Sec, pollingInterval1Sec);
                    Assert.assertTrue(slackPage.getAttribute("alt").contains(app), "Failed to verify the page");
                    break;
                case "Gong":
                    webDriverHelper.waitUntilVisible(gongPage, waitTime90Sec, pollingInterval1Sec);
                    Assert.assertTrue(gongPage.getAttribute("alt").contains(app), "Failed to verify the page");
                    break;
                case "Google Drive":
                    webDriverHelper.waitUntilVisible(googleDrivePage, waitTime90Sec, pollingInterval1Sec);
                    Assert.assertEquals(googleDrivePage.getText(), "Sign in", "Failed to verify the page");
                    break;
            }
            Thread.sleep(waitTime5000MillSec);
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheAppOnceInstalled.jpg");
            Assert.fail("Failed in the method verifyTheAppOnceInstalled due to exception :- " + exc);
        }
    }

    public void verifyTheTitleClickOnDone() {
        try {
            activitiesPage.waitUntilLoadComplete();
            webDriverHelper.waitUntilVisible(viewSalesBotHeader, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(salesBotQuestion, waitTime90Sec, pollingInterval1Sec);
            boolean flag = false;
            for (WebElement element : salesBotQuestion) {
                String Question = element.getText();
                if (Question.equals(salesBotQues)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Assert.fail("Failed to verify the question asked in the sales bot");
            }
            webDriverHelper.waitUntilVisible(doneBtn, waitTime90Sec, pollingInterval1Sec);
            doneBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheTitleInSalesBot.jpg");
            Assert.fail("Failed in the method verifyTheTitleInSalesBot due to exception :- " + exc);
        }
    }

    public void verifyWhetherTheSalesBotCreateAAnswer() {
        try {
            activitiesPage.waitUntilLoadComplete();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sales Bot']")));
            webDriverHelper.waitUntilVisible(inputTagForSalesBot, waitTime90Sec, pollingInterval1Sec);
            inputTagForSalesBot.sendKeys(salesBotQues);
            webDriverHelper.waitUntilVisible(sndBtnTag, waitTime90Sec, pollingInterval1Sec);
            sndBtnTag.click();
            webDriverHelper.waitUntilVisible(salesBotInputTag, waitTime90Sec, pollingInterval1Sec);
            try {
                webDriverHelper.waitUntilVisible(listAnswer, waitTime90Sec, pollingInterval1Sec);
            } catch (Exception exc) {
                Thread.sleep(waitTime10000MillSec);
                webDriverHelper.waitUntilVisible(listAnswer, waitTime90Sec, pollingInterval1Sec);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyWhetherTheSalesBotCreateAAnswer.jpg");
            Assert.fail("Failed in the method verifyWhetherTheSalesBotCreateAAnswer due to exception :- " + exc);
        }
    }
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Supports.Constants.pollingInterval1Sec;
import static Supports.Constants.waitTime60Sec;
import static Supports.PagesClass.activitiesPage;
import static Supports.PagesClass.webDriverHelper;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='home-feed-button']")
    public WebElement homeBtn;


    public void userShouldBeAbleToReactForTheVideo() {
        try {
            homeBtn.click();
            activitiesPage.waitUntilLoadComplete();
            activitiesPage.likeButton();
            activitiesPage.commendButton();
            activitiesPage.shareButton();
            activitiesPage.tagButton();
            activitiesPage.verifyLikedAndSavedVideo();
            homeBtn.click();
            activitiesPage.waitUntilLoadComplete();
            menuButton();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_userShouldBeAbleToReactForTheVideo.jpg");
            Assert.fail("Failed in the method userShouldBeAbleToReactForTheVideo due to exception :- " + exc);
        }
    }

    public void menuButton() {
        try {
            webDriverHelper.waitUntilVisible(activitiesPage.menuBtnInActivities, waitTime60Sec, pollingInterval1Sec);
            activitiesPage.menuBtnInActivities.click();
            webDriverHelper.waitUntilVisible(activitiesPage.deleteBtn, waitTime60Sec, pollingInterval1Sec);
            try {
                webDriverHelper.waitUntilVisible(activitiesPage.editBtn, waitTime60Sec, pollingInterval1Sec);
            } catch (Exception exc) {
                webDriverHelper.waitUntilVisible(activitiesPage.reportBtn, waitTime60Sec, pollingInterval1Sec);
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_menuButton.jpg");
            Assert.fail("Failed in the method menuButton due to exception :- " + exc);
        }
    }
}

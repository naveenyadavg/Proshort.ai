package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.accountPage;

public class Account_Steps {

    @When("click on account profile")
    public void clickOnAccountProfile() {
        accountPage.clickOnAccountProfile();
    }

    @And("click on Edit Profile")
    public void clickOnEditProfile() {
        accountPage.clickOnEditProfile();
    }

    @Then("verify the title and click on change profile")
    public void verifyTheTitleAndClickOnChangeProfile() {
        accountPage.verifyTheTitleAndClickOnChangeProfile();
    }

    @And("upload a image & verify the toast msg")
    public void uploadAImageVerifyTheToastMsg() {
        accountPage.uploadAImageVerifyTheToastMsg();
    }

    @Then("edit the details & click on save")
    public void editTheDetailsClickOnSave() {
        accountPage.editTheDetailsClickOnSave();
    }

    @Then("verify the updated details in the account profile")
    public void verifyTheUpdatedDetailsInTheAccountProfile() {
        accountPage.verifyTheUpdatedDetailsInTheAccountProfile();
    }

    @And("click on settings")
    public void clickOnSettings() {
        accountPage.clickOnSettings();
    }

    @And("verify the page title")
    public void verifyThePageTitle() {
        accountPage.verifyThePageTitle();
    }

    @Then("update password, submit & verify title")
    public void updatePasswordSubmitVerifyTitle() {
        accountPage.updatePasswordSubmitVerifyTitle();
    }

    @Then("click & enter the feedback")
    public void clickEnterTheFeedback() {
        accountPage.clickEnterTheFeedback();
    }

    @Then("submit & verify the msg")
    public void submitVerifyTheMsg() {
        accountPage.submitVerifyTheMsg();
    }

    @And("click on notification")
    public void clickOnNotification() {
        accountPage.clickOnNotification();
    }

    @And("select any notification")
    public void selectAnyNotification() {
        accountPage.selectAnyNotification();
    }

    @Then("check whether it was navigating to respective course")
    public void checkWhetherItWasNavigatingToRespectiveCourse() {
        accountPage.checkWhetherItWasNavigatingToRespectiveCourse();
    }

    @And("click & enter the support message")
    public void clickEnterTheSupportMessage() {
        accountPage.clickEnterTheSupportMessage();
    }
}

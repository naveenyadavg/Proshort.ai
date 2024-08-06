package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.manageGroupsPage;
import static Supports.PagesClass.manageUsersPage;

public class ManageUsers_Steps {

    @Then("click on {string} button")
    public void clickOnInviteMemberButton(String button) {
        manageUsersPage.clickOnInviteMemberButton(button);
    }

    @And("enter {string} and click done button")
    public void enterAndClickDoneButton(String emailId) {
        manageUsersPage.enterEmailIdAndClickDoneButton(emailId);
    }

    @Then("verify the email in the {string} section")
    public void verifyTheEmailInThePendingSection(String status) {
        manageUsersPage.verifyTheEmailInThePendingSection(status);
    }

    @And("upload a excel file which as multiple {string}")
    public void uploadAExcelFileWhichAsMultiple(String emailId) {
        manageUsersPage.uploadAExcelFileWhichAsMultiple(emailId);
    }

    @Then("click on invite")
    public void clickOnInvite() {
        manageUsersPage.clickOnInvite();
    }

    @And("verify the sent emails in the invite page")
    public void verifyTheSentEmailsInTheInvitePage() {
        manageUsersPage.verifyTheSentEmailsInTheInvitePage();
    }

    @Then("verify the success message & click on {string}")
    public void verifyTheSuccessMessageClickOnDone(String arg0) {
        manageUsersPage.verifyTheSuccessMessageClickOnDone();
    }

    @Then("verify the sent emails in the {string} section")
    public void verifyTheSentEmailsInThePendingSection(String status) {
        manageUsersPage.verifyTheSentEmailsInThePendingSection(status);
    }

    @And("edit the {string} details for existing member")
    public void editTheDetailsForExistingMember(String manageType) {
        manageUsersPage.editTheDetailsForExistingMember(manageType);
    }

    @Then("verify the {string} details after editing")
    public void verifyTheDetailsAfterEditing(String arg0) {
        manageUsersPage.verifyTheDetailsAfterEditing();
    }

    @And("verify create {string} title")
    public void verifyCreateTitle(String manageType) {
        manageGroupsPage.verifyCreateTitle(manageType);
    }

    @When("click on {string}")
    public void clickOn(String manageType) {
        manageGroupsPage.clickOn(manageType);
    }

    @And("select an create group")
    public void selectAnCreateGroup() {
        manageGroupsPage.selectAnCreateGroup();
    }

    @And("add the members into the group and verify the success msg")
    public void addTheMembersIntoTheGroupAndVerifyTheSuccessMsg() {
        manageGroupsPage.addTheMembersIntoTheGroupAndVerifyTheSuccessMsg();
    }

    @Then("verify the created {string}")
    public void verifyTheCreated(String arg0) {
        manageGroupsPage.verifyTheCreated();
    }

    @And("select an browse group")
    public void selectAnBrowseGroup() {
        manageGroupsPage.selectAnBrowseGroup();
    }

    @Then("browse the group and verify the details")
    public void browseTheGroupAndVerifyTheDetails() {
        manageGroupsPage.browseTheGroupAndVerifyTheDetails();
    }
}

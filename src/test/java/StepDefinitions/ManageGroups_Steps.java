package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Supports.PagesClass.manageGroupsPage;

public class ManageGroups_Steps {

    @And("inside user & groups menu select {string} option")
    public void insideUserGroupsMenuSelectOption(String manageType) {
        manageGroupsPage.insideUserGroupsMenuSelectOption(manageType);
    }

    @Then("click on create {string} btn")
    public void clickOnCreateBtn(String manageType) {
        manageGroupsPage.clickOnCreateBtn(manageType);
    }

    @Then("enter the {string} name & click on next")
    public void enterTheNameClickOnNext(String manageType) {
        manageGroupsPage.enterTheNameClickOnNext(manageType);
    }

    @And("add the members")
    public void addTheMembers() {
        manageGroupsPage.addTheMembers();
    }

    @And("verify the members details & there count")
    public void verifyTheMembersDetailsThereCount() {
        manageGroupsPage.verifyTheMembersDetailsThereCount();
    }

    @Then("verify the create {string} is displayed in the table")
    public void verifyTheCreateIsDisplayedInTheTable(String arg0) {
        manageGroupsPage.verifyTheCreateIsDisplayedInTheTable();
    }

    @And("select on existing {string} & {string} btn")
    public void selectOnExistingEditDetailsBtn(String manageType, String button) {
        manageGroupsPage.selectOnExistingEditDetailsBtn(manageType, button);
    }

    @Then("verify the details in the table after editing {string} name")
    public void verifyTheDetailsInTheTableAfterEditingName(String manageType) {
        manageGroupsPage.verifyTheDetailsInTheTableAfterEditingName(manageType);
    }

    @And("click on {string} to add members")
    public void clickOnAddBtnToAddMembers(String arg0) {
        manageGroupsPage.clickOnAddBtnToAddMembers();
    }

    @Then("verify the add members in the {string} page")
    public void verifyTheAddMembersInTheAddPeoplePage(String arg0) {
        manageGroupsPage.verifyTheMembersDetailsThereCount();
    }

    @Then("verify the success message & the {string} details in table")
    public void verifyTheSuccessMessageTheDetailsInTable(String manageType) {
        manageGroupsPage.verifyTheSuccessMessageTheDetailsInTable(manageType);
    }
}

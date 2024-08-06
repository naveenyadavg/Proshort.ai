package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Supports.PagesClass.workSpaceSetUpPage;

public class WorkSpaceSetUp_Steps {
    @Then("navigate to workspace setup")
    public void navigate_to_workspace_setup() {
        workSpaceSetUpPage.navigateToWorkSpaceSetup();
    }

    @Then("upload the organization logo")
    public void upload_the_organization_logo() {
        workSpaceSetUpPage.uploadOrganizationLogo();
    }

    @Then("verify that the Workspace name is changed")
    public void verify_that_the_workspace_name_is_changed() {
        workSpaceSetUpPage.verifyWorkSpaceName();
    }

    @And("change the workspace name as {string}")
    public void changeTheWorkspaceNameAs(String workSpaceName) {
        workSpaceSetUpPage.workSpaceName(workSpaceName);
    }

    @And("save the Workspace Settings")
    public void saveTheWorkspaceSettings() {
        workSpaceSetUpPage.saveTheWorkspaceSettings();
    }

    @And("verify the pop message for detail updation")
    public void verifyThePopMessageForDetailUpdation() {
        workSpaceSetUpPage.popUpForDetailUpdation();
    }

}

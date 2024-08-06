package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.*;


public class Activities_Steps {

    @Given("login to the application")
    public void loginToTheApplication() {
        loginPage.getTheUrlOfApplication();
        loginPage.enterTheUsernameAndVerify();
        loginPage.verifyTheContinueBtnAndLogin();
    }

//    @When("click on the chevron down icon beside the workspace or user name")
//    public void clickOnTheChevronDownIconBesideTheWorkspaceOrUserName() {
//        activitiesPage.clickOnTheChevronDownIcon();
//    }

    @Then("click on Admin console")
    public void clickOnAdminConsole() {
        activitiesPage.clickOnAdminConsoleAndVerify();
    }

    @And("inside Activities menu select {string} option")
    public void insideActivitiesMenuSelectOption(String activities) {
        activitiesPage.insideActivitiesMenuSelectOption(activities);
    }

    @Then("click on create {string} button")
    public void clickOnCreateButton(String activities) {
        activitiesPage.clickOnCreateButton(activities);
    }

//    @And("enter the {string} name and description")
//    public void enterTheNameAndDescription(String name) {
//        activitiesPage.enterTheNameAndDescription(name);
//    }

//    @And("assign the {string} of groups to the course")
//    public void assignTheOfGroupsToTheCourse(String number) {
//        activitiesPage.assignTheCourseToTheOfGroups(Integer.parseInt(number));
//    }

    @And("select the participant group as {string}")
    public void selectTheParticipantGroupAs(String GroupName) {
        activitiesPage.participantGroup(GroupName);
    }

//    @Then("verify the title after clicking on create btn")
//    public void verifyTheTitleAfterClickingOnCreateBtn() {
//        activitiesPage.verifyTheTitleAfterClickingOnCreateBtn();
//    }

//    @And("choose the upload a video option and enter the module")
//    public void chooseTheUploadAVideoOptionAndEnterTheModule() {
//        activitiesPage.uploadAVideoAndEnterModuleName();
//    }

//    @Then("select module and {string}")
//    public void selectModuleAndAddMCQ(String arg0) {
//        activitiesPage.selectModuleAndAddMCQ();
//    }

    @And("enter the questions, options and add a quiz by selecting the {string} options")
    public void enterTheQuestionsOptionsAndAddAQuizBySelectingTheOptions(String choice) {
        activitiesPage.enterTheDetailsAndSelect(choice);
    }

//    @Then("click on the {string} and confirm")
//    public void clickOnThePublishCourseAndConfirm(String arg0) {
//        activitiesPage.clickOnThePublishCourseAndConfirm();
//    }

//    @Then("verify the uploaded video and quiz is displayed in the lesson details tab")
//    public void verifyTheUploadedVideoAndQuizIsDisplayedInTheLessonDetailsTab() {
//        activitiesPage.verifyDetailsInLessonDetailsTab();
//    }

//    @And("navigate to {string} dashboard")
//    public void navigateToDashboard(String activities) {
//        activitiesPage.navigateToDashboard(activities);
//    }

    @Then("verify that created {string} is displayed in {string} state")
    public void verifyThatCreatedIsDisplayedInScheduledState(String activites, String status) {
        activitiesPage.verifyThatCreatedIsDisplayedInScheduledState(activites, status);
    }

    @And("edit the created {string} details")
    public void editTheCreatedDetails(String arg0) {
        activitiesPage.editTheCreatedDetails();
    }

//    @Then("edit the {string} details for created {string}")
//    public void editTheLessonDetailsForCreated(String lesson, String arg1) {
//        activitiesPage.editTheLessonDetailsForCreated(lesson);
//    }

    @And("add the {string} by selecting {string} options for {string}")
    public void addTheBySelectingSingleOptionsFor(String module, String choice, String arg0) {
        activitiesPage.selectOptionAndEnterModuleName(module);
        activitiesPage.enterTheDetailsAndSelect(choice);
    }

    @Then("navigate to {string} state")
    public void navigateToScheduledState(String status) {
        activitiesPage.statusNavigation(status);
    }

    @And("select an existing {string}")
    public void selectAnExisting(String activity) {
        activitiesPage.selectAnExisting(activity);
    }


    @And("verify the details in {string} state after activating the created {string}")
    public void verifyTheDetailsInActiveStateAfterActivatingTheCreated(String status, String activity) {
        activitiesPage.verifyTheDetailsInActiveStateAfterActivatingTheCreated(status, activity);
    }

    @Then("verify the details in {string} state after deactivating the created {string}")
    public void verifyTheDetailsInInactiveStateAfterDeactivatingTheCreated(String status, String activity) {
        activitiesPage.verifyTheDetailsInInactiveStateAfterDeactivatingTheCreated(status, activity);
    }

    @And("enter the {string} name")
    public void enterTheName(String activityName) {
        activitiesPage.enterTheName(activityName);
    }

    @And("enter the {string} tag")
    public void enterTheTag(String tagName) {
        activitiesPage.enterTagName(tagName);
    }

    @And("select the timer in the schedule section")
    public void selectTheTimerInTheScheduleSection() {
        activitiesPage.theScheduleSection();
    }

    @And("click on the publish button")
    public void clickOnThePublishButton() {
        activitiesPage.thePublishBtn();
    }

    @And("click on the publish button on polls")
    public void clickOnThePublishButtonOnPolls() {
        activitiesPage.thePublishBtnOnPolls();
    }

    @And("verify the success toast message for {string}")
    public void verifyTheSuccessToastMessageFor(String activity) {
        activitiesPage.toastMessage(activity);
    }

    @Then("ensure the user should be able to view the added {string} in the pending section")
    public void ensureTheUserShouldBeAbleToViewTheAddedInThePendingSection(String activity) {
        activitiesPage.viewTheNewlyCreatedActivity(activity);
    }

    @And("deactivate the {string}")
    public void deactivateThe(String activityName) {
        activitiesPage.deactivateOption();
    }

    @Then("verify that the deactivated {string} should be listed in the inactive column")
    public void verifyThatTheDeactivatedShouldBeListedInTheInactiveColumn(String activity) {
        activitiesPage.inactiveOptionList(activity);
    }

    @And("ensure user should able to edit the name {string}")
    public void ensureUserShouldAbleToEditTheName(String editedName) {
        activitiesPage.editTheCreatedActivities(editedName);
    }

    @And("Enter the name as {string} in managing polls")
    public void enterTheNameAsInManagingPolls(String name) {
        activitiesPage.enterThePollsName(name);
    }

    @And("enter the poll question and its options")
    public void enterThePollQuestionAndItsOptions() {
        activitiesPage.enterThePollsQuestionAndOptions();
    }

    @And("select the timer in the schedule section for polling")
    public void selectTheTimerInTheScheduleSectionForPolling() {
        activitiesPage.setTimeForPolling();
    }

    @And("ensure the user should be able to view the added {string} in the Scheduled section")
    public void ensureTheUserShouldBeAbleToViewTheAddedInTheScheduledSection(String activity) {
        activitiesPage.verifyCreatingPolls(activity);
    }

    @And("navigate back to scheduled section and deactivate the poll")
    public void navigateBackToScheduledSectionAndDeactivateThePoll() {
        activitiesPage.navigateBackToScheduledSection();
    }

    @Then("verify that the deactivated {string} should be listed in the inactive column on the polls section")
    public void verifyThatTheDeactivatedShouldBeListedInTheInactiveColumnOnThePollsSection(String arg0) {
        activitiesPage.inactiveOptionListInPollSection();
    }

    @And("navigate to the scheduled section")
    public void navigateToTheScheduledSection() {
        activitiesPage.navigateToScheduledSection();
    }

    @Then("verify the success toast message for {string} after updating")
    public void verifyTheSuccessToastMessageForAfterUpdating(String activity) {
        activitiesPage.verifyTheSuccessToastMessageForAfterUpdating(activity);
    }

    @And("verify that the popup should be displayed for the deactivation")
    public void verifyThatThePopupShouldBeDisplayedForTheDeactivation() {
        activitiesPage.toastMessageForDeactivation();
    }

    @And("enter the Url Label and Url")
    public void enterTheUrlLabelAndUrl() {
        activitiesPage.enterUrl();
    }

    @And("navigate to scheduled section")
    public void navigateToScheduledSection() {
        activitiesPage.scheduledSection();
    }

    @Then("click on Participate")
    public void clickOnParticipate() {
        activitiesPage.clickOnParticipate();
    }

    @Then("inside Activities page select {string} option")
    public void insideActivitiesPageSelectOption(String activity) {
        activitiesPage.navigateToActivity(activity);
    }

    @And("click on the first {string}")
    public void clickOnTheFirst(String activity) {
        activitiesPage.navigateToCampaign(activity);
    }

    @And("ensure member should be able to click the videos added by admin")
    public void ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin() {
        activitiesPage.ensureMemberShouldBeAbleToClickTheVideosAddedByAdmin();
    }

    @And("ensure that members are able to add a new video.")
    public void ensureThatMembersAreAbleToAddANewVideo() {
        activitiesPage.addNewVideo();
    }

    @And("get the count of like and saved video")
    public void getTheCountOfLikeAndSavedVideo() {
        activitiesPage.getTheCountOfLikeAndSavedVideo();
    }

    @Then("ensure user should be able to like, comment, share, tag, report, and delete options are displayed for the {string}")
    public void ensureUserShouldBeAbleToLikeCommentShareTagReportAndDeleteOptionsAreDisplayedForThe(String activity) {
        activitiesPage.toolTipVerification(activity);
    }

    @And("get the count of complete and pending polls")
    public void getTheCountOfCompleteAndPendingPolls() {
        activitiesPage.countOfCompleteAndPendingPolls();
    }

    @And("ensure that members are able to answer the polls")
    public void ensureThatMembersAreAbleToAnswerThePolls() {
        activitiesPage.answerThePolls();
    }

    @And("verify the popup message")
    public void verifyThePopupMessage() {
        activitiesPage.verifyPopUpMessageAfterAnswering();
    }

    @Then("verify the count after submit the pending {string}")
    public void verifyTheCountAfterSubmitThePending(String activity) {
        activitiesPage.verifyTheCount(activity);
    }

    @And("get the count of completed, started and pending for the {string}")
    public void getTheCountOfCompletedStartedAndPendingForThe(String activity) {
        activitiesPage.getTheCountOfCompletedStartedAndPending(activity);
    }

    @And("select the first course assigned by an admin")
    public void selectTheFirstCourseAssignedByAnAdmin() {
        activitiesPage.selectTheFirstActivitiesInPendingSection();
    }

    @And("complete the {string}")
    public void completeThe(String arg0) {
        activitiesPage.completeTheActivity();
    }

    @Then("verify the {string} count after completing")
    public void verifyTheCountAfterCompleting(String arg0) {
        activitiesPage.verifyTheCourseCountAfterCompleting();
    }

    @And("activate the deactivated {string}")
    public void activateTheDeactivated(String arg0) {
        activitiesPage.activateTheDeactivated();
    }

    @And("activate the deactivated for polls")
    public void activateTheDeactivatedForPolls() {
        activitiesPage.activateTheDeactivatedPolls();
    }


    // new UI update
    @And("enter the {string} name and click on {string}")
    public void enterTheNameAndClickOnAddModules(String name, String arg1) {
        activitiesPage.enterTheNameAndClickOnAddModules(name);
    }

    @And("select {string} option and enter module name")
    public void selectOptionAndEnterModuleName(String module) {
        activitiesPage.selectOptionAndEnterModuleName(module);
    }

    @Then("click on upload button")
    public void clickOnUploadButton() {
        activitiesPage.clickOnUploadButton();
    }

//    @Then("enter the module name and click on upload button")
//    public void enterTheModuleNameAndClickOnUploadButton() {
//        activitiesPage.enterTheModuleNameAndClickOnUploadButton();
//    }

    @And("select {string} folder")
    public void selectFolder(String type) {
        activitiesPage.selectFolder(type);
    }

    @Then("select video and click on {string}")
    public void selectVideoAndClickOn(String addButton) {
        activitiesPage.selectVideoAndClickOn(addButton);
    }

    @And("click on Next button")
    public void clickOnNextButton() {
        activitiesPage.clickOnNextButton();
    }

    @And("edit the other details")
    public void editTheOtherDetails() {
        activitiesPage.editTheOtherDetails();
    }

    @Then("enter the description for the {string}")
    public void enterTheDescriptionForThe(String activity) {
        activitiesPage.enterTheDescriptionForThe(activity);
    }

    @And("click on continue to review")
    public void clickOnContinueToReview() {
        activitiesPage.clickOnContinueToReview();
    }

    @And("schedule the date")
    public void scheduleTheDate() {
        activitiesPage.scheduleTheDate();
    }

    @Then("verify the modules, schedule the date, and click on the {string} button")
    public void verifyTheModulesScheduleTheDateAndClickOnTheButton(String arg0) {
        activitiesPage.verifyTheModulesScheduleTheDateAndClickOnTheButton();
    }

    @Then("schedule the date, and click on {string} button")
    public void scheduleTheDateAndClickOnButton(String arg0) {
        activitiesPage.scheduleTheDateAndClickOnButton();
    }

    // sales bot
    @And("click on {string} in menu")
    public void clickOnInMenu(String manageType) {
        activitiesPage.clickOnInMenu(manageType);
    }

    @Then("verify the {string} page and setup")
    public void verifyThePageAndSetup(String manageType) {
        activitiesPage.verifyThePageAndSetup(manageType);
    }

    @Then("verify the success Message after uploading the video in {string}")
    public void verifyTheSuccessMessageAfterUploadingTheVideoIn(String arg0) {
        activitiesPage.verifyTheSuccessMessageAfterUploadingTheVideoIn();
    }

    @And("select video and click on {string} button")
    public void selectVideoAndClickOnAddToButton(String addBtn) {
        activitiesPage.selectVideoAndClickOnAddToSalesbotButton(addBtn);
    }

    @And("check the {string}")
    public void checkThe(String view) {
        activitiesPage.checkThe(view);
    }
}

package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.manageVideosPage;

public class ManageVideos_Steps {

    @And("inside Manage videos menu select {string} option")
    public void insideManageVideosMenuSelectOption(String type) {
        manageVideosPage.insideManageVideosMenuSelectOption(type);
    }

    @Then("verify the module and {string} title")
    public void verifyTheModuleAndTitle(String type) {
        manageVideosPage.verifyTheModuleAndTitle(type);
    }

    @And("select an video and click on {string} btn")
    public void selectAnVideoAndClickOnReviewBtn(String arg0) {
        manageVideosPage.selectAnVideoAndClickOnReviewBtn();
    }

    @And("verify the video title")
    public void verifyTheVideoTitle() {
        manageVideosPage.verifyTheVideoTitle();
    }

    @Then("verify the success message after {string} the video")
    public void verifyTheSuccessMessageAfterTheVideo(String approveType) {
        manageVideosPage.verifyTheSuccessMessageAfterTheVideo(approveType);
    }

    @When("click on new video")
    public void clickOnNewVideo() {
        manageVideosPage.clickOnNewVideo();
    }

    @And("upload video & enter the details")
    public void uploadVideoEnterTheDetails() {
        manageVideosPage.uploadVideoEnterTheDetails();
    }

    @Then("verify the uploaded video in respective group")
    public void verifyTheUploadedVideoInRespectiveGroup() {
        manageVideosPage.verifyTheUploadedVideoInRespectiveGroup();
    }

    @Then("verify the video in account profile")
    public void verifyTheVideoInAccountProfile() {
        manageVideosPage.verifyTheVideoInAccountProfile();
    }

    @When("based on any search")
    public void basedOnAnySearch() {
        manageVideosPage.basedOnAnySearch();
    }

    @Then("it should display respective suggestion")
    public void itShouldDisplayRespectiveSuggestion() {
        manageVideosPage.itShouldDisplayRespectiveSuggestion();
    }

    @Then("verify the {string} title")
    public void verifyTheTitle(String videoType) {
        manageVideosPage.verifyTheTitle(videoType);
    }

//    @And("click on {string} folder")
//    public void clickOnFolder(String folderType) {
//        manageVideosPage.clickOnFolder(folderType);
//    }

    @Then("{string} in to the folder")
    public void addFileInToTheFolder(String arg0) {
        manageVideosPage.addFileInToTheFolder();
    }

    @Then("verify the success Message after uploading the video")
    public void verifyTheSuccessMessageAfterUploadingTheVideo() {
        manageVideosPage.verifyTheSuccessMessageAfterUploadingTheVideo();
    }
}

package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Supports.PagesClass.dashboardPage;

public class Dashboard_Steps {

    @And("navigate on library")
    public void navigateOnLibrary() {
        dashboardPage.navigateOnLibrary();
    }

    @Then("verify the uploaded video in the library")
    public void verifyTheUploadedVideoInTheLibrary() {
        dashboardPage.verifyTheUploadedVideoInTheLibrary();
    }

    @And("click on {string} sales bot")
    public void clickOnCreateSalesBot(String btn) {
        dashboardPage.clickOnCreateSalesBot(btn);
    }

    @Then("upload a video content & verify the message")
    public void uploadAVideoContentVerifyTheMessage() {
        dashboardPage.uploadAVideoContentVerifyTheMessage();
    }

    @And("add your question")
    public void addYourQuestion() {
        dashboardPage.addYourQuestion();
    }

    @Then("click on create QA button & verify the message")
    public void clickOnCreateQAButtonVerifyTheMessage() {
        dashboardPage.clickOnCreateQAButtonVerifyTheMessage();
    }

    @Then("select a video content")
    public void selectAVideoContent() {
        dashboardPage.selectAVideoContent();
    }

    @Then("select pdf content")
    public void selectPdfContent() {
        dashboardPage.selectPDFContent();
    }

    @Then("select ppt content")
    public void selectPptContent() {
        dashboardPage.selectPPTContent();
    }

    @Then("select document content")
    public void selectDocumentContent() {
        dashboardPage.selectDocumentContent();
    }

    @And("select {string} & click on install")
    public void selectClickOnInstall(String app) {
        dashboardPage.selectClickOnInstall(app);
    }

    @Then("verify the {string} once installed")
    public void verifyTheOnceInstalled(String app) {
        dashboardPage.verifyTheOnceInstalled(app);
    }

    @Then("verify the title & click on done")
    public void verifyTheTitleClickOnDone() {
        dashboardPage.verifyTheTitleClickOnDone();
    }

    @Then("verify whether the sales bot create a answer")
    public void verifyWhetherTheSalesBotCreateAAnswer() {
        dashboardPage.verifyWhetherTheSalesBotCreateAAnswer();
    }
}

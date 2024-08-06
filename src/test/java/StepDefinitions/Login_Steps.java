package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.loginPage;

public class Login_Steps {
    @Given("get the URL of the application")
    public void getTheURLOfTheApplication() {
        loginPage.getTheUrlOfApplication();
    }

    @When("enter the username")
    public void enterTheUsername() {
        loginPage.enterTheUsernameAndVerify();
    }

    @And("verify the continue btn is displayed or not, if displayed enter password and login")
    public void verifyTheContinueBtnIsDisplayedOrNotIfDisplayedEnterPasswordAndLogin() {
        loginPage.verifyTheContinueBtnAndLogin();
    }

    @Then("if not click on register, enter the details and login")
    public void ifNotClickOnRegisterEnterTheDetailsAndLogin() throws InterruptedException {
        loginPage.clickOnRegisterAndLogin();
    }
}

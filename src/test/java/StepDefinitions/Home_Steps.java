package StepDefinitions;

import io.cucumber.java.en.Then;

import static Supports.PagesClass.homePage;

public class Home_Steps {
    @Then("Verify that the count matches the profile after reacting to the video")
    public void verifyThatTheCountMatchesTheProfileAfterReactingToTheVideo() {
        homePage.userShouldBeAbleToReactForTheVideo();
    }
}

package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Supports.PagesClass.analyticsPage;

public class Analytics_Steps {
    @When("navigate to analytics")
    public void navigate_to_analytics() {
        analyticsPage.navigateToAnalytics();
    }

    @And("navigate to {string} column")
    public void navigateToColumn(String activity) {
        analyticsPage.navigateToActivity(activity);
    }

    @Then("verify that the column names in the {string}")
    public void verifyThatTheColumnNamesInThe(String activity) {
        analyticsPage.verifyTheColumnName(activity);
    }

    @And("ensure that the activity names and view more option are present in the analytics page")
    public void ensureThatTheActivityNamesAndViewMoreOptionArePresentInTheAnalyticsPage() {
        analyticsPage.verifyTheActivityNameAndViewMoreOption();
    }
}

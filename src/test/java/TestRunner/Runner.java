package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/Features",
        glue = {
                "Supports",
                "StepDefinitions"
        },
        plugin = {
                "de.monochromata.cucumber.report.PrettyReports:target/",
                "json:target/cucumber-report/report.json",
                "html:target/report.html",
        },
        tags = "@AppIntegration and @Admin"
)

public class Runner {
    @BeforeClass
    public static void setup() {
        System.out.println("\n******* RUN STARTS " + new java.util.Date() + " *******************************");

        System.out.println("Feature file directory: " + System.getProperty("user.dir") + "/src/test/java/features");
    }
}

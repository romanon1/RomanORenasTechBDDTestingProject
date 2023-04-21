package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = "stepDefinitions",
        tags = "@Smoke_Suite",
        dryRun = false,
        plugin = {
                "pretty",
                "rerun:target/rerun.txt",
                "html:target/default-cucumber-reports.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner {
}

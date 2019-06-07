import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        plugin = {"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-json-report.json"})
public class TestRunner {

}

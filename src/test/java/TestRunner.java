import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        plugin = {"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-json-report.json"})
public class TestRunner {

}

package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFile",
        glue = "StepDefinition", plugin = {"pretty", "json:src/test/java/Report/Cucumber.json", "junit:src/test/java/Report/XMLReport.xml",
        "html:src/test/java/Report/cucumberReport.html"})
public class RunnerClass {
}

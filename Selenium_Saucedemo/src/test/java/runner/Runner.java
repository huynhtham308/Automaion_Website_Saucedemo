package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/resource",
        glue = {"step"})
public class Runner extends AbstractTestNGCucumberTests {
}

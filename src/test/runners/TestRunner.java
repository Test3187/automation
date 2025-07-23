package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs" ,"hooks" },
        plugin = {"pretty"},   //"html: target/cucumber-reports/reports.html"
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
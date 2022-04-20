package cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features/TruTime.feature", //path of feature file
		glue = "testSuites",                  //path of step definition File
		plugin = {"pretty", "html:Report-cucumber/cucumber-report.html"},
		dryRun = false,
		monochrome = true		
		)
public class TestRunner {
	
}

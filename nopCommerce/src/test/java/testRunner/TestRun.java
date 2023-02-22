package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/",
                 glue = "stepDefinitions", 
                 dryRun = false,
                // tags= {"@sanity"},
                 plugin= {"pretty","html:test-output/report.html"})
public class TestRun {
	
}

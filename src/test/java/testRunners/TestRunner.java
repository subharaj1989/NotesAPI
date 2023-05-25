package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="C:\\Users\\Subha\\LiveProjects\\NotesAPI\\src\\test\\resources\\featurefiles",
 glue={"stepDefinition","hooks"},
 plugin= {"summary"},
 tags = "@DeleteAccount"
 
 
		)
public class TestRunner {

}

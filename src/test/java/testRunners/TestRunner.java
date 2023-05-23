package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="C:\\Users\\Subha\\LiveProjects\\NotesAPI\\src\\test\\resources\\featurefiles",
 glue={"stepDefinition"},
 plugin= {"summary"},
 tags = "@login or @updateProfie"
 
 
		)
public class TestRunner {

}

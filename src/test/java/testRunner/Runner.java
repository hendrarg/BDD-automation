package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions (
		features = {"src/test/java/features/Login.feature"},
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = "steps"
		)
public class Runner extends AbstractTestNGCucumberTests {
}

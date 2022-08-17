package suite;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java",
		glue = "stepdefinitions",
		monochrome=true,
//		tags="@smoketest",
		tags="@selenium",
//		dryRun =true,  //if dryrun =true then it will check whether all fetaure file as step definition                         
		snippets = SnippetType.CAMELCASE,
		plugin= {"pretty","html:target/report.html"})
public class TestRunner {

}

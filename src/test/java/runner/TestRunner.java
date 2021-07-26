package runner;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/features/Google/search.feature"},
				glue = {"teststeps"}
				)
public class TestRunner {

}

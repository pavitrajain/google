package teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actors.GoogleActor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchTestSteps {

	@Steps
	GoogleActor googleUser; 
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SearchTestSteps.class);
	
	@Given("^User access google website$")
	public void user_access_google_website() throws Exception {
	    googleUser.openGoogle();
	}

	@When("^User search using keyword: (.*)$")
	public void user_search_using_keyword_selenium(String keyword) throws Exception {
	    googleUser.searchUsingKeyword(keyword);
	}

	@Then("^User should see search results for (.*)$")
	public void user_should_see_search_results(String keyword) throws Exception {
	    googleUser.verifySearchResult(keyword);
	}


	@When("^User search without providing keyword$")
	public void user_search_without_providing_keyword() throws Exception {
	    googleUser.searchUsingKeyword("");
	}

	@Then("^User should remain on google home page$")
	public void user_should_remain_on_google_home_page() throws Exception {
		googleUser.verifyNoSearchResult();
	}
	
}

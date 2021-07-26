package actors;

import org.aeonbits.owner.ConfigFactory;

import com.sample.core.util.EnvConfig;

import net.thucydides.core.annotations.Step;
import pages.SearchPage;
import pages.SearchResultPage;

public class GoogleActor {

	SearchPage sPage;
	SearchResultPage srPage;
	
	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	
	@Step
	/**
	 * Step to open google.com
	 */
	public void openGoogle() {
		//sPage.open();
		sPage.openUrl(ENV.googleURL());
	}

	/**
	 * Step to search using provided keyword
	 * @param keyword - Keyword
	 */
	public void searchUsingKeyword(String keyword) {
		sPage.search(keyword);		
	}

	@Step
	/**
	 * Step to verify search result is displayed for provided term
	 * @param keyword - search term
	 */
	public void verifySearchResult(String keyword) {
		srPage.verifyResultFor(keyword);		
	}

	@Step
	/**
	 * Step to verify no search result displayed
	 */
	public void verifyNoSearchResult() {
		sPage.verifySearchPageIsDisplayed();
		
	}	

}

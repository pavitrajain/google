package pages;

import static org.assertj.core.api.Assertions.assertThat;

import net.serenitybdd.core.pages.PageObject;

public class SearchResultPage extends PageObject{
	
	public void verifyResultFor(String keyword) {
		if(keyword.equalsIgnoreCase("selenium")) {
			String title = getDriver().getTitle();
			assertThat(title).as("Search Result for " + keyword).contains(keyword);
		} else {
			assertThat(false).as("Search Result for " + keyword).isTrue();
		}
		
	}

}

package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://www.google.com")
public class SearchPage extends PageObject {
	
	@FindBy(xpath = "//*[@name='q']")
	private WebElementFacade searchField;
	
	@FindBy(xpath = "//*[@name='btnK']")
	private WebElementFacade searchButton;
		
	public static final Logger LOGGER = LoggerFactory.getLogger(SearchPage.class);
	
	private void enterSearchKeyword(String keyword) {
		LOGGER.info("Entering keyword: " + keyword);
		searchField.type(keyword);
	}

	private void clickSearchButton() {
		searchField.sendKeys(Keys.ENTER);		
	}
	
	@Step
	public void search(String keyword) {
		enterSearchKeyword(keyword);
		clickSearchButton();
	}

	public void verifySearchPageIsDisplayed() {
		String title = getDriver().getTitle();
		assertThat(title).as("Search Page").isEqualTo("Google");		
	}

}

package stepDefinitions;

import org.pages.SearchFuncPage;
import org.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFuncStepDef {
	private SearchFuncPage sfp = new SearchFuncPage(DriverFactory.getDriver());
	@When("Enter search text as {string}")
	public void enter_search_text_as(String searchText) {
		sfp.enterSearchText(searchText);
	}
	@When("Clicks on Search button")
	public void clicks_on_search_button() {
		sfp.clickSearchBtn();
	}
	@Then("Search should display the result for {string}")
	public void search_should_display_the_result(String name) {
		sfp.verifySearchedMobile(name);
	}
}
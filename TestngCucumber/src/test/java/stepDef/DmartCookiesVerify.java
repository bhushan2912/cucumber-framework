package stepDef;

import Base.DriverManager;
import Hooks.ApplicationHooks;
import Pages.DmartToValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DmartCookiesVerify {
	
	private DmartToValidation dtv_obj=new DmartToValidation(DriverManager.getDriver());
	
	@Given("^I have Url of dmart website$")
	public void I_have_Url_of_dmart_website() {
		DriverManager.getDriver().get(ApplicationHooks.prop.getProperty("urlDmart"));
		
	}
	@Given("I select city as a kalyan and expect in dropdown list as {string}")
	public void I_select_city_as_a_kalyan_and_expect_in_dropdown_list_as(String cityName) throws InterruptedException {
		dtv_obj.searchCity(cityName);
	}
	@When("I search as {string} in search field")
	public void I_search_as_in_search_field(String cookies) {
		dtv_obj.searchGroc(cookies);
	}
	@Then("^Print all cookies and prices$")
	public void Print_all_cookies_and_prices() throws InterruptedException {
		dtv_obj.cookiesDetails();
	}

}

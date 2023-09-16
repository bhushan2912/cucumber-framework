package stepDefinitions;

import org.applicationHooks.ApplicationHooks;
import org.junit.Assert;
import org.pages.LoginPage;
import org.qa.factory.DriverFactory;
import org.qa.utility.ElementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	private static String title;
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get(ApplicationHooks.prop.getProperty("url"));
	}
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = lp.getLoginPageTitle();
		System.out.println("Login page title is : "+title);
	}
	@Then("Title of login page should be {string}")
	public void title_of_the_login_page_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}
	@When("User enters username and password")
	public void user_enters_username_and_password() {
		lp.enterUserName();
		lp.enterPassword();
	}
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		lp.clickLoginButton();
	}
	@Then("My Account label is displayed")
	public void my_account_label_is_displayed() {
		Assert.assertTrue(lp.isMyAccountLabelDisplayed());
	}
	@Then("Page title should be {string}")
	public void home_Page_title_should_be(String expectedTitle) { // throws InterruptedException {
//		Thread.sleep(5000);
		ElementUtil.eu.waitForPageLoad(DriverFactory.getDriver());
		String actualTitle = lp.getLoginPageTitle();
		System.out.println("actualTitle : "+actualTitle);
		System.out.println("expectedTitle : "+expectedTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
}

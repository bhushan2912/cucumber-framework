package stepDef;

import org.testng.Assert;

import Base.DriverManager;
import Pages.LoginLogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SkillLoginLogoutStepDef {
	
	private LoginLogoutPage sl = new LoginLogoutPage(DriverManager.getDriver());
	private String tbPage;
	private String skillPage;
	
	@Given("User is on testbook landing page {string}")
	public void user_is_on_testbook_landing_page(String url) {
	    tbPage=sl.tbLandingPage(url);
	}
	@Given("User clicks on skillAcademy page")
	public void user_clicks_on_skill_academy_page() {
	    skillPage=sl.tbSkillPageClicked();
	}
	@Given("User is on skillAcademy page")
	public void user_is_on_skill_academy_page() {
	    Assert.assertNotEquals(tbPage, skillPage);
	}
	@When("User logged in with login number {string} and otp {string}")
	public void user_logged_in_with_login_number_and_otp(String user, String otp) {
		sl.login(user, otp);
	    
	}
	@When("User is on skillAcademy page in logged in state")
	public void user_is_on_skill_academy_page_in_logged_in_state() {
	   Assert.assertEquals(sl.skillPageLoggedIn(), skillPage);
	}
	
	@Then("User is loggedout")
	public void user_is_loggedout() {
	   sl.logout();
	}
}

package stepDef;

import org.testng.Assert;

import Base.DriverManager;
import Hooks.ApplicationHooks;
import Pages.LoginLogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SkillLoginLogoutStepDef {
	
	private LoginLogoutPage sl = new LoginLogoutPage(DriverManager.getDriver());
	private String tbPage;
	private String skillPage;
	private String coursePageTitle;
	
	@Given("User is on testbook landing page")
	public void user_is_on_testbook_landing_page() {
	    tbPage=sl.tbLandingPage(ApplicationHooks.prop.getProperty("urltb"));
	}
	@Given("User clicks on skillAcademy page")
	public void user_clicks_on_skill_academy_page() {
	    skillPage=sl.tbSkillPageClicked();
	}
	@Given("User is on skillAcademy page")
	public void user_is_on_skill_academy_page() {
	    Assert.assertNotEquals(tbPage, skillPage);
	}
	@Given("User is navigate to {string} course and {string} and {string}")
	public void user_is_navigate_to_slug_course(String slug, String courseType, String courseName){
		coursePageTitle=sl.coursePageLanding(slug, courseType, tbPage);
		Assert.assertEquals(coursePageTitle, courseName);
	}
	@When("User logged in with login number {string}")
	public void user_logged_in_with_login_number_and_otp(String user) {
		sl.login(user, ApplicationHooks.prop.getProperty("otp"));
	    
	}
	@When("User is on skillAcademy page in logged in state")
	public void user_is_on_skill_academy_page_in_logged_in_state() {
	   Assert.assertEquals(sl.skillPageLoggedIn(), skillPage);
	}
	@When("User is on course page in logged in state")
	public void user_is_on_course_page_in_logged_in_state() {
		sl.validateLogin();
	}
	@Then("User is loggedout")
	public void user_is_loggedout() {
	   sl.logout();
	}
}

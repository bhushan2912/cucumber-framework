package stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Base.DriverManager;
import Hooks.ApplicationHooks;
import Pages.HomePageVtiger;
import Pages.LoginPageVtiger;
import Pages.TaskPageVtiger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;



public class TestVtigerAddContact {
	private String username,password;
	private LoginPageVtiger glp_obj= new LoginPageVtiger(DriverManager.getDriver());
	private HomePageVtiger ghp_obj;
	private TaskPageVtiger gtp_obj;
	
	@Given("^User is already having application URL of vtiger$")
	public void user_is_already_having_application_URL_of_vtiger() {
	    DriverManager.getDriver().get(ApplicationHooks.prop.getProperty("urlVtiger"));
	    
	}

	@Given("User is already having login credentials")
	public void User_is_already_having_login_credentials(DataTable credTable) {
	    List<Map<String,String>> credList=credTable.asMaps();
	    
	    this.username=credList.get(0).get("username");
	    this.password=credList.get(0).get("password"); 
	    
	}

	@When("^user enter the username and password for vtiger$")
	public void user_enter_the_username_and_password_for_vtiger() {
		glp_obj.enterLoginCredentials(username, password);
	    
	}

	@When("^clicks on login button for vtiger$")
	public void clicks_on_login_button_for_vtiger() {
		ghp_obj=glp_obj.clickOnLoginButton();
	    
	}

	@Then("^user gets contacts page$")
	public void user_gets_contacts_page(){
		gtp_obj=ghp_obj.ContactPage();
	    
	}

	@When("^user clicks on add contacts button$")
	public void user_clicks_on_add_contacts_button() {
		gtp_obj.addContactButton();
	    
	}

	@When("user create contact with {string},{string},{string}")
	public void user_create_contact_with(String firstname, String lastname, String mobileNumber) {
		gtp_obj.newContactCreate(firstname, lastname, mobileNumber);
	    
	}
	@When("^select check box of created contact$")
	public void select_check_box_of_created_contact() {
		gtp_obj.selectCheckboxOfContact();
	}
	@When("^delete selected contact$")
	public void delete_selected_contact() {
		gtp_obj.deleteCreatedContact();
	}
	@When("^user validate that contact is deleted or not$")
	public void user_validate_that_contact_is_deleted_or_not() {
		gtp_obj.checkContactDelete();
	}
	

	@Then("^user validate that new contact created or not$")
	public void user_validate_that_new_contact_created_or_not() {
	    System.out.println("New Contact created: "+gtp_obj.checkNewlyCreatedContact());
	    
	}

	@Then("^user clicks on logout button and close the window$")
	public void user_clicks_on_logout_button_and_close_the_window() {
		gtp_obj.signOut();
	    
	}
}

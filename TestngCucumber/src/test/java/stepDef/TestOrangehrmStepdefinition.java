package stepDef;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Base.DriverManager;
import Hooks.ApplicationHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestOrangehrmStepdefinition {
	private WebDriver driver=DriverManager.getDriver();
	String username,password;

	@Given("^User is already having URL$")
	public void user_is_already_having_URL() {
	   DriverManager.getDriver().get(ApplicationHooks.prop.getProperty("urlOHRM"));
	   System.out.println("URL :https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Given("^also having username and password$")
	public void also_having_username_and_password() {
	    username="Admin";
	    password="admin123";
	}

	@When("^clicks on login button$")
	public void clicks_on_login_button() {
	    driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^close the browser$")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(2000);
	    driver.close();
	}

	@Given("^User is already having appliction URL as (.+)$")
	public void user_is_already_having_appliction_URL_as_url(String url) {
		
       DriverManager.getDriver().get(url);
	   
	}

	@Given("^Also having username as (.+) and password as (.+) for the application$")
	public void also_having_username_as_username_and_password_as_password_for_the_application(String username,String password) {
	    this.username=username;
	    this.password=password;
	}

	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

}

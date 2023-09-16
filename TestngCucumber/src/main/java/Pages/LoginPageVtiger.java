package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;



public class LoginPageVtiger {
	
	WebDriver driver;
	
	public LoginPageVtiger(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="username")
	private WebElement username;
	
	@FindBy (id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement loginbutton;
	
	public void enterLoginCredentials(String userId,String pwd) {
		ElementUtil.eu.typeInput(username,userId);
		ElementUtil.eu.typeInput(password,pwd);
	}
	public HomePageVtiger clickOnLoginButton() {
		ElementUtil.eu.clickOnElement(loginbutton);
		return new HomePageVtiger(driver);
	}

}

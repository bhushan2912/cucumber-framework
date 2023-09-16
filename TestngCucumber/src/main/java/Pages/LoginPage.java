package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utility.ElementUtil;


public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath="//div[div[span[span[text()='Login']]]]//input[@type='text']")
	private WebElement userName;
	
	@FindBy(xpath="//div[div[span[span[text()='Login']]]]//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//div[div[span[span[text()='Login']]]]//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a/span[text()='Forgot?']")
	private WebElement forgotLink;
	
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccountLabel;
	
	public LoginPage(WebDriver driver) {	//constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean isforgotLinkDisplayed() {
		return forgotLink.isDisplayed();
	}
	public boolean isMyAccountLabelDisplayed() {
		ElementUtil.eu.waitForStaleElement(driver,10,myAccountLabel);
		ElementUtil.eu.waitForVisiblityOfElementLocated(driver, 5, "xpath", "//div[text()='My Account']");
		return myAccountLabel.isDisplayed();
	}
	public void enterUserName() {
		userName.sendKeys("Admin123");
	}
	public void enterPassword() {
		password.sendKeys("Admin");
	}
	public void clickLoginButton() {
		loginButton.click();
	}
//	Used in another project
	public TasksPage doLogin(String username, String pwd) {
		System.out.println("Login creds: "+username+" and "+pwd);
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		ElementUtil.eu.waitForPageLoad(DriverManager.getDriver());
		return new TasksPage(driver);
	}
}
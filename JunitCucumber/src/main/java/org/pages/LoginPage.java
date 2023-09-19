package org.pages;

//import org.applicationHooks.ApplicationHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.factory.DriverFactory;
import org.qa.utility.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(css="table.textFieldsTable #username")
	private WebElement userName;
	
	@FindBy(css="#demoCredentials>tbody>:first-child b")
	private WebElement getUserName;
	
	@FindBy(css="input.textField.pwdfield")
	private WebElement password;
	
	@FindBy(id="loginButton")
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
//		userName.sendKeys(ApplicationHooks.prop.getProperty("username"));
	}
	public void enterPassword() {
//		password.sendKeys(ApplicationHooks.prop.getProperty("password"));
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
		ElementUtil.eu.waitForPageLoad(DriverFactory.getDriver());
		return new TasksPage(driver);
	}
}
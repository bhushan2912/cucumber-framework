package Pages;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.ElementUtil;

public class LoginLogoutPage extends ElementUtil{
		WebDriver driver;
		public LoginLogoutPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="a[title=\"Sign Up\"]")
		private WebElement signUpButton;
		
		@FindBy(id="onBoardingIframe")
		private WebElement loginIframe;
		
		@FindBy(xpath="//a[text()='Explore Programs']")
		private WebElement exploreProgramsCta;
		
		@FindBy(css="input[name=\"mob\"]")
		private WebElement numberInputField;
		
		@FindBy(xpath="//button[text()=\"continue\"]")
		private WebElement continueButton;
		
		@FindBy(xpath="//input[@name=\"otp\"]")
		private WebElement otpInputField;
		
		@FindBy(xpath="//button[text()=\"LOGIN\"]")
		private WebElement LoginButton;
		
		@FindBy(xpath="//img[@class=\"profile-pic\"]")
		private WebElement profilePicIcon;
		
		@FindBy(xpath="//button[text()=\"Get Pass\"]")
		private WebElement getPassButton;
		
		@FindBy(xpath="//a[text()='Logout']")
		private WebElement logoutCta;
		
		@FindBy(css="a.skills")
		private WebElement skillAcademyOnNav;
		
		@FindBy(css="li.dropdown div.dropdown-menu>:nth-child(2)")
		private WebElement settings;
		
		@FindBy(css="form[name=\"updateUserInfo\"]>:nth-child(2) div.ng-binding")
		private WebElement nameField;
		
		@FindBy(css="a[class=\"home\"]")
		private WebElement sideNavHomeTab;
		
		@FindBy(xpath="//a[text()=\" Skill Academy \"]")
		private WebElement skillAcademyTab;
		
//		@FindBy(css="li.dropdown>img")
//		private WebElement profileLogo;
		
		public String tbLandingPage(String url) {
			driver.get(url);
			return driver.getCurrentUrl();
		}
		public String tbSkillPageClicked() {
			clickOnElement(skillAcademyTab);
			waitForElementDisplayed(exploreProgramsCta);
			return driver.getCurrentUrl();
		}
		
		public void login(String user, String otp) {
			clickOnElement(signUpButton);
			driver.switchTo().frame(loginIframe);
			String urlBeforeLogin = driver.getCurrentUrl();
			System.out.println("UrlBeforeLogin :"+urlBeforeLogin);
			waitForStaleElement(driver, numberInputField);
			clickOnElement(numberInputField);
			typeInput(numberInputField, user);
			clickOnElement(continueButton);
			clickOnElement(otpInputField);
			typeInput(otpInputField, otp);
			clickOnElement(LoginButton);
			driver.switchTo().defaultContent();
//			staleElementExceptionHandle(sideNavHomeTab);
//			waitForStaleElement(driver, 20, sideNavHomeTab);
			waitForElementDisplayed(profilePicIcon);
//			clickOnElement(sideNavHomeTab);
//			String urlAfterLogin = driver.getCurrentUrl();
//			System.out.println("UrlAfterLogin :"+urlAfterLogin);
//			assertNotEquals(urlBeforeLogin, urlAfterLogin);
//			System.out.println("Successfully Login");
		}
		public String skillPageLoggedIn() {
			clickOnElement(skillAcademyOnNav);
			waitForElementDisplayed(exploreProgramsCta);
			return driver.getCurrentUrl();
		}
		
		public void logout() {
			String urlBeforeLogout = driver.getCurrentUrl();
			System.out.println("UrlBeforeLogout :"+urlBeforeLogout);
			clickOnElement(profilePicIcon);
			clickOnElement(logoutCta);
			waitForElementToBeClickable(signUpButton);
			System.out.println("UrlAfteLogout :"+driver.getCurrentUrl());
			Assert.assertNotEquals(urlBeforeLogout, driver.getCurrentUrl());
			System.out.println("Successfully Logout");
			driver.close();
		}
		
		
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;


public class HomePageVtiger{
	
	private WebDriver driver;
	
	public HomePageVtiger(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="appnavigator")
	private WebElement menu;
	
	@FindBy (css=".app-list.row>:nth-child(2)>div>div>:nth-child(2)")
	private WebElement marketing;
	
	@FindBy(xpath="//span[text()=' Contacts']")
	private WebElement contacts;
	
	public TaskPageVtiger ContactPage(){
		ElementUtil.eu.clickOnElement(menu);
		ElementUtil.eu.clickOnElement(marketing);
		ElementUtil.eu.clickOnElement(contacts);

		
		return new TaskPageVtiger(driver);
		
	}

}

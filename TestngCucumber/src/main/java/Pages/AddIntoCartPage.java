package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;
import Utility.ElementUtil;



public class AddIntoCartPage {
	
	private WebDriver driver;
	
	public AddIntoCartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#block_top_menu>:nth-child(2)>:nth-child(2)>a")
	private WebElement dresses; 
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a")
	private WebElement eveningDresses;
	
	@FindBy(css="#uniform-layered_id_attribute_group_3")
	private WebElement LargeCheckbox;
	
	@FindBy(css="#uniform-layered_id_feature_16")
	private WebElement dressyCheckBox;
	
	@FindBy(css="div.product-container>:nth-child(2)>h5>a")
	private WebElement dressName;
	
	@FindBy(css="div.product-container>:nth-child(2)>:nth-child(3)>span")
	private WebElement dressprice;
	
	@FindBy(css="a.button.ajax_add_to_cart_button.btn.btn-default>span")
	private WebElement addToCart;
	
	public void selectDress()
	{	
		Actions act =new Actions(driver);
		act.moveToElement(dresses).build().perform();
		eveningDresses.click();
		LargeCheckbox.click();
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		dressyCheckBox.click();
	}
	public String getDressName() {
		
		return dressName.getText();
	}
    public String getDressPrice() {
		
		return dressprice.getText();
	}
	public CartPage addTocart() {
		Actions act = new Actions(driver);
		act.moveToElement(dressName).perform();
		addToCart.click();
//		ElementUtil.eu.waitForPageLoad(DriverManager.getDriver());
		return new CartPage(driver);
		
	}

}

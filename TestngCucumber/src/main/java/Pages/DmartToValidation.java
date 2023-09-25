package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;

public class DmartToValidation {
	
	private WebDriver driver;
	
	public DmartToValidation(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="pincodeInput")
	private WebElement inputcity;
	
	@FindBy(css="div.pincode-widget_slide-cntr__yQ7Wn button div")
	private WebElement listCity;
	
	@FindBy(xpath="//button[text()='START SHOPPING']")
	private WebElement startShopping;
	
	@FindBy(id="scrInput")
	private WebElement searchContent;
	
	@FindBy(css="div.search_src-backdrop-cntr__7iWhO button")
	private WebElement searchButton;
	
	@FindBy(css="h1.search-landing_searchHeaderDiv__wk7EX span")
	private WebElement results;
	
	
	public void searchCity(String City) {
		ElementUtil.eu.clickOnElement(inputcity);
		ElementUtil.eu.typeInput(inputcity, "kalyan");
		ElementUtil.eu.waitForElementDisplayed(listCity);
		
		List<WebElement> cities=driver.findElements(By.cssSelector("div.pincode-widget_slide-cntr__yQ7Wn button div"));
		
		for(int i=0;i<cities.size();i++) {
			cities=driver.findElements(By.cssSelector("div.pincode-widget_slide-cntr__yQ7Wn button div"));
			String city=cities.get(i).getText();
			if(city.equals(City)) {
				cities.get(i).click();
			}
		}
		ElementUtil.eu.clickOnElement(startShopping);
	}
	
	public void searchGroc(String groc) {//cookies
		ElementUtil.eu.waitForStaleElement(driver,Duration.ofSeconds(30),searchContent);
		ElementUtil.eu.clickOnElement(searchContent);
		ElementUtil.eu.typeInput(searchContent, groc);
		
		ElementUtil.eu.clickOnElement(searchButton);//
	}
	
	public void cookiesDetails(){
		ElementUtil.eu.waitForElementDisplayed(results);
		ElementUtil.eu.scrollByPageDown(driver,50);
		List <WebElement> product=driver.findElements(By.cssSelector("div.MuiGrid-spacing-xs-1>div.MuiGrid-root>:first-child>:nth-child(2)>div"));
		List <WebElement> Mrp=driver.findElements(By.cssSelector("div.vertical-card_price__Y6yhX>div>div>:first-child>:nth-child(2)>:nth-child(2)"));
		List <WebElement> DmartPrice=driver.findElements(By.cssSelector("div.vertical-card_price__Y6yhX>div>div>:nth-child(2)>:nth-child(2)>:nth-child(2)"));
		
		for(int i=0;i<product.size();i++) {
			String name=product.get(i).getText();
			String mrp=Mrp.get(i).getText();
			String Dprice=DmartPrice.get(i).getText();
			int row=i+1;
			ElementUtil.eu.updateCellValue(".\\src\\test\\resources\\org\\Excel\\AppData.xlsx","Sheet3", row, 1, name);
			ElementUtil.eu.updateCellValue(".\\src\\test\\resources\\org\\Excel\\AppData.xlsx","Sheet3", row, 2, mrp);
			ElementUtil.eu.updateCellValue(".\\src\\test\\resources\\org\\Excel\\AppData.xlsx","Sheet3", row, 3, Dprice);
			System.out.println(name+"      MRP:"+mrp+"     Dprice: "+Dprice);
		}
	}
}

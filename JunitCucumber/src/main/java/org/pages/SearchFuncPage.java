package org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchFuncPage {
	private WebDriver driver;
	
	@FindBy(css="input[name='q']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']/*")
	private WebElement searchBtn;
	
	public SearchFuncPage(WebDriver driver) {	//constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void enterSearchText(String searchText) {
		searchField.sendKeys(searchText);
	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public void verifySearchedMobile(String name) {
		System.out.println("name : "+name);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> eleList=driver.findElements(
				By.xpath("//div[text()='"+name+"']"));
		Assert.assertTrue(!eleList.isEmpty(), "Mobile is not searched!!!");
	}
}
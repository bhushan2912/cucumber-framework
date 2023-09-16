package org.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {
	private WebDriver driver;
	
	@FindBys(@FindBy(xpath="//table[@id='topnav']//td/a/div[1]"))
	private List<WebElement> tabs;

	public String getTasksPageTitle()
	{
		return driver.getTitle();
	}
	
	public TasksPage(WebDriver driver)	//constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public int getDashboardTabsCount()
	{
		return tabs.size();
	}
	public ArrayList<String> getDashboardTabsList()
	{
		ArrayList<String> tabNames = new ArrayList<String>();
		for(WebElement ele : tabs)	//for each loop
		{
			tabNames.add(ele.getText().trim());
		}
//		for(int i=0; i<tabs.size(); i++)	//for loop
//		{
//			tabNames.add(tabs.get(i).getText().trim());
//		}
		return tabNames;
	}
}
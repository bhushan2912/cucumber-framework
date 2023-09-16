package Utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

public class ElementUtil {
	private WebDriver driver=DriverManager.getDriver();
	
	public static ElementUtil eu = new ElementUtil();
	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Contants.small_wait);
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState").equals("complete");
	        }
	    });
		
	    /*Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });*/
	}
	public void scrollTillElementByJS(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	public void scrollVertTillEnd() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(0,document.body.scrollHeight)");
	}
	public void scrollByPageDown(WebDriver driver, int num) {
		for(int i=1; i<=num; i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	public void clickByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", ele);
	}
	public ArrayList<String> getAllTextFromDDL(WebElement ele) {
		ArrayList<String> ar = new ArrayList<String>();
		Select sel = new Select(ele);
		for(int i=0; i<sel.getOptions().size(); i++) {
			ar.add(sel.getOptions().get(i).getText());
		}
		return ar;
	}
	public List<WebElement> getAllOptionsFromDDL(WebElement ele) {
		Select sel = new Select(ele);
		return sel.getOptions();
	}
	public int getNumberOfOptionsFromDDL(WebElement ele) {
		Select sel = new Select(ele);
		return sel.getOptions().size();
	}
	public void waitForVisiblityOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, time);
		switch(type) {
			case "id": wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			break;
			case "clss": wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			break;
			case "xpath": wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			break;
			case "css": wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			break;
		}
	}
	public boolean isAlertPresent(WebDriver driver, int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,time);
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean waitForStaleElement(WebDriver driver, int time, WebElement ele) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,time);
			wt.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	public void waitForElementToBeClickable(WebElement element) {
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementDisplayed(WebElement element) {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}
	public void typeInput(WebElement element, String input) {
		waitForElementDisplayed(element);
		element.clear();
		element.sendKeys(input);
	}
	public boolean isElementExist(WebElement element) {
		waitForElementDisplayed(element);
		return element.isDisplayed();
	}
	public void updateCellValue(String path,String sheetName,int rowNum,int cellNum,String input) {
		/* Identify the path and name of excel file */
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/* Create an instance of required workbook class */
		Workbook workbook=null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet=workbook.getSheet(sheetName);
		
			Row row=sheet.getRow(rowNum);
			
			row.createCell(cellNum).setCellValue(input);
			FileOutputStream fos=null;
			try {
				fos = new FileOutputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				workbook.write(fos);
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}

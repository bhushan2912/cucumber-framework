package Base;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given browser
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path: "+projectPath);
		if (browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
			tlDriver.set(new ChromeDriver());
//			tlDriver.set(WebDriverManager.chromedriver().setup());
		} else if (browser.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.firefox.driver", projectPath+"\\drivers\\geckodriver.exe");
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else if (browser.equals("ie")) {
			tlDriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		getDriver().manage().deleteAllCookies();
//		driver.manage().addCookie(cookie);
		getDriver().manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
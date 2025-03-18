package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtilities {
	
//	WebDriver driver;             //made it as global variable.so we can access it everywhere.in the below case we make it as local variable
//String browser inside the lauchbrowser parameter
	public WebDriver launchBrowser(String browser) {
		WebDriver driver=null;  //making it as local variable
		//create object for datautilities class to use the methods 
//		DataUtilities du = new DataUtilities();
//		String browser = du.getDataFromPropertyFile("browser");

		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else {
			System.out.println("invalid browser");
		}
		return driver;
		
	}
	
	//pass the url
	public void passURL(WebDriver driver) {
		String url = new DataUtilities().getDataFromPropertyFile("url");
		driver.get(url);
	}
	
	//maximize the browser
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
    public void implicitwait(WebDriver driver,long time) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	 }
    
    public void pageLoadingWait(WebDriver driver,long time) {
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	 }
    
    public void waitUntilElementClickable(WebDriver driver,long time,By locator) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    	
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public void titleContains(WebDriver driver,long time,String title) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    	
    	wait.until(ExpectedConditions.titleContains(title));
    }
    
    public void urlContains(WebDriver driver,long time,String url) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    	
    	wait.until(ExpectedConditions.titleContains(url));
    }
    
    public void waitUntilElementVisible(WebDriver driver,long time,By locator) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void closeBrowser(WebDriver  driver) {
    	driver.quit();
    }
    public void  refreshPage(WebDriver driver) {
    	driver.navigate().refresh();
    }
}

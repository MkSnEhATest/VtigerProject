package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import objectRepository.CalenderPage;
import objectRepository.ContactPage;
import objectRepository.HomePage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;
import objectRepository.OrganizationPage;

@Listeners(ListenersClass.class)
public class BaseClass {

	public WebDriverUtilities wu;
	
	public static WebDriver sdriver;
	
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public ContactPage cp;
	public OrganizationPage op;
	public LeadsPage lep;
	public CalenderPage cap;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	//String browser inside the login
	public void login(String browser) {
		wu = new WebDriverUtilities();
		//browser given inside launch browser
		
		driver = wu.launchBrowser(browser);
		
		sdriver=driver;
		
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		cp = new ContactPage(driver);
		op = new OrganizationPage(driver);
		lep = new LeadsPage(driver);
		cap = new CalenderPage(driver);
		
		
		wu.maximizeBrowser(driver);
		wu.implicitwait(driver, 20);
		wu.pageLoadingWait(driver, 50);
		
		wu.passURL(driver);

		

		lp.enterUserName();
		lp.enterpassword();
		lp.clickLoginButton();

	}
	
	 

	@AfterMethod(alwaysRun = true)
	public void logout() {
		hp.SignOut(driver);
		wu.closeBrowser(driver);
	}
	
}

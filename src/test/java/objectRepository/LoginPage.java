package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DataUtilities;

public class LoginPage {

	DataUtilities du;
	
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement pwdTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//Intilazation
	public  LoginPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	//utilization
	public void enterUserName() {
		 du = new DataUtilities();
		 String un = du.getDataFromPropertyFile("username");
		 usernameTextField.sendKeys(un);
	}
	public void enterpassword() {
		 du = new DataUtilities();
		 String pwd = du.getDataFromPropertyFile("password");
		 pwdTextField.sendKeys(pwd);
	}
	public void clickLoginButton() {
		 loginbtn.click();
	}
}

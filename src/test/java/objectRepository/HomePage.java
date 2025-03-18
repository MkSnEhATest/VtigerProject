package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import utilities.GenericUtilities;

public class HomePage {

	@FindBy(linkText = "Calendar")
	private WebElement calenderlink;

	@FindBy(linkText = "Leads")
	private WebElement leadslink;

	@FindBy(linkText = "Organizations")
	private WebElement Organizationslink;

	@FindBy(linkText = "Contacts")
	private WebElement Contactslink;

	@FindBy(xpath = "/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")
	private WebElement adminIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void clickCalenderLink() {
		calenderlink.click();
	}

	public void clickLeadsLink() {
		leadslink.click();
	}

	public void clickOrganizationsLink() {
		Organizationslink.click();
	}

	public void clickContactsLink() {
		Contactslink.click();
	}

	
	public void SignOut(WebDriver driver) {
		GenericUtilities gu = new GenericUtilities();
		gu.MouseHoverOn(driver, adminIcon);
		signoutlink.click();
	}
}

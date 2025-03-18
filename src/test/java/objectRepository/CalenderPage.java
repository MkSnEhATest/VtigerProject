package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.Call;
import utilities.GenericUtilities;
import utilities.WebDriverUtilities;

public class CalenderPage {
  
	// declaration
	@FindBy(xpath = "//td[.='Day']")
	private WebElement Daylink;

	@FindBy(xpath = "//td[@class='calAddButton']")
	private WebElement Addlink;

	@FindBy(linkText = "Call")
	private WebElement CallLink;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement EventNameTextField;

	@FindBy(name = "description")
	private WebElement DescriptionTextfield;

	@FindBy(name = "location")
	private WebElement locationTextField;

	@FindBy(name = "date_start")
	private WebElement DateTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;

	// initiliazation
	public CalenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	public void clickOnDay() {
		Daylink.click();
	}

	public void MouseHoverOnAdd(WebDriver driver) {
		GenericUtilities gu = new GenericUtilities();
		gu.MouseHoverOn(driver, Addlink);
	}

	public void clickOnCall() {
		CallLink.click();
	}

	public void enterEventName(String eventName) {
		EventNameTextField.sendKeys(eventName);
	}

	public void enterDescription(String description) {
		DescriptionTextfield.sendKeys(description);
	}

	public void enterlocation(String location) {
		locationTextField.sendKeys(location);
	}

	public void selectDate(String yyyymmdd) {
		DateTextField.clear();
		DateTextField.sendKeys(yyyymmdd);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

}

package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class ContactPage {

	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateNewContactIcon;

	@FindBy(name = "salutationtype")
	private WebElement salutation;

	@FindBy(name = "firstname")
	private WebElement firstNameTextfield;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(name = "leadsource")
	private WebElement leadsrcDropdown;

	@FindBy(name = "title")
	private WebElement TitleTextfield;

	@FindBy(name = "department")
	private WebElement DepartmentTextfield;
	
	@FindBy(name = "email")
	private WebElement emailTextfield;

	@FindBy(id = "mobile")
	private WebElement MobileTextfield;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;

	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement CancelButton;

	// initilization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void ClickOnCreateNewContact() {
		CreateNewContactIcon.click();
	}

	public void selectSalutation(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionsByVisibleText(salutation, text);
	}

	public void enterFirstName(String text) {
		firstNameTextfield.sendKeys(text);
	}

	public void enterLastName(String text) {
		lastNameTextField.sendKeys(text);
	}

	public void LeadsrcDropdown(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionsByVisibleText(leadsrcDropdown, text);
	}

	public void enterTitle(String text) {
		TitleTextfield.sendKeys(text);
	}

	public void enterDepartment(String text) {
		DepartmentTextfield.sendKeys(text);
	}

	public void enterEmail(String email) {
		emailTextfield.sendKeys(email);
	}
	
	public void enterMobile(String number) {
		MobileTextfield.sendKeys(number);
	}

	public void clickSaveButton() {
		SaveButton.click();
	}

	public void clickCancelButton() {
		CancelButton.click();
	}

		
	

}

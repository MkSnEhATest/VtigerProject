package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class OrganizationPage {

	// declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateNewOrganizationIcon;

	@FindBy(name = "accountname")
	private WebElement OrganizationTextfield;

	@FindBy(id = "employees")
	private WebElement EmployeesTextfield;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(name = "accounttype")
	private WebElement typeDropdown;

	@FindBy(id = "phone")
	private WebElement enterPhoneNumberTextField;

	@FindBy(id = "email1")
	private WebElement enterEmailTextField;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
	private WebElement cancelButton;
	
	

	// initilization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/// utilization
	public void ClicknewOrganization() {
		CreateNewOrganizationIcon.click();
	}

	public void enterOrganizationName(String text) {
		OrganizationTextfield.sendKeys(text);
	}

	public void enterEmployees(String text) {
		EmployeesTextfield.sendKeys(text);
	}

	public void SelectIndustry(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionsByVisibleText(industryDropdown, text);
	}

	public void SelectType(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionsByVisibleText(typeDropdown, text);
	}

	public void enterPhonenumber(String number) {
		enterPhoneNumberTextField.sendKeys(number);
	}

	public void enterEmail(String text) {
		enterEmailTextField.sendKeys(text);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}
}

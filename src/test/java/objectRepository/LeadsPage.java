package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class LeadsPage {

	// declaration
		@FindBy(xpath = "//img[@title='Create Lead...']")
		private WebElement CreateNewLead;
		
		@FindBy(name="salutationtype")
		private WebElement salutationDropDown;
		

		@FindBy(name = "firstname")
		private WebElement firstNameTextfield;

		@FindBy(name = "lastname")
		private WebElement lastNameTextField;
		
		@FindBy(name="company")
		private WebElement CompanyNameTextField;
		
		@FindBy(name = "designation")
		private WebElement TitleTextfield;
		
		@FindBy(name = "leadsource")
		private WebElement leadsrcDropdown;
		
		@FindBy(name = "industry")
		private WebElement industryDropdown;
		
		@FindBy(id = "mobile")
		private WebElement MobileTextfield;
		
		@FindBy(id = "email")
		private WebElement enterEmailTextField;
		
		@FindBy(name="leadstatus")
		private WebElement leadstatusDropdown;
		
		@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
		private WebElement saveButton;

		@FindBy(xpath = "(//input[@title='Cancel [Alt+X]'])[1]")
		private WebElement cancelButton;
		
		//initiliazation
		public LeadsPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//utilization
		public void clickCreateNewLead() {
			CreateNewLead.click();
		}
		
		public void selectSalutationDropdown(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionsByVisibleText(salutationDropDown, text);
		}
		
		public void enterFirstName(String text) {
			firstNameTextfield.sendKeys(text);
		}

		public void enterLastName(String text) {
			lastNameTextField.sendKeys(text);
		}
		
		public void enterCompany(String text) {
			CompanyNameTextField.sendKeys(text);
		}
		
		public void enterTitle(String text) {
			TitleTextfield.sendKeys(text);
		}
		
		public void LeadsrcDropdown(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionsByVisibleText(leadsrcDropdown, text);
		}
		
		public void SelectIndustry(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionsByVisibleText(industryDropdown, text);
		}
		
		public void enterMobilenumber(String number) {
			MobileTextfield.sendKeys(number);
		}

		public void enterEmail(String text) {
			enterEmailTextField.sendKeys(text);
		}
		public void leadStatusDropDown(String text) {
			GenericUtilities gu = new GenericUtilities();
			gu.selectOptionsByVisibleText(leadstatusDropdown, text);
		}
		
		public void clickSaveButton() {
			saveButton.click();
		}

		public void clickCancelButton() {
			cancelButton.click();
		}
}

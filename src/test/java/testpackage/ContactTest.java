package testpackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class ContactTest extends BaseClass {

		@Test(dataProvider = "databaseContactsDetails", dataProviderClass  = DataSupply.class)
		
		 public void createContact(String Salutation,String Firstname,String lastname,
				 String Leadsrc,String title,String Department,String email,String Mobile) {
		 hp.clickContactsLink();
		 cp.ClickOnCreateNewContact();
		 cp.selectSalutation(Salutation);
		 cp.enterFirstName(Firstname);
		 cp.enterLastName(lastname);
		 cp.LeadsrcDropdown(Leadsrc);
		 cp.enterTitle(title);
		 cp.enterDepartment(Department);
		 cp.enterEmail(email);
		 cp.enterMobile(Mobile);
		 
		 cp.clickSaveButton();
		 
		
	}
		
}

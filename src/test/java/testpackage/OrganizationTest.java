package testpackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrganizationTest extends BaseClass {

	@Test
	public void createOrganization() {
		hp.clickOrganizationsLink();
		op.ClicknewOrganization();
		op.enterOrganizationName("RenaiMedicity");
		op.enterEmployees("50000");
		op.SelectIndustry("Healthcare");
		op.SelectType("Investor");
		op.enterPhonenumber("2514562031");
		op.enterEmail("renaimedicity@gmail.com");
		op.clickSaveButton();
	}
	
}

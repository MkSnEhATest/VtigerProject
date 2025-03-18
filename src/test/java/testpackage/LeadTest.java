  package testpackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class LeadTest extends BaseClass{

	@Test
	public void createlead() {
		hp.clickLeadsLink();
		lep.clickCreateNewLead();
		lep.selectSalutationDropdown("Mr.");
		lep.enterFirstName("sarath");
		lep.enterLastName("M K");
		lep.enterCompany("TCS");
		lep.enterTitle("Sales Manager");
		lep.LeadsrcDropdown("Direct Mail");
		lep.SelectIndustry("Hospitality");
		lep.enterMobilenumber("9080706050");
		lep.leadStatusDropDown("Contacted");
		lep.clickSaveButton();
	}
}

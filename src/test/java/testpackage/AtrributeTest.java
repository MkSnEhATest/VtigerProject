package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class AtrributeTest extends BaseClass {

	@Test(groups = "smoke" ,dependsOnGroups = "adhoc")
	public void moveToCalenderPage() {
		hp.clickCalenderLink();
//		System.out.println("calender page pass");
		System.out.println("smoke 1");
//		Assert.fail();
	}
	
	
	@Test(groups = "integration") 
	public void moveToLeadsPage() throws InterruptedException {
		Thread.sleep(7000);
		hp.clickLeadsLink();
//		System.out.println("Leads Page pass");
		System.out.println("integration 1");
//		Assert.fail();
	}
	
	@Test(groups = "integration")
	public void moveToOrganization() {
		hp.clickOrganizationsLink();
//		System.out.println("Organization page pass");
		System.out.println("integration 2");
	}
	
	@Test(groups = "adhoc")
	public void moveToContacts() {
		hp.clickContactsLink();
//		System.out.println("Contacts page pass");
		System.out.println("adhoc 1");
	}
	
	@Test(groups = "adhoc")
	public void moveToContacts2() {
		hp.clickContactsLink();
//		System.out.println("Contacts page pass");
		System.out.println("adhoc 3");
	}
}
//description = "Adhoc scenario" given in test annotation braces
//description = "system scenario"
//description="Integration scenario"
//groups:-->


//enabled=false is used to make it disable the test scenario
//alwaysrun is used to run a specific testcase for 
//dependsonmenthods:- dependsOnMethods = "moveToCalenderPage"

///invocationTimeOut = 10000:---

//,dependsOnGroups = "smoke"
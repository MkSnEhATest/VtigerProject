package testpackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class CalendarTest extends BaseClass{
    
	@Test
	public void createCalender() {
		hp.clickCalenderLink();
		cap.MouseHoverOnAdd(driver);
		cap.clickOnCall();
		cap.enterEventName("Interview");
		cap.enterDescription("Automation");
		cap.enterlocation("Kochi");
		cap.selectDate("2025-03-20");
		
		cap.clickSaveButton();
	}
}

package testpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.BaseClass;

public class VerificationClass extends BaseClass {

	@Test
	public void verify() {
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(true, true);
		sa.assertEquals(5, 5);
		sa.assertEquals("Athulya", "Athulya");
		
		sa.assertNotEquals(true, false);
		sa.assertNotEquals(7, 3);
		
		sa.assertNull(null);
		sa.assertNotNull("Hari");
		
//		sa.assertTrue(true);
//		sa.assertTrue(false);
		
		sa.assertAll();

	}
}

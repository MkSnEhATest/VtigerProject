package testpackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	
//	@Parameters({"browser","username","password"})
//	@Test
//	public void scenario3(String browser,String username,String password) {
//		System.out.println(browser);
//		System.out.println(username);
//		System.out.println(password);
	
//	}
	
	@Test
	
	  public void getDataFromMaven() {
		  String un = System.getProperty("username");
		  String pwd = System.getProperty("password");
		  
		  System.out.println(un);
		  System.out.println(pwd);
	  }
}

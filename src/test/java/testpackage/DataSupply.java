package testpackage;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DataUtilities;

public class DataSupply {

	@DataProvider(name="userCredentials")
	public Object[][] userData() {
		return new Object[][] {
			{"resbin@gmail.com","resbin@123"},
			{"siva@gmail.com","siva@123"},
			{"sreekanth@gmail.com","sreekanth@123"},
			{"sneha@gmail.com","sneha@123"}
		};
	}
	
	@DataProvider(name="userCredentials1")
	public Object[][] userData1() {
		return new Object[][] {
			{"sneha@gmail.com","sneha@123"},
			{"hari@gmail.com","hari@123"},
			{"helen@gmail.com","helen@123"},
			{"pious@gmail.com","pious@123"}
		};
	}
	
	@Test(dataProvider="userCredentials1",dataProviderClass =DataSupply.class)
	public void printData(String username,String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider(name="ContactDetails")
	public Object[][] contactData(){
		return new Object[][] {
			{"Mr.","Anirudhan","K","Employee","Health Inspector","Health","anirudhan@gmail.com","9988774455"},
			{"Mrs.","Molly","C R","Self Generated","Journalist","All india Radio Station","molly@gmail.com","9301224455"},
			{"Mr.","Abhinand","Raj","Partner","Student","EEE","abhinandraj@gmail.com","9900776655"},
			{"Mr.","Sarath","M K","Employee","MedicalComapny","BioMira","sarath@gmail.com","9900574655"}
	};
	}
	
	@DataProvider(name="databaseContactsDetails")
	public Object[][]databaseContacts(){
		
		DataUtilities du = new DataUtilities();
		
		ArrayList<Object[]> result = du.getDataFromDatabase("select * from contacts");
		
		return result.toArray(new Object[0][]);
		
	}
	
//	@Test(dataProvider = "databaseContactsDetails")
//	public void contactDetails(String salutation,String firstname,String lastname,String leadsrc,
//			String title,String department,String email,String mobile) {
//		
//	}              it is used for testing prupose
}

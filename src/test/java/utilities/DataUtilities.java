package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {
    //create as a global variable
	String propertyfilepath="C:\\Users\\ASUS\\eclipse-workspace\\Testing\\Vtiger\\src\\test\\resources\\datas\\vtigerdata.properties";

	String ExcelFilepath="C:\\Users\\ASUS\\eclipse-workspace\\Testing\\BrilliantTesters\\datas\\dataBook.xlsx";
	
	public void setDataIntoPropertyFile(String key, String value) {

		try {
			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyfilepath);

			// create object for properties class
			Properties p = new Properties();

			// load the file into propertyobject
			p.load(fis);

			// set data
			p.setProperty(key, value);

			// create object for fout
			FileOutputStream fout = new FileOutputStream(propertyfilepath);

			/// store data
			p.store(fout, "Data Stored Successfully");

			System.out.println("Data Stored Successfully");

		} catch (Exception e) {

			System.out.println("Unable to Store Data");
		}

	}

	public String getDataFromPropertyFile(String property) {

		String value = "";

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyfilepath);

			// create object for properties class
			Properties p = new Properties();

			// load the file into property object
			p.load(fis);

			// get property
			value = p.getProperty(property);

		} catch (Exception e) {
			System.out.println("unable to get data");
		}
		// return the property
		return value;

	}

	public void removeDataFromPropertyFile(String property) {
		try {
			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyfilepath);

			// create object for properties class
			Properties p = new Properties();

			// load the file into property object
			p.load(fis);

			// remove property
			p.remove(property);

			// create object for fout
			FileOutputStream fout = new FileOutputStream(propertyfilepath);

			// store the value
			p.store(fout, "Data removed successfully");

			// print success messgae
			System.out.println("Data removed successfully");

		} catch (Exception e) {
			System.out.println("Unable to remove Data form porperty file ");
		}
	}

	public void setDataIntoExcel(String sheet, int row, int cell, String value) {
		try {
			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(ExcelFilepath);
			
			// create workboook factory
			Workbook wb = WorkbookFactory.create(fis);
			
			// getsheet,create row,create cell,create cell value
			wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);

			// create object for fout
			FileOutputStream fout = new FileOutputStream(ExcelFilepath);

			// write inside the file
			wb.write(fout);
			
		} catch (Exception e) {
			System.out.println("unable to set data into excel");
		}
	}
	public String getDataFromExcel(String sheet,int row,int cell) {
		String value = "";
		try {
			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(ExcelFilepath);

			// create workboook factory
			Workbook wb = WorkbookFactory.create(fis);

			// getsheet,get row,get cell,get cell value
			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception e) {
			System.out.println("unable to get data from excel file");
		}
       return value;
	}
    public void setDataIntoDatabase(String query) {
		
		try {
			// fetch data form property file
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");

			/// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			Connection conn = DriverManager.getConnection(jdbcurl, jdbcun, jdbcpwd);

			// create statement and execute
			conn.createStatement().execute(query);

			// print success message
			System.out.println("query executed successfully");
			
		} catch (Exception e) {
			System.out.println("unable to execute the query");
		}
	}
	public ArrayList<Object[]> getDataFromDatabase(String query) {
		ArrayList<Object[]> al = new ArrayList<Object[]>();
		
		try {
			// fetch data form property file
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			Connection conn = DriverManager.getConnection(jdbcurl, jdbcun, jdbcpwd);

			// create statement and execute
			ResultSet rs = conn.createStatement().executeQuery(query);

			//while loop
			while (rs.next()) {
				
				int columnCount = rs.getMetaData().getColumnCount();
				String[] rowdata = new String[columnCount];
				//make a for loop
				for (int i = 1; i <= columnCount; i++) {
					rowdata[i - 1] = rs.getString(i);
				}
				al.add(rowdata);
			}

		} catch (Exception e) {
			 System.out.println("unable to get data");
		} 
		return al;
	}
}

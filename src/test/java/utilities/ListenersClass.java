package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersClass  implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase execution started");
//		test.log(LogStatus.PASS, methodName);
		
		
		test=report.startTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+" testcase Passed");
		test.log(LogStatus.PASS, methodName);
		
		report.endTest(test);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase execution failed");
		Reporter.log(result.getThrowable().toString());
	
		
		GenericUtilities gu= new GenericUtilities();
		String path="C:\\Users\\ASUS\\eclipse-workspace\\Testing\\Vtiger\\src\\test\\resources\\defectImages\\Vtiger_"+methodName+"_"+gu.currentDate()+".jpg";
//		gu.CaptureScreenshot(BaseClass.sdriver, path);
		
		test.log(LogStatus.FAIL, test.addScreenCapture(gu.CaptureScreenshot(BaseClass.sdriver, path)));
		
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase execution skipped");
		Reporter.log(result.getThrowable().toString());
		
		test.log(LogStatus.SKIP, methodName+" skipped");
		
		report.endTest(test);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("--------Execution started-------");
		report= new ExtentReports("./reports/extentReport_Vtiger.html");
		
		report.addSystemInfo("OS","Windows 11");
		report.addSystemInfo("browser","Edge");
		report.addSystemInfo("User Name","Sneha");
		report.addSystemInfo("Project Name","Vtiger");
		report.addSystemInfo("BaseUrl","http://localhost:8888/");
		report.addSystemInfo("username","admin");
		report.addSystemInfo("password","admin");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("--------Execution finished-------");
		
		report.flush();
	}
         
}

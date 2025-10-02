package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportsManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName; // To get different reports. otherwise each time the reports override

	public void onStart(ITestContext testContext) {
		
//To generate time stamp to get different reports
	
	String timeStamp = new SimpleDateFormat("yyyy.mm.dd.mm.ss").format(new Date());	
	repName = "Test-Report-" + timeStamp + ".html";
	sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); //Specify location. //either this or System.getProperty("user.dir")
	
	sparkReporter.config().setDocumentTitle("Opencart Automation Report"); //title of report
	sparkReporter.config().setReportName("opencart Functional Testing"); //name of the report
	sparkReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter); //attach the common info
	extent.setSystemInfo("Application", "Tutorials Ninja");
	extent.setSystemInfo("Module", "Login");
	extent.setSystemInfo("Sub Module", "LoginPage");
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	extent.setSystemInfo("Environment", "QA");
	
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report.
		test.log(Status.PASS, result.getName() + "Got Successfully Excecuted" );
		}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName() + "Got Failed! ");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage()); //To get the reason why its skipped.
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);
		
		try { //To get the report folder open automatically.
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

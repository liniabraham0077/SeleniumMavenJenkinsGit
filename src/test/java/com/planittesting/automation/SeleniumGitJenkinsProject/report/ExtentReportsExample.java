/*package com.planittesting.automation.SeleniumGitJenkinsProject.report;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsExample {

	ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;

	@BeforeTest
	public void testSetUp() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "AutomationReport.html");
		ClassLoader classLoader = getClass().getClassLoader();

		htmlReporter.loadXMLConfig(new File(classLoader.getResource("extent-config.xml").getFile()));

		// htmlReporter.loadXMLConfig(new
		// File(System.getProperty("user.dir")+"extent-config.xml"));

		reports = new ExtentReports();

		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);

	}
	
	@BeforeMethod
	//reflection can get runtime info
	public void register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
		
	}
	
	@AfterMethod
	public void captureStatus(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "The test method "+result.getName() + " is pass");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, "The test method "+result.getThrowable() + " is failed");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.FAIL, "The test method "+result.getName() + " is passed");
		}
	}
	
	@AfterTest()
	public void teardown() {
		reports.flush();
	}
}

*/

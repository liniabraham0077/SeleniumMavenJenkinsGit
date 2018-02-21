package com.planittesting.automation.SeleniumGitJenkinsProject.tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class BaseTestSuite {

	protected static WebDriver driver;
	ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;

	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void testSetUp() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/AutomationReport.html");
		ClassLoader classLoader = getClass().getClassLoader();

		htmlReporter.loadXMLConfig(new File(classLoader.getResource("extent-config.xml").getFile()));

		// htmlReporter.loadXMLConfig(new
		// File(System.getProperty("user.dir")+"extent-config.xml"));

		reports = new ExtentReports();

		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);

	}

	@BeforeMethod
	public void testSteup(Method method) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/");

		String testName = method.getName();
		testInfo = reports.createTest(testName);
	}

	@AfterMethod
	public void captureStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "The test method " + result.getName() + " is pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, "The test method " + result.getThrowable() + " is failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.FAIL, "The test method " + result.getName() + " is passed");
		}
	}

	@AfterTest()
	public void cleanUp() {
		reports.flush();
	}

	@AfterClass
	public static void tearDown() {

		driver.quit();

	}

}

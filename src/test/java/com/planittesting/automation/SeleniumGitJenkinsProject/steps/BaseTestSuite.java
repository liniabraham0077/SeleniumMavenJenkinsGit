package com.planittesting.automation.SeleniumGitJenkinsProject.steps;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.Before;

public abstract class BaseTestSuite {

	protected static WebDriver driver;
	ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;

	@Parameters(value={"browser","version","platform"})
	@BeforeClass
	public static void setup(String browser, String version, String platform) throws MalformedURLException {
		if (browser.equals("chrome")) {
			
			driver = new ChromeDriver();
		}

//			DesiredCapabilities capability = new DesiredCapabilities();
//			capability.setCapability("platform", platform);
//			capability.setCapability("browserName", browser);
//			capability.setCapability("browserVersion", version);
//			capability.setCapability("project", "P1");
//			capability.setCapability("build", "1.0");
//
//			driver = new RemoteWebDriver(new URL("http://192.168.56.1:4548/wd/hub"), capability);
		}
//		else if (browser.equals("firefox")) {
//
//			DesiredCapabilities capability = new DesiredCapabilities();
//			capability.setCapability("platform", platform);
//			capability.setCapability("browserName", browser);
//			capability.setCapability("browserVersion", version);
//			capability.setCapability("project", "P1");
//			capability.setCapability("build", "1.0");
//			capability.setCapability("marionette", true);
//
//			driver = new RemoteWebDriver(new URL("http://192.168.56.1:4549/wd/hub"), capability);
//		}
//
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//	}

	@Before
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

package com.planittesting.automation.SeleniumGitJenkinsProject.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestSuite {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void testSteup() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
		
	}
	

}

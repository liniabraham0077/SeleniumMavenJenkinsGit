package com.planittesting.automation.SeleniumGitJenkinsProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public LoginPage setUsername(String userName) {
		
		driver.findElement(By.id("email")).sendKeys(userName);
		return this;
		
	}
	
	public LoginPage setPassword(String password) {
		
		driver.findElement(By.id("passwd")).sendKeys(password);
		return this;
		
	}
	
	public MyAccountPage clickSubmitButton() {
		driver.findElement(By.className("btn-default")).click();
		return new MyAccountPage(driver);
	}
}

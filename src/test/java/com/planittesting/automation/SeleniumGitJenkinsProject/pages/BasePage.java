package com.planittesting.automation.SeleniumGitJenkinsProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}


	public LoginPage clickSignInButton() {
		driver.findElement(By.className("login")).click();
		return new LoginPage(driver);
	}

	public String getTitle() {
		System.out.println("actual title is " + driver.getTitle());
		return driver.getTitle();
	}

}

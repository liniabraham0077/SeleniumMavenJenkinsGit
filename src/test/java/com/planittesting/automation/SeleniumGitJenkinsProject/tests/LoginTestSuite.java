package com.planittesting.automation.SeleniumGitJenkinsProject.tests;

import org.testng.annotations.Test;

import com.planittesting.automation.SeleniumGitJenkinsProject.pages.HomePage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.LoginPage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.MyAccountPage;

public class LoginTestSuite extends BaseTestSuite {

	@Test
	public void signInSuccessful() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage=homePage.clickSignInButton();

		loginPage.setUsername("leaabraham007@gmail.com").setPassword("abc123");
		MyAccountPage myAccountPage = loginPage.clickSubmitButton();
		String actualTitle = myAccountPage.getTitle();
		//String expectedPageTitle = "";
		//myAccountPage.verifyTitle("");

	}

}

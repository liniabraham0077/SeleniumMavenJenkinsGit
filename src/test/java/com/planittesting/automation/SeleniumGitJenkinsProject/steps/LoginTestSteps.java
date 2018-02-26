package com.planittesting.automation.SeleniumGitJenkinsProject.steps;

import org.testng.Assert;

import com.planittesting.automation.SeleniumGitJenkinsProject.pages.HomePage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.LoginPage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.MyAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps extends BaseTestSuite {
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@Given("^I am on the login page$")
	public void userOnLoginPage() {

		loginPage = homePage.clickSignInButton();

	}

	@When("^I enter <username> and <password>$")
	public void enterUserNameandPassword() {
		loginPage.setUsername("leaabraham007@gmail.com").setPassword("abc123");
		myAccountPage = loginPage.clickSubmitButton();
	}

	@Then("^I should be logged in if the credentials are correct$")
	public void successfulOrUnsuccessfulLogin() {
		String actualTitle = myAccountPage.getTitle();
		String expectedPageTitle = "Search - My Store";
		Assert.assertEquals(expectedPageTitle, myAccountPage.getTitle());

	}
}

package com.planittesting.automation.SeleniumGitJenkinsProject.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.planittesting.automation.SeleniumGitJenkinsProject.pages.HomePage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.LoginPage;
import com.planittesting.automation.SeleniumGitJenkinsProject.pages.MyAccountPage;

public class LoginTestSuite extends BaseTestSuite {

	@Test
	public void signInSuccessful() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
	

		loginPage.setUsername("leaabraham007@gmail.com").setPassword("abc123");
		MyAccountPage myAccountPage = loginPage.clickSubmitButton();
		String actualTitle = myAccountPage.getTitle();
		String expectedPageTitle = "Search - My Store";
		Assert.assertEquals(expectedPageTitle, myAccountPage.getTitle());

	}
	
	@Test
	public void signInFailure() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();

		loginPage.setUsername("leaabraham007@gmail.com").setPassword("ggjj");
		loginPage.clickSubmitButton();
		Thread.sleep(2000);
		Assert.assertEquals("true",loginPage.getLoginAuthenticationError());

	}
	
	@Test(dataProvider = "getData")
	public void setData(String userName,String password)
	{
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0] ="a1";
		data[0][1] ="b1";
		
		data[1][0] ="a1";
		data[1][1] ="b1";
		
		data[2][0] ="a1";
		data[2][1] ="b1";
		
		
		return data;
	}

}

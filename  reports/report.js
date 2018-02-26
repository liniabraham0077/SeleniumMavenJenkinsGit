$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleFeature.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "As a user\r\nI want to be able to add new clients in the system\r\nSo that i can add accounting data for that client",
  "id": "",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Sign up a new user",
  "description": "",
  "id": ";sign-up-a-new-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I am on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTestSteps.userOnLoginPage()"
});
formatter.result({
  "duration": 154090449,
  "error_message": "java.lang.NullPointerException\r\n\tat com.planittesting.automation.SeleniumGitJenkinsProject.pages.BasePage.clickSignInButton(BasePage.java:16)\r\n\tat com.planittesting.automation.SeleniumGitJenkinsProject.steps.LoginTestSteps.userOnLoginPage(LoginTestSteps.java:21)\r\n\tat ✽.Given I am on the login page(SampleFeature.feature:8)\r\n",
  "status": "failed"
});
});
package com.planittesting.automation.SeleniumGitJenkinsProject.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features/",
glue="com.planittesting.automation.SeleniumGitJenkinsProject.steps",
format={"html: reports"})
public class RunCukeTests extends AbstractTestNGCucumberTests{
	
	

}

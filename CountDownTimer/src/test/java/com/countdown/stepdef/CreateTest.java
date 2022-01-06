package com.countdown.stepdef;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.countdown.report.ExtentReport;

public class CreateTest 
{
	String testName = null;
	
	CreateTest(String testName)
	{
		
	}
	
	@BeforeTest
	public void createTest()
	{
		ExtentReport.createTest(testName);
	}
	
	
	@AfterTest
	public void endTest()
	{
		ExtentReport.endTest();
	}

}

package com.countdown.stepdef;

import com.countdown.report.ExtentReport;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/***
 * 
 * @author Avinash
 *Class which executes before and after hook for each scenario.
 */
public class TestHooks 
{
	ExtentTest test = null;
	/***
	 * Create & add the test in Extent Report file
	 * @param testName Specify the Test name
	 * @return Test Object
	 */
	@Before
	public ExtentTest beforeScenario(Scenario sc)
	{
		test = ExtentReport.createTest(sc.getName());
		return test;
	}
	
	/***
	 * End the Test
	 */
	@After
	public void afterScenario(Scenario sc)
	{
		try
		{
			if(sc.isFailed())
				test.log(LogStatus.FAIL, "Test gets Failed!!");
			else
				test.log(LogStatus.PASS, "Test Passed!!");
			
			
			ExtentReport.endTest();
		}
		catch(Exception e)
		{
			
		}
	}

}

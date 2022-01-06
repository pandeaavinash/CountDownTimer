package com.countdown.listeners;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.LogStatus;

public class ReportListener// implements IReporter 
{/*

	 (non-Javadoc)
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List, java.lang.String)
	 
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
	{
		//Initialize the report file
		ExtentReport.createReport();
		
		for (ISuite iSuite : suites) 
		{
			System.out.println("Suite Name: "+iSuite.getName());
			Map<String, ISuiteResult> resultsMap = iSuite.getResults();
			Set<Entry<String, ISuiteResult>> resultSets = resultsMap.entrySet();
			for (Entry<String, ISuiteResult> resultSet : resultSets) 
			{
				ISuiteResult resultValue = resultSet.getValue();
				ITestContext testContext = resultValue.getTestContext();
				
				IResultMap allPassedTestMethods = testContext.getPassedTests();
				Set<ITestResult> allResults = allPassedTestMethods.getAllResults();
				for (ITestResult iTestResult : allResults) {
					System.out.println("Passed Tests:  ");
					
					ExtentReport.createTest(iTestResult.getName());
					
					ExtentReport.test.log(LogStatus.PASS, "");
					
					ExtentReport.endTest();
				}
				
				//Failed Test Methods
				IResultMap allFailedTestMethods = testContext.getFailedTests();
				Set<ITestResult> allFailedResults = allFailedTestMethods.getAllResults();
				for (ITestResult iTestResult : allFailedResults) {
					System.out.println("Failed Tests:  ");
					
					ExtentReport.createTest(iTestResult.getName());
					
					//ExtentReport.test.log(LogStatus.FAIL, iTestResult.getAttribute("description").toString());
					
					ExtentReport.endTest();
				}
				
				//Skipped Test Method
				IResultMap allSkippedTestMethods = testContext.getFailedTests();
				Set<ITestResult> allSkippedResults = allSkippedTestMethods.getAllResults();
				for (ITestResult iTestResult : allSkippedResults) 
				{
					System.out.println("Skipped Tests:  ");
					
					ExtentReport.createTest(iTestResult.getName());
					
					//ExtentReport.test.log(LogStatus.SKIP, iTestResult.getAttribute("description").toString());
					
					ExtentReport.endTest();
				}
			}//Suite
			
		}
			
		
		//Close the report File
		ExtentReport.endReport();
		
		//Wait for 5-seconds to create & save the report file.
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File f = new File(ExtentReport.reportFullPath);
		if(f.exists())
			System.out.println("File exists");
		EmailUtils.sendEmail(LoadProperties.EMAIL_EMAILTOSEND, "", ExtentReport.reportFullPath);
	}

	
*/
}

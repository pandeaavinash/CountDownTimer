package com.countdown.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport 
{	
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	public static String reportName = null; 
	public static String reportPath = null;
	public static String reportFullPath = null;
	

	/***
	 * Will create a extent Report
	 * @return Physical Report object
	 */
	public static ExtentReports createReport()
	{
		if(report == null)
		{
			reportPath = ".\\test-output\\Report_";
			System.out.println("In Create Report Method!!");
			
			reportFullPath = reportPath+getDateTime()+".html";
			report = new ExtentReports(reportFullPath, false, DisplayOrder.OLDEST_FIRST);
			report.config().reportHeadline("Headline");
			report.config().reportName("ReportName");
			report.config().documentTitle("DocumentTitle");
		}
		return report;
	}
	
	/***
	 * Create/Add a test in report file.
	 * @param testName TestCase Name
	 * @return Return TestCase Object
	 */
	public static ExtentTest createTest(String testName)
	{
		if(test == null)
		{
			test= report.startTest(testName);
		}
		return test;
	}
	
	/***
	 * End the test and add it in Report file
	 */
	public static void endTest()
	{
		if(test != null)
		{
			report.endTest(test);
			if(test != null)
				test=null;
		}
		
	}
	
	/***
	 * Close the report 
	 */
	public static void endReport()
	{
		if(report != null)
		{
			report.flush();
			report.close();
			report=null;
		}
	}
	
	public static String getDateTime()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dtm = format.format(new Date());
		dtm = dtm.replace('-', '_');
		dtm = dtm.replace(':', '_');
		dtm = dtm.replace(' ', '_');
		reportName = "Avinash_"+dtm;
		return reportName ;
	}


}

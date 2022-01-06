package com.countdown.listeners;

import java.io.File;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.countdown.confighandler.LoadProperties;
import com.countdown.email.EmailUtils;
import com.countdown.report.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;

public class SuiteListener  implements ISuiteListener
{

	//public static ExtentReports reports = null;
	//public static ExtentReport report = null;

	
	/***
	 * @Override
	 * Start the execution of suite also simultaneously Initialize the report file
	 */
	public void onStart(ISuite suite) 
	{
		System.out.println("\n\n\nSuite Start to execute................. !!");
		File file = new File(suite.getOutputDirectory());
		
		LoadProperties.OUTPUTFOLDER = file.getParent();
		ExtentReport.createReport();
	}

	
	/***
	 * @Override
	 * End the execution of suite and simultaneously close the report file
	 */
	public void onFinish(ISuite suite) 
	{		
		ExtentReport.endReport();
		
		//Attach report file and send an email to specified email addresses.
		EmailUtils.sendEmail(LoadProperties.EMAIL_EMAILFROM, LoadProperties.EMAIL_EMAILTOSEND, ExtentReport.reportFullPath);
		System.out.println("\n\n\nSuite Execution Finished.............. !!");
	}

	


}

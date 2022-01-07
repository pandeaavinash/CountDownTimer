package com.countdown.utility;

import org.openqa.selenium.WebDriver;

import com.countdown.driver.Browser;
import com.countdown.report.ExtentReport;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTestClass extends Browser
{
	private ExtentTest test = null;
	private WebDriver driver = null;
	/***
	 * Set and get the browser instance
	 * @param browserName Name of browser e.g. ff or firefox
	 * @return webdriver instance
	 */
	public WebDriver getBrowser(String browserName)
	{
		this.setBrowser(browserName);
		driver = this.getDriver();
		return driver;
	}

	/***
	 * Close all the opened browser instance
	 */
	public void closeBrowser()
	{
		if(driver != null)
		{
			driver.quit();
			this.removeDriver();
			driver = null;
		}
	}
	
	
	
}

package com.countdown.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.countdown.confighandler.LoadProperties;
import com.countdown.utility.FindLocators;
import com.countdown.utility.GenericWait;
import com.countdown.utility.GetLocator;

public class CountDownHomePage 
{
	private WebDriver driver = null;
	private ArrayList<String> locator = new ArrayList<>();
	private WebElement element = null;
	
	public CountDownHomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	/***
	 * Enter a time for count down
	 * @param time time in unit
	 */
	public void enterATime(Integer time)
	{
		try
		{
			locator = GetLocator.splitLocator(LoadProperties.ENTERATIME_TXT);
			if(locator.size() > 1 )
			{
				element = GenericWait.waitForAnELement(driver, locator.get(0), locator.get(1));
				if(element != null)
					element.sendKeys(time.toString());
			}
			locator.clear();
		}
		catch(Exception e)
		{
			
		}
	}

	/***
	 * Click on the Start button to start the count down timer
	 */
	public void clickStart()
	{
		try
		{
			locator = GetLocator.splitLocator(LoadProperties.START_BTN);
			if(locator.size() > 1)
			{
				element = GenericWait.waitForAnELement(driver, locator.get(0), locator.get(1));
				if(element != null)
					element.click();
			}
			locator.clear();
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	/***
	 * Select the 5-min link
	 */
	public void select_5MinutesLink()
	{
		try
		{
			locator = GetLocator.splitLocator(LoadProperties.MIN_5_LNK);
			if(locator.size() > 1 )
			{
				element = GenericWait.waitForAnELement(driver, locator.get(0), locator.get(1));
				if(element != null)
					element.click();
			}
			locator.clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occur while clicking on 5-min link.  Exception:"+e.getMessage());
		}
	}
}

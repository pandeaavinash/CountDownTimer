package com.countdown.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.countdown.confighandler.LoadProperties;
import com.countdown.utility.GenericWait;
import com.countdown.utility.GetLocator;

public class CountDownTimerPage 
{
	private WebDriver driver = null;
	private ArrayList<String> locator = new ArrayList<>();
	private LinkedHashSet<Integer> lhs = new  LinkedHashSet<>();
	private WebElement element = null;
	
	public CountDownTimerPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	/***
	 * Enter a time for count down
	 * @param time time in unit
	 */
	public void VerifyCountDownTimer(Integer time)
	{
		try
		{
			locator = GetLocator.splitLocator(LoadProperties.COUNTDOWNTIME_LBL);
			System.out.println("Locator:"+LoadProperties.COUNTDOWNTIME_LBL);
			if(locator.size() > 1)
			{
				element = GenericWait.waitForAnELement(driver, locator.get(0), locator.get(1));
				if(element != null)
					verifyCountDownTime(element, time);
			}
			locator.clear();
		}
		catch(Exception e)
		{
			
		}
	}
	
	/***
	 * Poll every 500 micro seconds and get the time value stored in linked hash set
	 * @param element webElement
	 * @param time count down time
	 */
	private void verifyCountDownTime(WebElement element, int time)
	{		
		for(int i=0; i<(time*2); i++) 
		  {
			  try
			  {
				  System.out.println(driver.getTitle());
				  String text = element.getText();
				  System.out.println(text);
				  text = text.replaceAll("seconds", "").replaceAll("second", "");
				  Thread.sleep(500);
				  if(!text.equalsIgnoreCase("Time Expired!"))
					  lhs.add(Integer.parseInt(text.trim()));
				  System.out.println("Text:"+text);
				  
			  }
			  catch(Exception e)
			  {
				  //System.out.println(lhs);
			  }
		  }
		
		if(lhs.contains(time))
			Assert.assertEquals(lhs.size(), time+1);
		else
			Assert.assertEquals(lhs.size(), time);
		
		//Verify the difference between current and next time unit should be 1-sec
		ArrayList<Integer> al = new ArrayList<>(lhs);
		  System.out.println(al);
		  for (int j=0; j<lhs.size(); j++) {
			if((j+1)< lhs.size())
			{
				System.out.println("j:"+al.get(j)+"     j+1:"+al.get(j+1));
				assertEquals(al.get(j)-al.get(j+1), 1);
			}
		}
		 
	}

}

package com.countdown.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.countdown.confighandler.LoadProperties;
import com.countdown.utility.FindLocators;
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
	public void VerifyCountDownTimer(Integer time, String timeUnit)
	{
		try
		{
			locator = GetLocator.splitLocator(LoadProperties.COUNTDOWNTIME_LBL);
			System.out.println("Locator:"+LoadProperties.COUNTDOWNTIME_LBL);
			if(locator.size() > 1)
			{
				element = GenericWait.waitForAnELement(driver, locator.get(0), locator.get(1));
				if(element != null) 
				{
					if(timeUnit.equalsIgnoreCase("seconds"))
					{
						verifyCountDownTime_Seconds(element, time);
					}
					else if(timeUnit.equalsIgnoreCase("minutes"))
					{
						verifyCountDownTime_Minutes(time);
					}
					
				}
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
	private void verifyCountDownTime_Seconds(WebElement element, int time)
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
	
	private void verifyCountDownTime_Minutes(int timeInMinute)
	{
		
		HashMap<Integer, LinkedHashSet<Integer>> minutes_SecondsMap = getMinutes_SecondsMap(timeInMinute);
		 for (Entry<Integer, LinkedHashSet<Integer>> en : minutes_SecondsMap.entrySet()) {
			 System.out.println("Key: "+en.getKey()+"      values:"+en.getValue());
			
		}
	}
	
	
	private HashMap<Integer, LinkedHashSet<Integer>> getMinutes_SecondsMap(int timeInMinute)
	{
		locator = GetLocator.splitLocator(LoadProperties.COUNTDOWNTIME_LBL);
		final By locators = FindLocators.getLocators(locator.get(0), locator.get(1));
		List<WebElement> ele = driver.findElements(locators);
		
		LinkedHashSet<Integer> secondList = new LinkedHashSet<>();
		LinkedHashSet<Integer> final_SenondsResult = null;
		HashMap<Integer, LinkedHashSet<Integer>> map_Minutes_Seconds = new HashMap<>();
		
		int minutes = timeInMinute-1; //As the counter starts from 4-minutes with 59-seconds if we select 5-minutes
		 
		for(int i=0;i<((60*timeInMinute)*2) ; i++) //Iterate for 60 seconds*5-minutes * double of it. Just to have pooling frequencytimeInMinute
		{

			try
			{
				 //List<WebElement> ele = driver.findElements(By.xpath("//main[@class='EggTimer-timer']//p//span"));
				 String text = "";
				 if(ele.size()==1)
				 {
					 text = ele.get(0).getText().trim();
					 text = text.replaceAll("seconds", "").trim().replaceAll("second", "").trim().replaceAll("minutes", "").trim().replaceAll("minute", "").trim();
					 if(!text.contains("Time Expired!") ) {
						 secondList.add(Integer.parseInt(text));
						 text="";						 
					 } 
					 else
						 break;
				 }
				 else
				 {
					 text = ele.get(0).getText().trim();
					 text = text.replaceAll("seconds", "").trim().replaceAll("second", "").trim().replaceAll("minutes", "").trim().replaceAll("minute", "").trim();
					 
					 if(minutes==(Integer.parseInt(text)))
					 {
						 text="";
						 text += ele.get(1).getText().replaceAll("seconds", "").trim().replaceAll("second", "").trim().replaceAll("minutes", "").trim().replaceAll("minute", "").trim();
						 text = text.replaceAll("seconds", "").trim().replaceAll("second", "").trim().replaceAll("minutes", "").trim().replaceAll("minute", "").trim();
						 int no = Integer.parseInt(text);
						 System.out.println("Adding in second List: "+no);
						 secondList.add(no);
						 text="";
					 }
					 else
					 {
						 final_SenondsResult = new LinkedHashSet<>();
						 minutes = minutes-1;
						 for (Integer integer : secondList) {
							 final_SenondsResult.add(integer);
						}
						 map_Minutes_Seconds.put(minutes, final_SenondsResult);			
						 System.out.println("Minute: "+minutes+"      Seconds: "+final_SenondsResult);
						 secondList.clear();
						 
						 text="";
					 }
				 }
				 
				 Thread.sleep(500);
				 text="";
			}
			catch(Exception e)
			{
				
			}		 
		}
		// Add the final seconds considering as 0-minutes
		final_SenondsResult = new LinkedHashSet<>();
		 minutes = minutes-1;
		 for (Integer integer : secondList) {
			 final_SenondsResult.add(integer);
		}
		 map_Minutes_Seconds.put(minutes, final_SenondsResult);
		 
		 return map_Minutes_Seconds;
	}

}

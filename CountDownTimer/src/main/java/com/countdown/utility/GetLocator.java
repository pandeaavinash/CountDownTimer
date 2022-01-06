package com.countdown.utility;

import java.util.ArrayList;

public class GetLocator 
{
	private static ArrayList<String> locatorName_Value = new ArrayList<>();
	
	/***
	 * Split the locator by pipe "|" and stored in ArrayList
	 * @param locatorFromLoadPropertiesClass Locator with property & property value e.g. xpath|//a[@href='abc']
	 * @return list with 0th position=locator name 1st=Locator value
	 */
	public static ArrayList<String> splitLocator(String locatorFromLoadPropertiesClass)
	{
		String[] split = locatorFromLoadPropertiesClass.split("\\|");
		if(split.length>=1)
		{
			locatorName_Value.add(split[0]);
			locatorName_Value.add(split[1]);
		}
		return locatorName_Value;
	}

}

package com.countdown.utility;

import org.openqa.selenium.By;

public class FindLocators 
{
	private static By by = null;
		
	public static By getLocators(String property, String propertyValue)
	{
		switch(property.toLowerCase())
		{
			case "id":
			{
				by = By.id(propertyValue);
				break;
			}
			case "name":
			{
				by = By.name(propertyValue);
				break;
			}
			case "classname":
			{
				by = By.className(propertyValue);
				break;
			}
			case "tagname":
			{
				by = By.tagName(propertyValue);
				break;
			}
			case "partiallinktext":
			{
				by = By.partialLinkText(propertyValue);
				break;
			}
			case "linktext":
			{
				by = By.linkText(propertyValue);
				break;
			}
			case "css":
			case "cssselector":
			{
				by = By.cssSelector(propertyValue);
				break;
			}
			case "xpath":
			{
				by = By.xpath(propertyValue);
				break;
			}
		}
		return by;
	}
		

}

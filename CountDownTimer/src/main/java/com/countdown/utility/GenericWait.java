package com.countdown.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class GenericWait 
{
   private static WebDriverWait driver = null;
	
	
	public static WebElement waitForAnELement(WebDriver driver, String property, String propertyValue)
	{
		final By locators = FindLocators.getLocators(property, propertyValue);
		WebElement element = null;
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		element = wait.until(new Function<WebDriver, WebElement>() {
			int i=0;
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locators); 
				//System.out.println("Second:"+i+"        "+element.getAttribute("name"));
				return element;
				
			}
		});
		return element;
	}

}

package com.countdown.confighandler;

import java.util.Properties;

import com.countdown.confighandler.*;

public class LoadProperties {public static Properties prop = null;
//Home page
public static final String ENTERATIME_TXT = getProperty("enteratime_txt"); 
public static final String START_BTN = getProperty("start_btn");
public static final String MIN_5_LNK = getProperty("5min_link");
public static final String MIN_10_LNK = getProperty("10min_lnk");

//CountDown Page
public static final String COUNTDOWNTIME_LBL = getProperty("min_sec_lbl");
public static final String LOGIN_PASSWORDTXT = getProperty("login_passwordtxt");		

//Forgtten Password
public static final String FORGOTTEN_MOBILENOTXT = getProperty("forgotten_mobilenumbertxt");

//Reporting
public static final String REPORTFILENAME = getProperty("reportfilename");
public static final String REPORTHEADLINE = getProperty("headline");
public static final String REPORTNAME = getProperty("reportname");
public static final String REPORTDOCUMENTITLE = getProperty("documenttitle");
public static String OUTPUTFOLDER = null;

//Email
public static final String EMAIL_EMAILTOSEND = getProperty("emailtosend");
public static final String EMAIL_EMAILFROM = getProperty("emailfrom");
public static final String EMAIL_EMAILCC = getProperty("emailcc");

//Env
public static final String BASEURL = getProperty("baseurl"); 


/***
 * Get the specified propery value form listed config files
 * @param propertyName Property Name as a key
 * @return Returns property value from config file
 */
public static String getProperty(String propertyName)
{
	String value = null;
	try
	{
		if(prop == null)
		{
			prop = new Properties();
			prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./com/countdown/resources/EnvConfig.properties"));
			prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./com/countdown/resources/ReportConfig.properties"));
			prop.load(LoadProperties.class.getClassLoader().getResourceAsStream("./com/countdown/resources/LocatorConfig.properties"));
		}
			if(prop.getProperty(propertyName) != null) 
			{
				value =  prop.getProperty(propertyName);
				System.out.println("Property:"+propertyName+"    propertyValue:"+value);
			}
			else
				System.out.println("Property: "+propertyName+"     "+"Value is null !!");
		
		
	}
	catch(Exception e)
	{
		System.out.println("Exception occurred while reading properties files !!!");
	}
	return value;
}

/*
public static void main(String[] args)
{
	System.out.println(LoadProperties.ENTERATIME_TXT);
	System.out.println(LoadProperties.START_BTN);
}*/
}
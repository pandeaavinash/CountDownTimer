package com.countdown.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.countdown.confighandler.LoadProperties;
import com.countdown.pages.CountDownHomePage;
import com.countdown.pages.CountDownTimerPage;
import com.countdown.report.ExtentReport;
import com.countdown.utility.BaseTestClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CounDownTimer_MinutesStepdef extends BaseTestClass
{	
	WebDriver driver = null;
	CountDownHomePage obj_CountDownHomePage = null;
	CountDownTimerPage obj_CountDownTimerPage = null;
	ExtentTest test = ExtentReport.test;
	private int time = 0;
	
	@Given("Navigate to the site https:\\\\e.ggtimer url")
	public void navigate_to_the_site_https_e_ggtimer_url() {
	    
		driver = this.getBrowser("ff");
		
		obj_CountDownHomePage = new CountDownHomePage(driver);
		driver.get(LoadProperties.BASEURL);
		
		test.log(LogStatus.PASS, "Navigate to URL:"+LoadProperties.BASEURL);
	}
	@Given("wait till Home page of e.ggtimer gets load")
	public void wait_till_home_page_of_e_ggtimer_gets_load() {
	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		test.log(LogStatus.PASS, "Wait till page gets Loaded");
	}
	   
	@When("select <{int}> -minutes link")
	public void select_minutes_link(Integer minutes) {
		
		this.time = minutes;
		obj_CountDownHomePage.select_5MinutesLink();
		test.log(LogStatus.PASS, "select "+time+" -minutes link");
	   
	}
	@Then("Count Down Timer should gets starts and it should decrement by {int}-sec")
	public void count_down_timer_should_gets_starts_and_it_should_decrement_by_sec(Integer int1) {
	    
		obj_CountDownTimerPage = new CountDownTimerPage(driver);
	    obj_CountDownTimerPage.VerifyCountDownTimer(time,"minutes");
	    
	    test.log(LogStatus.PASS, "Verified count down timer decrements by 1");
	}
	
	@Then("close the page and application")
	public void close_the_page_and_application() {
	    
		this.closeBrowser();
		this.removeDriver();
		
		test.log(LogStatus.PASS, "Close the browser");
	}

}

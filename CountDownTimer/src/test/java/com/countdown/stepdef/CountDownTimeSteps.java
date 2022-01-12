package com.countdown.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.countdown.confighandler.LoadProperties;
import com.countdown.driver.Browser;
import com.countdown.pages.CountDownHomePage;
import com.countdown.pages.CountDownTimerPage;
import com.countdown.report.ExtentReport;
import com.countdown.utility.BaseTestClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CountDownTimeSteps extends BaseTestClass
{	
	WebDriver driver = null;
	CountDownHomePage obj_CountDownHomePage = null;
	CountDownTimerPage obj_CountDownTimerPage = null;
	ExtentTest test = ExtentReport.test;
	private int time = 0;
	
	
	@Given("Navigate to eggtimer url")
	public void navigate_to_e_ggtimer_url() {
		driver = this.getBrowser("ff");
		
		obj_CountDownHomePage = new CountDownHomePage(driver);
		driver.get(LoadProperties.BASEURL);
		test.log(LogStatus.PASS, "Navigate to URL:"+LoadProperties.BASEURL);
	}
	
	
	@Given("wait till page gets load")
	public void wait_till_page_gets_load() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Wait till page gets Loaded");
	}
	
	
	@When("user enter the time as {int} seconds in given text box")
	public void user_enter_the_time_as_seconds_in_given_text_box(Integer time) {
		this.time = time;
		obj_CountDownHomePage.enterATime(time);
		test.log(LogStatus.PASS, "Enter time as "+time+" -sec");
	}
	
	
	@When("click on the start timer button")
	public void click_on_the_start_timer_button() {
		obj_CountDownHomePage.clickStart();
		test.log(LogStatus.PASS, "Clicked on start Button");
	}
	
	
	@Then("Count Timer should gets starts and it should decrement by {int}-sec")
	public void count_timer_should_gets_starts_and_it_should_decrement_by_sec(Integer ti) {
		obj_CountDownTimerPage = new CountDownTimerPage(driver);
	    obj_CountDownTimerPage.VerifyCountDownTimer(time, "seconds");
	    test.log(LogStatus.PASS, "Verified count down timer decrements by 1");
	}
	
	//Simple Parameter
	@When("user enter the time <{int}> seconds in given text box")
	public void user_enter_the_time_seconds_in_given_text_box(Integer time) {
		this.time = time;
		obj_CountDownHomePage.enterATime(time);
		test.log(LogStatus.PASS, "Enter time as "+time+" sec");
	}
	
	
	@When("user enter the time {string} seconds in given text box")
	public void user_enter_the_time_seconds_in_given_text_box(String time) {
		System.out.println(time);
		this.time = Integer.parseInt(time);
		obj_CountDownHomePage.enterATime(this.time);
		test.log(LogStatus.PASS, "Enter time as "+time+" sec");
	}
	
	
	@Then("close the page")
	public void close_the_page() {
		this.closeBrowser();
		this.removeDriver();
		test.log(LogStatus.PASS, "Close the browser");
	}

	
}

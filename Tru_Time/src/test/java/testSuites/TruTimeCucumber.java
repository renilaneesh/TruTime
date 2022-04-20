package testSuites;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;

import base.Base;
import pages.HomePage;
import pages.Login;
import pages.TruTime;

public class TruTimeCucumber extends Base{
	By email = By.xpath("//input[@type='email']");
	By next = By.xpath("//input[@type='submit']");
	By pass = By.name("passwd");
	By acc = By.id("user-name");
	By yes = By.xpath("//input[@value='Yes']");
	
	
  	Login lg = new Login();
	HomePage hp = new HomePage();
	TruTime ha= new TruTime();
	@Given("instantiating Driver")
	public void instiating_driver() {
		logger = report.createTest("Executing Test Cases");
		ha.invokeBrowser();
		reportPass("Browser is Invoked");
		ha.openURL();
		reportPass("URL is opened");
	}
	@When("To check for user login detail")
	public void to_check_for_user_login_detail() {
	lg.login();
		reportPass("login successful");	
	}

	@Then("To search for Tru time and open Tru time")
	public void to_search_for_tru_time_and_open_tru_time() {
		hp.navigateToTruTime();
		reportPass("navigated to trutime page");
	}
	@Then("To collect dates of current week from calender and Tru Time")
	public void to_collect_dates_of_current_week_from_calender() {
		ha.getData();
		reportPass("dates are obtained successfuly");
	}
	
	
	@Then("Close Browser")
	public void close_browser() {
		reportPass("Browser is closed successfuly");
		ha.endReport();
		ha.closeBrowser();
	}


}

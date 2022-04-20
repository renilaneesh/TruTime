package testSuites;

//import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.Login;
import pages.TruTime;

public class TestCases extends Base{
	Login lg = new Login();
	HomePage hp = new HomePage();
	TruTime ha= new TruTime();
	
	@BeforeTest
	public void invokeBrowser() {
		logger = report.createTest("Executing Test Cases");
		ha.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void testCase1() throws Exception {

		ha.openURL();
		reportPass("URL is opened");				
	}
	
	@Test(priority = 2)
	public void testCase2() throws Exception {
		lg.login();
		reportPass("login successful");		
	}
	
	@Test(priority = 3)
	public void testCase3() throws Exception {
		hp.navigateToTruTime();
		reportPass("navigated to trutime page");
	}
	
	@Test(priority = 4)
	public void testCase4() throws Exception {
		ha.getData();
		reportPass("dates are obtained successfuly");
	}

	@AfterTest
	public void closeBrowser() {
		reportPass("Browser is closed successfuly");
		hp.endReport();
		ha.closeBrowser();
	}
}

package pages;

import org.openqa.selenium.By;

import base.Base;

public class Login extends Base {
	By email = By.xpath("//input[@type='email']");
	By next = By.xpath("//input[@type='submit']");
	By pass = By.name("passwd");
	By acc = By.id("user-name");
	By yes = By.xpath("//input[@value='Yes']");

	public void login() {
		logger = report.createTest("Login into Becognizant.");
		try {
			wait(20, email);
			driver.findElement(email).sendKeys(prop.getProperty("email"));
			Screenshot("emailEntry");
			driver.findElement(next).click();
			wait(20, pass);
			driver.findElement(pass).sendKeys(prop.getProperty("password"));
			Screenshot("passwordEntry");
			driver.findElement(next).click();
			Thread.sleep(4000);
			reportPass("Email and Password Verified sucessfully");
			Screenshot("successfulLogin");
//			clicking call button option
//			driver.findElement(By.xpath(
//					"//*[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]/div"))
//					.click();
// 	 	    clicking text verification button
			driver.findElement(By.xpath(
					"//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[1]/div/div/div[2]/div"))
					.click();
			
			wait(120, yes);
			driver.findElement(yes).click();
			// Verify Title
			if (driver.getTitle().contains("Be.Cognizant"))
				// Pass
				System.out.println("Page title contains Be.Cognizant");
			else
				// Fail
				System.out.println("Page title doesn't contains Be.Cognizant");
			String name = driver.findElement(acc).getText();
			System.out.println("The name for the Account is: " + name);
			Screenshot("homePage");
			reportPass("Be.Cognizant Page is reached sucessfully");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
}

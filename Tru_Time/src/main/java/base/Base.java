package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	JavascriptExecutor js;
	public static WebDriverWait wait;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public File file;
	public XSSFWorkbook workbook;
	public XSSFSheet sh;
	public FileOutputStream fos;
	public String password;
	public String userid;

	// To call different browsers
	public void invokeBrowser() {
		prop = new Properties();

		try {
			prop.load(new FileInputStream(
					"src/main/java/Config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// To Open Chrome Browser
		if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Drivers/Chrome/chromedriver.exe");
			driver = new ChromeDriver();
		}

		// To Open Edge Browser
		if (prop.getProperty("browserName").matches("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/Drivers/Edge/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	// To open the Main Page URL
	public void openURL() {
	
		driver.get(prop.getProperty("websiteURLKey"));
	}

	// Function to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	// Function to take Screenshot of screen
	public void Screenshot(String fileName) throws IOException {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
//		Long dateTime = System.currentTimeMillis();
//		File destFile =  new File(System.getProperty("user.dir") + "/Screenshot/" + dateTime + "_" + fileName + ".png");
		File destFile =  new File(System.getProperty("user.dir") + "/Screenshot/" + fileName + ".png");
		Files.copy(srcFile, destFile);
	}
	

	public void wait(int sec, By locator) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// To input all data to the report
	public void endReport() {
		report.flush();
	}

	// To close the Browser
	public void closeBrowser() {
		
		driver.quit();
	}

}

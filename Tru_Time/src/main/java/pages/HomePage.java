package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import base.Base;

public class HomePage extends Base {
	By search = By.id("searchbox");
	By icon = By.className("icomoon-search2");
	By trutime = By.xpath("(//span[text()='TruTime'])[1]");

	public void navigateToTruTime() {
		logger = report.createTest("Navigate to trutime");
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("Data");
		try {
			driver.findElement(search).sendKeys(sheet.getRow(0).getCell(0).getStringCellValue());;
			Screenshot("searchTruTime");
			driver.findElement(icon).click();
			wait(20, trutime);
			Screenshot("ClickTrutime");
			String currentHandle = driver.getWindowHandle();
			driver.findElement(trutime).click();
			reportPass("Navigated to trutime page succesfully");
			Set<String> handle1 = driver.getWindowHandles();
			for (String actual : handle1) {
				if (!actual.equalsIgnoreCase(currentHandle)) {
					driver.switchTo().window(actual);
					reportPass("Switched to trutime page");
				}
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
}

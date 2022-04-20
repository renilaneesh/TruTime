package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Base;

public class TruTime extends Base{
	
	// Instantiating important object instances 	
			By date=By.xpath("//div[@class='dayDetail ng-scope']/div[1]");
			String[] expectedDays = new String[7];
			String expectedSunday; 
			String expectedSaturday;
			String actualSunday;
			String actualSaturday;
		
		public void getData() {
			logger = report.createTest("Obtain the Week from trutime.");
			try {
			driver.switchTo().frame("appFrame");
			reportPass("switchedToAppFrame");
			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Data.xlsx");
			workbook = new XSSFWorkbook();
			sh = workbook.createSheet("Dates");
			List<WebElement> dates = driver.findElements(date);
			Screenshot("Trutime");
			Date date = new Date();
			LocalDate today = LocalDate.now();
		    LocalDate sunday = today;
		    LocalDate weekDay;
		    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
		      sunday = sunday.minusDays(1);
		    }
		    expectedDays[0]=sunday.format(DateTimeFormatter.ofPattern("E, dd MMM"));;
		    for(int i=1;i<7;i++) {
		    	weekDay=sunday.plusDays(i);
		    	expectedDays[i]=weekDay.format(DateTimeFormatter.ofPattern("E, dd MMM"));;
		    }
		    
		    // Printing Expected dates of current week 
		    System.out.println("Today's Date is: "+date.toString());
			System.out.println();
			System.out.println("************************************************");
			System.out.println("The Calendar Dates for this week are:");
			System.out.println();
			System.out.println("**********************EXPECTED RESULT**************************");
		    for(int j=0;j<expectedDays.length;j++) {
		    	if(j==0) {
			    	System.out.println("This Weeks Sunday is: "+expectedDays[j]);
			    	expectedSunday=expectedDays[j].trim();
		    	}else if(j==6) {
			    	System.out.println("This Weeks Saturday is: "+expectedDays[j]);
			    	expectedSaturday=expectedDays[j].trim();
		    	}else {
		    		System.out.println(expectedDays[j]);
		    	}
		    	
		    }

		    // Printing Actual Dates of Current week from Trutime
		    System.out.println("************************************************");
			System.out.println("The TruTime Dates for this week are:");
			System.out.println();
			System.out.println("**********************ACTUAL RESULT**************************");
			for(int i = 0; i <dates.size(); i++) {
				sh.createRow(i).createCell(1).setCellValue(dates.get(i).getText());
				System.out.println(dates.get(i).getText());
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					workbook.write(fos);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				if(dates.get(i).getText().contains("Sun")) {
					System.out.println("This Weeks Sunday is: "+dates.get(i).getText());
					actualSunday=dates.get(i).getText().trim();
				}
				if(dates.get(i).getText().contains("Sat")) {
					System.out.println("This Weeks Saturday is: "+dates.get(i).getText());
					actualSaturday=dates.get(i).getText().trim();
				}
			}
			
			// Comparing Expected and Actual result for Sunday and Saturday dates
			Assert.assertEquals(expectedSunday, actualSunday);
			Assert.assertEquals(expectedSaturday, actualSaturday);
			
			reportPass("The dates are obtained sucessfully");
			} catch (Exception e) {
				reportFail(e.getMessage());
			}
		}

	}




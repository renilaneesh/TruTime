
--------------------------------------------------Project Name -- TruTime--------------------------------------------
                                                     
						     [ Main Project ]

 PROBLEM STATEMENT 

Compare the dates of current week in TruTime and the actual dates of the week .
( Site to be used : https://be.cognizant.com/ )

Detailed Description: 

1. Login to https://be.cognizant.com/  using username and password.
2. Open TruTime and goto current week.
3. Display the current week dates (Sunday to Saturday) as an expected result 
4. Display dates of the current week as shown in TruTime web application.
5. Compare Expected (calendar dates) dates of current 
( Site to be used : https://be.cognizant.com/ )

Key Automation Scope

--> Selenium Webdriver and It's concepts.
--> Cucumber Framework and it's concepts
--> TestNG framework and its concepts.
--> Data Driven/Keyword Driven approach
--> Core Java concepts
--> Page Object Model/Page factory concepts
--> Maven/Apache POI tools
--> Extent Report/TestNG Report/Customized report
--> Cross Browser Testing concepts
--> Properties file concepts



********************************************************** PROJECT OVERVIEW ************************************

1.) This project Stores in excel file named 'Data.xlsx' in Test-Output-Data- Contains the dates  corresponding to days of the current week (Sunday to Saturday) in trutime.
2.) Displays on console, the same data from Step 1.
3.) Actual dates are displayed on console using date class.
4.) We compare the two date [Expected and Actual]from Step 1 and Step 3 of Sunday(Starting) and Saturday(Ending) of the week.


**************************************************FILE DESCRIPTION************************************************

1.src/main/java- There are three packages present in this folder.

	->Base : In this package we have file:- 

		'Base.java' -  This uses class to call different browsers, to maximize the window, to open main page URL, uses Functions for showing failed/passed cases and for taking screenshots.
		

	->Pages: In this package we have file:- 
		'TruTime.java'  - This is extending the base class and managing the Login functionalities. We are comparing the Dates from trutime and the dates we get with date class.

           

	->Utils: In this package we have files:- 
		'ExcelReader.java' - In ExcelReader class we are putting the values from tets-input excel sheet of browsername, mail, password, search box value  and searching for the result.
		'ExtentReportManager.java' -  in this we are simply generating the report using ExtentReportManager class.




2. src/test/java- There is only one package prsent in this folder .
 	
	->TestSuites: In this package we have file:-
		'MainTest.java' - this MainTest class extends The Base class and  executes test cases after appropriate BeforeSuite and AfterSuite method in the desired Execution order using Priority.
	
	
3.Reports: 

	In this file we have Extentreports for executed test.

4.ScreenShot: 

	We have Screenshots of Acccount page and Trutime page in this file. 
5. target: 

	This folder is used to house all output of the build.


6. excel Test-Input: 
	
	excel file containing FieldName and Corresponding value needed as Input value.

	
7. test-output

	This folder contains generated files like testNG report.

8.excel Test-Output:
	
	this file contains Trutime dates of current week from the page output as captured during test execution .

9. pom.xml: 

	The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
	build directory, source directory, test source directory, goals etc. Maven reads the pom.xml file, then executes the goal.

10. TestNG.xml:

	This file contains test configurations.


****************************************************STEPS TO EXECUTE****************************************************************************

1) Enter your Email ID and password in Test-Input/inputData.xlsx sheet corresponding to respective Field Names.
2) Enter the Browser name in which you would like to run the project like chrome for chrome browser and firefox for firefox browser in Test-Input/inputData.xlsx sheet corresponding to respective Field Names.
3) Now go to the MainTest.java file and select --> run as --> TestNG test.
4) Now the file will Execute and we get the expected output  as shown below.


************************************************** OUTPUT ON CONSOLE********************************************************************

[RemoteTestNG] detected TestNG version 6.14.3
Starting ChromeDriver 99.0.4844.51 (d537ec02474b5afe23684e7963d538896c63ac77-refs/branch-heads/4844@{#875}) on port 33748
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
[1649412989.905][WARNING]: This version of ChromeDriver has not been tested with Chrome version 100.
Apr 08, 2022 3:46:29 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
Page title contains Be.Cognizant
The name for the Account is: R, Vishal (Cognizant)

Today's Date is: Fri Apr 08 15:47:03 IST 2022

************************************************
The Calendar Dates for this week are:

**********************EXPECTED RESULT**************************
This Weeks Sunday is: Sun, 03 Apr
Mon, 04 Apr
Tue, 05 Apr
Wed, 06 Apr
Thu, 07 Apr
Fri, 08 Apr
This Weeks Saturday is: Sat, 09 Apr
************************************************
The TruTime Dates for this week are:

**********************ACTUAL RESULT**************************
Sun, 03 Apr
This Weeks Sunday is: Sun, 03 Apr
Mon, 04 Apr
Tue, 05 Apr
Wed, 06 Apr
Thu, 07 Apr
Fri, 08 Apr
Sat, 09 Apr
This Weeks Saturday is: Sat, 09 Apr

===============================================
Main Project
Total tests run: 4, Failures: 0, Skips: 0
===============================================


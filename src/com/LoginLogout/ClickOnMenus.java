/**
 * 
 */
package com.LoginLogout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Libaray.synchronizationHandling;
import com.Libaray.takeScreenshots;
import com.LoginLogout.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author prasanna
 *
 */

public class ClickOnMenus extends BaseClass
{

	@Test(priority=1,description="TC perform to open Inbox page",alwaysRun=true)
	protected void InboxPage()
	{

		try
		{
			driver.navigate().refresh();

			LoginToVzone.LoginValid();

			report.startTest("open Inbox page");

			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			synchronizationHandling.isElementPresntById(driver, "DASHBOARD", 30).click();

			logger.log(LogStatus.INFO, "Clicked on dashboard menu");

			synchronizationHandling.isElementPresntByXpath(driver, "//a[@href='http://test.vzone.vmokshagroup.com/Inbox']", 30).click();

			logger.log(LogStatus.INFO, "Clicked on Inbox submenu");

			takeScreenshots.capturescreenshot(driver,"InboxPage");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		}

		String url1=driver.getCurrentUrl();

		Assert.assertTrue(url1.contains("Inbox"),"page is not inbox,sorry we are in wrong page");

		logger.log(LogStatus.PASS,"Inbox page opens successfully");
	}

	@Test(priority=2,description="TC perform to open HR page",alwaysRun=true)
	public void ClickOnHR()
	{

		try {
			report.startTest("open HR Page");

			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			synchronizationHandling.isElementPresntById(driver, "DASHBOARD", 30).click();

			logger.log(LogStatus.INFO, "Clicked on dashboard menu");

			synchronizationHandling.isElementPresntByXpath(driver, "//a[@href='http://test.vzone.vmokshagroup.com/HR/Dashboard']", 30).click();

			logger.log(LogStatus.INFO, "Clicked on HR submenu");

			takeScreenshots.capturescreenshot(driver, "HRPage");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		}
		// url2 condition
		String url2=driver.getCurrentUrl();

		Assert.assertTrue(url2.contains("HR"),"page is not HR,sorry we are in wrong page");

		logger.log(LogStatus.PASS, "HR page opens successfully");
	}

	@Test(priority=3,description="TC perform to details of HR page",alwaysRun=true)
	public void detailsOfHr()
	{
		report.startTest("Details of HR page");

		// operation on tab Employee(s)
		String tabname1=driver.findElement(By.xpath(".//*[@id='divEmployee']/div[1]/p")).getText();

		System.out.println("Name on the tab is "+tabname1);

		Assert.assertTrue(tabname1.contains("Employee(s)")," Tabname is not employee(s),it is different tab");

		logger.log(LogStatus.PASS, "Employee(s)tab verified");

		synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='divEmployee']/div[1]/p", 30).click();

		logger.log(LogStatus.INFO, "clicked on Employee(s)Tab");

		driver.navigate().refresh();

		//operation on tab Attendance
		String tabname2=driver.findElement(By.xpath(".//*[@id='divShortage']/div[1]/p")).getText();

		System.out.println("Name on the tab is "+tabname2);

		Assert.assertTrue(tabname2.contains("Attendance")," Tabname is not Attendance,it is different tab");

		logger.log(LogStatus.PASS, "Attendance tab verified");

		driver.navigate().refresh();


	}

	@Test(priority=4,description="Open the Recuiters page",alwaysRun=true)
	public void Recuiter()
	{

		try {
			report.startTest("Open Recuiter page");

			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			synchronizationHandling.isElementPresntById(driver, "DASHBOARD", 30).click();

			logger.log(LogStatus.INFO, "Clicked on dashboard menu");

			synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='divDASHBOARD']/li[4]/a", 30).click();

			logger.log(LogStatus.INFO, "Clicked on Recuiter submenu");

			takeScreenshots.capturescreenshot(driver, "Recuiterpage");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		}

		String url3=driver.getCurrentUrl();

		Assert.assertTrue(url3.contains("Recruiters"),"page is not Recruiters,sorry we are in wrong page");

		logger.log(LogStatus.PASS, "Recruiter page opens successfully");

	}

}

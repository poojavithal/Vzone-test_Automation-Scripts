package com.LoginLogout;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Libaray.takeScreenshots;
import com.relevantcodes.extentreports.LogStatus;


public class LoginToVzone extends BaseClass
{

	@Test(description="TC perform Login Functionality")
	public static void ValidLogin() throws InterruptedException
	{
		report.startTest("Login with valid credentials");

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.id("inputUsername")).sendKeys("anushan@vmokshagroup.com");

		driver.findElement(By.id("inputPassword")).sendKeys("Power@1234");

		takeScreenshots.capturescreenshot(driver, "validLoginCredentials");

		driver.findElement(By.id("btnSignIn")).click();

		logger.log(LogStatus.INFO, "Clicked on login button");

		Thread.sleep(3000);

		//String Imagetext=driver.findElement(By.xpath("//img[@alt='VMLabs']")).getText();
		String Imagetext=driver.findElement(By.xpath(".//*[@id='breadcrumb']/ul/li[1]/a")).getText();

		Assert.assertTrue(Imagetext.contains("DASHBOARD"), "We are not logged into vzone");

		logger.log(LogStatus.PASS, " Login with valid credentials has verified");

	}

	@Test(dependsOnMethods={"ValidLogin"},description="TC perform Logout functionality")
	public static void LogoutFunction() throws Exception
	{
		report.startTest("Logout user");

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		// click on the profile icon to open the logout popup
		driver.findElement(By.xpath("//*[@id='anushan@vmokshagroup.com']")).click();

		takeScreenshots.capturescreenshot(driver, "LogoutPopup");

		//String UserName=driver.findElement(By.xpath("//b[contains(text(),'Anusha N')]")).getText();
		// get the name of the user on the logout screen
		String UserName=driver.findElement(By.xpath(".//*[@id='topMenu']/li[6]/ul/li/div/div[2]/div[2]/div[1]/b")).getText();

		Assert.assertTrue(UserName.contains("Anusha"), "we are not Logging out valid user");

		logger.log(LogStatus.INFO, "In Logout Screen ");

		driver.findElement(By.id("anchSignout")).click();

		Thread.sleep(2000);

		logger.log(LogStatus.PASS, "Logout user verified");
	}


	@Test(dependsOnMethods={"LogoutFunction","ValidLogin"},description="TC perform Login for Invalidcredentials")
	public static void invalidLogin() throws Exception
	{
		report.startTest("Login with invalid credentials");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.id("inputUsername")).sendKeys("anu@vmokshagroup.com");

		driver.findElement(By.id("inputPassword")).sendKeys("Power@1234564");

		driver.findElement(By.id("btnSignIn")).click();

		Thread.sleep(2000); 
		
		logger.log(LogStatus.INFO, "Clicked on login button");
		
		takeScreenshots.capturescreenshot(driver, "Error message");

		String ErrorMessage=driver.findElement(By.id("divAuthFailed")).getText();

		Assert.assertEquals(ErrorMessage,"The username or password you have entered is incorrect.","Error message is not valid one");
		
		logger.log(LogStatus.PASS, "Login with invalid credentials has verified");
		
	}

}

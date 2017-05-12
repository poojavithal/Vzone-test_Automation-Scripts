package com.LoginLogout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.Libaray.takeScreenshots;
import com.ObjectRepository.ConfigurationFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass 
{
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ConfigurationFile config;
	
	@BeforeTest
	public void SetUp()
	{ 
		//System.setProperty("webdriver.gecko.driver","‪C:/pooja/geckodriver.exe");
		//System.setProperty("webdriver.chorme.driver","‪C:/pooja/chromedriver.exe");
		//driver=new ChromeDriver();
		
		//launching the browser
		config=new ConfigurationFile();

		report=new ExtentReports(config.getExtentReportPath());

		logger=report.startTest("SetUp");

		driver=new FirefoxDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, "Browser started");

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.get(config.getApplicationURL());

		logger.log(LogStatus.INFO, "Application is up and running");

		String imagetitle =driver.findElement(By.xpath("//a[text()='Forgot Password?']")).getText();

		Assert.assertTrue(imagetitle.contains("Forgot Password?"), "We are not in Login Screen");

		logger.log(LogStatus.PASS, "Condition is verified we are in Login Screen");


	}

	@AfterTest
	public void teardown()
	{	
		report.endTest(logger);
		
		report.flush();
		
		//driver.get(config.getExtentReportPath());
	
		driver.quit();	

		logger.log(LogStatus.PASS, "Browser Closed ");
		
	} 

	@AfterMethod
	public void TestFaliure(ITestResult result)
	{

		if(result.getStatus()==ITestResult.FAILURE)
		{
			String ScreenShot_path=takeScreenshots.capturescreenshot(driver, result.getName());
			String image=logger.addScreenCapture(ScreenShot_path);
			logger.log(LogStatus.FAIL, result.getName(), image);
		}
		
	}

	//	@DataProvider(name="Vzone")
	//	protected Object[][] passData()
	//	{
	//		ConfigurationFile config1=new ConfigurationFile();
	//
	//		ReadExcelData excel= new ReadExcelData(config1.getExcelPath());
	//
	//		int rows=excel.getRowCount("Credentials");
	//
	//		Object[][] data= new Object[rows][2];
	//
	//		for(int i=0;i<rows;i++)
	//		{
	//			data[i][0]=excel.getData("Credentials", i, 0);
	//			data[i][1]=excel.getData("Credentials", i, 1);
	//		}
	//
	//		return data;
	//
	//	}
}



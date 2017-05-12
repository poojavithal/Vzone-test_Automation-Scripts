package com.Libaray;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class takeScreenshots
{ 
	public static String path;

	public static String capturescreenshot(WebDriver driver,String Screenshotname)
	{ 
		
	try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			 path ="C:\\pooja\\Selenium Webdriver\\Selenium Projects\\vzone Automation.zip_expanded\\Vzone_Testing\\Screenshots\\"+Screenshotname+".png";
				
			File destination=new File(path);
			
			FileUtils.copyFile(source, destination);
			
			Reporter.log("=====Screenshot of "+Screenshotname+" taken successfully======"+"\n", true);
			
			
		}
		
		catch (Exception e) 
		{
			System.out.println("exception while taking screenshot is "+e.getMessage());

		}
	return path;


	}


}
 
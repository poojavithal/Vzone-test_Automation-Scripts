package com.Libaray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWait 
{
	static WebDriver driver;

	public static void waitCall( String Xpath,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		
		element.click();
	}

}

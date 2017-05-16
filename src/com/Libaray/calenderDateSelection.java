/**
 * 
 */
package com.Libaray;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author PoojaV
 *
 */
public class calenderDateSelection
{
	public static void DatePicker(WebDriver driver,String xpath,String number)
	{
		List<WebElement> allDates =driver.findElements(By.xpath(xpath));

		int totalcount=allDates.size();

		for(int i=0;i<totalcount;i++)
		{
			String date=allDates.get(i).getText();

			if(date.equals(number))
			{
				allDates.get(i).click();

				System.out.println("selected date from the Datepicker is "+number);

				break;
			}

		}
		
	}





}

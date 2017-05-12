/**
 * 
 */
package com.Libaray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author PoojaV
 *
 */
public class synchronizationHandling 
{
	public static WebElement isElementPresntByXpath(WebDriver driver,String xpath,int time)
	{
		WebElement ele = null;

		for(int i=0;i<time;i++)
		{
			try
			{
				ele=driver.findElement(By.xpath(xpath));
				break;
			}
			catch(Exception e)
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e1) 
				{
					System.out.println("Waiting for element to appear on DOM");
				}
			}


		}
		return ele;

	}

	public static WebElement isElementPresntById(WebDriver driver,String id,int time)
	{
		WebElement ele = null;

		for(int i=0;i<time;i++)
		{
			try
			{
				ele=driver.findElement(By.id(id));
				break;
			}
			catch(Exception e)
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e1) 
				{
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		return ele;



	}


}
















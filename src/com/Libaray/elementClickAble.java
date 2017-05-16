/**
 * 
 */
package com.Libaray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author PoojaV
 *
 */
public class elementClickAble 
{

	public static void clickForXpath(WebDriver driver,String Xpath)
	{
		Actions act=new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath(Xpath))).click().build().perform();

	}
	public static void clickForId(WebDriver driver,String Id)
	{
		Actions act=new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath(Id))).click().build().perform();
	}
	public static void clickForcssSelector(WebDriver driver,String cssSelector)
	{
		Actions act=new Actions(driver);

		act.moveToElement(driver.findElement(By.cssSelector(cssSelector))).click().build().perform();
	}

}



/**
 * 
 */
package com.ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * @author PoojaV
 *
 */
public class ConfigurationFile 
{
	Properties pro;

	public ConfigurationFile()
	{
		try 
		{
			File src= new File(".//ObjectRepository//OR.properties");

			FileInputStream input=new FileInputStream(src);

			pro =new Properties();

			pro.load(input);
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception is =="+e.getMessage());

		}
	}

	public String getApplicationURL()
	{
		return pro.getProperty("URL");

	}

	public String getExcelPath()
	{
		return pro.getProperty("ExcelPath");

	}

	public String getExtentReportPath()
	{
	return pro.getProperty("ExtentReportPath");
	
	}





}

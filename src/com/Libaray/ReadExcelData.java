/**
 * 
 */
package com.Libaray;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * @author PoojaV
 *
 */
public class ReadExcelData 
{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ReadExcelData (String Excelpath)
	{
		try 
		{
			File src =new File(Excelpath);

			fis =new FileInputStream(src);

			wb=new XSSFWorkbook(fis);

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception is=="+e.getMessage());
		}
	}
	public String getData(String sheetName,int row, int column)
	{
		sheet=wb.getSheet(sheetName);

		String data=sheet.getRow(row).getCell(column).getStringCellValue();

		return data;
	}

	public int getRowCount(String sheetName)
	{
		int row=wb.getSheet(sheetName).getLastRowNum();

		return row=row+1;


	}


}
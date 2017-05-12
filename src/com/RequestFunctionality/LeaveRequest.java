/**
 * 
 */
package com.RequestFunctionality;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.Libaray.calenderDateSelection;
import com.Libaray.elementClickAble;
import com.Libaray.takeScreenshots;
import com.LoginLogout.BaseClass;
import com.relevantcodes.extentreports.LogStatus;


/**
 * @author prasanna
 *
 */

public class LeaveRequest extends BaseClass
{     
	@Test(priority=5,description="TC perform Sending leave request to respective Manger",alwaysRun=true)
	public void ApplyLeave() throws Throwable
	{ 
		String textname;

		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		report.startTest("Leave request for privilege");
		
		//LeaveRequestdetails of the Employee
		driver.findElement(By.xpath(".//*[@id='REQUEST']/b")).click();

		driver.findElement(By.xpath(".//*[@id='divREQUEST']/li[8]/a")).click();

		textname = driver.findElement(By.xpath(".//*[@id='breadcrumb']/ul/li[2]")).getText();
		
		logger.log(LogStatus.INFO, "Verifying Leave Request page");

		System.out.println("Name on the title is "+textname);

		Thread.sleep(5000);

		//Leave type drop-down without select class and click on dropdown
		elementClickAble.clickForXpath(driver, ".//*[@id='s2id_cbo_LeaveType']/a/span");

		//Leave type selection from drop-down
		elementClickAble.clickForXpath(driver, "html/body/div[10]/ul/li[5]/div");

		logger.log(LogStatus.PASS, "Privilege Leave Type selected");

		takeScreenshots.capturescreenshot(driver, "LeaveRequestdetails");

		
		//selec date from fromDate picker
		driver.findElement(By.id("txtFromDate")).click();

		calenderDateSelection.DatePicker(driver, "//div/table/tbody//td", "1");
		
		logger.log(LogStatus.INFO, "From date selected");

		//selec date from ToDate picker
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");

		driver.findElement(By.id("txtToDate")).click();

		calenderDateSelection.DatePicker(driver, "//div/div/table//td", "2");

		logger.log(LogStatus.INFO, "To date selected");
		
		//Reason drop-down selection
		elementClickAble.clickForXpath(driver, ".//*[@id='s2id_cbo_LeaveReason']/a/span");

		elementClickAble.clickForXpath(driver, "//div[10]/ul/li[4]/div");

		driver.findElement(By.id("txtOthers")).click();

		driver.findElement(By.id("txtOthers")).sendKeys("New Career expose");

		logger.log(LogStatus.INFO, "Valid reason selected");
		
		//contact details click on address field
		driver.findElement(By.id("txtMemo_LeaveMgmtAddress")).click();

		driver.findElement(By.id("txtMemo_LeaveMgmtAddress")).sendKeys("HSR Bangalore");

		//contact details click on phone number field
		driver.findElement(By.id("txtNumber")).click();

		driver.findElement(By.id("txtNumber")).sendKeys("8036545013");

		Thread.sleep(3000);

		logger.log(LogStatus.INFO, "Contact details selected");
		
		
		//click and enter data into memo
		driver.findElement(By.id("txtMemo_LeaveRequest_General")).click();

		driver.findElement(By.id("txtMemo_LeaveRequest_General")).sendKeys("Leave Request for career expose");

		logger.log(LogStatus.INFO, "Memo entered");
		
		//click on submit button
		driver.findElement(By.id("btn_LeaveRequestSubmit")).click();
		
		Thread.sleep(5000);

		logger.log(LogStatus.INFO, "Submit button clicked");
		
		//alert popup handling
		driver.switchTo();

		System.out.println("we are in popup");

		driver.findElement(By.id("btnSubmitRequest_Ok")).click();

		Thread.sleep(8000);

		takeScreenshots.capturescreenshot(driver, "LeaveRequest");
		
		logger.log(LogStatus.PASS, "Leave request submitted");

		//In Inbox screen in My Request grid click on created ID and fectch the ID Number
		String dialogTitle= driver.findElement(By.xpath(".//*[@id='db-myRequestsGroup']/div/div[1]/h3")).getText();

		driver.findElement(By.xpath(".//*[@id='myCarousel']/div/div[1]/div/div[3]/div[1]/div[1]/div[1]/a/span")).click();
		
		logger.log(LogStatus.INFO, "Redirected dashboard, clicked on created request in MY Request(S)");

		Thread.sleep(5000);

		String RequestId=driver.findElement(By.id("txt_LeaveRequestRequestId")).getText();

		System.out.println("Dailogue grid name is "+dialogTitle+" and Request Id is "+RequestId);

		logger.log(LogStatus.PASS, "RequestId captured");
	}
}

/**
 * 
 */
package com.RequestFunctionality;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Libaray.ExplicityWait;
import com.Libaray.calenderDateSelection;
import com.Libaray.elementClickAble;
import com.Libaray.synchronizationHandling;
import com.Libaray.takeScreenshots;
import com.LoginLogout.BaseClass;
import com.LoginLogout.LoginToVzone;
import com.relevantcodes.extentreports.LogStatus;





/**
 * @author prasanna
 *
 */

public class LeaveRequest extends BaseClass
{    
	String RequestId;

	@Test(priority=5,description="TC perform Sending leave request to respective Manager")
	public void ApplyLeave() throws Throwable
	{ 
		String textname;

		LoginToVzone.LoginValid();

		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

		report.startTest("Leave request for privilege");

		//LeaveRequestdetails of the Employee
		synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='REQUEST']/b", 30).click();

		synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='divREQUEST']/li[8]/a", 30).click();

		textname = synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='breadcrumb']/ul/li[2]", 30).getText();

		logger.log(LogStatus.INFO, "Verifying Leave Request page");

		System.out.println("Name on the title is "+textname);	
		//====================================================================================		
		//ExplicityWait.waitCall("//*[@id='s2id_cbo_LeaveType']/a/span", 40);

		//ExplicityWait.waitCall("html/body/div[10]/ul/li[5]/div", 40);

		//Leave type drop-down without select class and click on dropdown
		elementClickAble.clickForXpath(driver, ".//*[@id='s2id_cbo_LeaveType']/a/span");

		//Leave type selection from drop-down
		elementClickAble.clickForXpath(driver, "html/body/div[10]/ul/li[5]/div");

		logger.log(LogStatus.PASS, "Privilege Leave Type selected");

		takeScreenshots.capturescreenshot(driver, "LeaveRequestdetails");

		//selec date from fromDate picker
		synchronizationHandling.isElementPresntById(driver, "txtFromDate", 30).click();

		calenderDateSelection.DatePicker(driver, "//div/table/tbody//td", "3");

		logger.log(LogStatus.INFO, "From date selected");

		//selec date from ToDate picker
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");

		synchronizationHandling.isElementPresntById(driver, "txtToDate", 30).click();

		calenderDateSelection.DatePicker(driver, "//div/div/table//td", "3");

		logger.log(LogStatus.INFO, "To date selected");

		//====================================================================================

		//Reason drop-down selection
		elementClickAble.clickForXpath(driver, ".//*[@id='s2id_cbo_LeaveReason']/a/span");

		elementClickAble.clickForXpath(driver, "//div[10]/ul/li[4]/div");

		synchronizationHandling.isElementPresntById(driver, "txtOthers", 30).click();

		synchronizationHandling.isElementPresntById(driver, "txtOthers", 30).sendKeys("New Career expose");

		logger.log(LogStatus.INFO, "Valid reason selected");

		//contact details click on address field
		synchronizationHandling.isElementPresntById(driver, "txtMemo_LeaveMgmtAddress", 30).click();

		synchronizationHandling.isElementPresntById(driver, "txtMemo_LeaveMgmtAddress", 30).sendKeys("HSR Bangalore");

		//contact details click on phone number field
		synchronizationHandling.isElementPresntById(driver, "txtNumber", 30).click();

		synchronizationHandling.isElementPresntById(driver, "txtNumber", 30).sendKeys("8036545013");

		Thread.sleep(3000);

		logger.log(LogStatus.INFO, "Contact details selected");


		//click and enter data into memo
		synchronizationHandling.isElementPresntById(driver, "txtMemo_LeaveRequest_General", 30).click();

		synchronizationHandling.isElementPresntById(driver, "txtMemo_LeaveRequest_General", 30).sendKeys("Leave Request for career expose");

		logger.log(LogStatus.INFO, "Memo entered");

		//====================================================================================	

		//click on submit button
		synchronizationHandling.isElementPresntById(driver, "btn_LeaveRequestSubmit", 30).click();

		Thread.sleep(5000);

		logger.log(LogStatus.INFO, "Submit button clicked");

		//alert popup handling
		driver.switchTo();

		System.out.println("we are in popup");

		synchronizationHandling.isElementPresntById(driver, "btnSubmitRequest_Ok", 30).click();

		Thread.sleep(8000);

		takeScreenshots.capturescreenshot(driver, "LeaveRequest");

		logger.log(LogStatus.PASS, "Leave request submitted");

		//====================================================================================	

		//In Inbox screen in My Request grid click on created ID and fectch the ID Number
		String dialogTitle= driver.findElement(By.xpath(".//*[@id='db-myRequestsGroup']/div/div[1]/h3")).getText();

		String Leavetype= driver.findElement(By.xpath(".//*[@id='myCarousel']/div/div[2]/div/div[1]/div/center/strong")).getText();

		System.out.println(Leavetype);

		//Assert.assertEquals( Leavetype.equalsIgnoreCase("LEAVE REQUEST"),"Selection going to happen in other layout");

		driver.findElement(By.xpath(".//*[@id='myCarousel']/div/div[1]/div/div[3]/div[1]/div[1]/div[1]/a/span")).click();

		logger.log(LogStatus.INFO, "Redirected dashboard, clicked on created request in MY Request(S)");

		Thread.sleep(5000);

		RequestId=driver.findElement(By.id("txt_LeaveRequestRequestId")).getText();

		System.out.println("Dailogue grid name is "+dialogTitle+" and Request Id is "+RequestId+" with request type is"+Leavetype);
		Thread.sleep(5000);

		logger.log(LogStatus.PASS, "RequestId captured");
	}

	@Test(priority=6,description="TC perform Sending leave request to respective Manger",alwaysRun=true)
	public void ManagerApproval()
	{
		String ID ;
		try 
		{   // Login with Manager
			LoginToVzone.LogoutFunction();

			synchronizationHandling.isElementPresntById(driver, "inputUsername", 30).sendKeys("srinivasarv@vmokshagroup.com");

			synchronizationHandling.isElementPresntById(driver, "inputPassword", 30).sendKeys("Power@123");

			synchronizationHandling.isElementPresntById(driver, "btnSignIn", 30).click();

			logger.log(LogStatus.INFO, "Logged as Manager");
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> allRequests =driver.findElements(By.xpath("//*[@id='tblInboxGrid']//tr/td[2]"));

		int totalcount=allRequests.size();

		for(int i=0;i<totalcount;i++)
		{
			ID=allRequests.get(i).getText();

			if(ID.equals(RequestId))
			{
				synchronizationHandling.isElementPresntByXpath(driver, "//*[@id='tblInboxGrid']//tr[1]/td[1]/a/i", 40).click();

				break;
			}
			logger.log(LogStatus.PASS, "Requested requestId is selected ");
		}
		System.out.println("selected request from the Inbox list is "+RequestId);

		//scroll down and scroll up to view the details completely
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");

		((JavascriptExecutor)driver).executeScript("scroll(0,-400)");

		synchronizationHandling.isElementPresntById(driver, "txtMemo_Comments",30).click();

		synchronizationHandling.isElementPresntById(driver, "txtMemo_Comments",30).sendKeys("Can't able to approve leave in this time for this day Because nobody is there to handle your work anyway i will approve this time");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement RadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("optionsRadiosReject")));

		RadioButton.click();

		//elementClickAble.clickForXpath(driver, ".//*[@id='s2id_cbo_QueryTo']/a/span");

		//elementClickAble.clickForcssSelector(driver, ".select2-result-label");

		//synchronizationHandling.isElementPresntById(driver, "btnCommentPVReject", 30).click();


		logger.log(LogStatus.INFO, "Accepted request with comments");

		//		//switching to popup
		//		driver.switchTo();
		//
		//		synchronizationHandling.isElementPresntById(driver, "btnCommentActionOk", 60).click();
		//
		//		takeScreenshots.capturescreenshot(driver, "ManagerApproval");
		//
		//		logger.log(LogStatus.PASS, "Rejected request, redirected into dashboard");
	}


	@Test
	public void CancelLeave()
	{}






}

/**
 * 
 */
package com.TestNGListenerImplimentation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author PoojaV
 *
 */
public class TestNGListener implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase started and Testcase details are "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Testcase success and Testcase details are "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		System.out.println("Testcase failed and Testcase details are "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Testcase skipped and Testcase details are "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}

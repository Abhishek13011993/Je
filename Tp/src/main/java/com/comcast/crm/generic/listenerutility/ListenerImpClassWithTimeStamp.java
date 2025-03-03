package com.comcast.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.generic.baseutility.BaseClass;

public class ListenerImpClassWithTimeStamp implements ITestListener , ISuiteListener
{

	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">==== START ====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">==== END =====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String tim = new Date().toString().replace(" ","_").replace(":","_");
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+TestName+ "+"+tim+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
}

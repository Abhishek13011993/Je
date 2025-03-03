package com.comcast.crm.generic.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener , ISuiteListener
{
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();//add env info and create test
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER","CHROME");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">==== START ====");
		test =report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">==== END =====");
		UtilityClassObject.getTest().log(Status.PASS,result.getMethod().getMethodName()+"==>COMPLETED<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, time);
		UtilityClassObject.getTest().log(Status.FAIL,TestName+"==>FAILED<==");
				
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

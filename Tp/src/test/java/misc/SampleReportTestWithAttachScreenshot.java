package misc;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTestWithAttachScreenshot 
{
	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");//spark report config
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();//add env info and create test
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER","CHROME");
		
		}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	@Test
	public void CreateContactTest() 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		ExtentTest test=report.createTest("CreateContactTest");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact App");
		test.log(Status.INFO, "Create Contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact is Created");
		}else {
			test.addScreenCaptureFromBase64String(filepath, "Errorfile");
		}
	}
	
	
	@Test
	public void CreateContactWithPhone() 
	{
		ExtentTest test=report.createTest("CreateContactWithPhone");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact App");
		test.log(Status.INFO, "Create Contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact is Created");
		}else {
			test.log(Status.FAIL,"Contact is not Created");
		}
	}
	
	@Test
	
	public void CreateContactWithOrg() 
	{
		ExtentTest test=report.createTest("CreateContactWithOrg");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact App");
		test.log(Status.INFO, "Create Contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact is Created");
		}else {
			test.log(Status.FAIL,"Contact is not Created");
		}
	}
}

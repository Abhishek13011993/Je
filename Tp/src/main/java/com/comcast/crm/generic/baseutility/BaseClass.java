package com.comcast.crm.generic.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.UtilityClassObject;
import com.comcast.crm.generic.webutility.WebDriverUtility;
import com.crmcast.crm.generic.objectrepositoryutility.HomePage;
import com.crmcast.crm.generic.objectrepositoryutility.LoginPage;



public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() throws SQLException
	{
		System.out.println("======Connect to database======");
		dlib.getDbconnection();	
		}
	
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("======launch the brwoser======");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
			sdriver=driver;
			UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
		System.out.println("======login======");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("======logout======");
		HomePage hp= new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("======close the browser======");
		driver.quit();
	}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("======disconnect from database======");
		dlib.closeDbconection();
	}

	
	
}
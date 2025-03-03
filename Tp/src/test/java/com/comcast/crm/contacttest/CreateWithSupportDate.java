
package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebDriverUtility;

public class CreateWithSupportDate {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
	    
		String lastname=elib.getDataFromExcel("contact", 1,2);
		String startDate =jlib.getSystemDateYYYYMMDD();
		String endDate=jlib.getRequiredDateYYYTMMDD(30);
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
		   driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
		   driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
		   driver=new EdgeDriver();
		}else {
		   driver=new ChromeDriver();
		}
		   
		   
		   wlib.waitForPageToLoad(driver);;
		   driver.get(URL);
		   driver.manage().window().maximize();
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.linkText("Contacts")).click();
		   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		   
		   
		   driver.findElement(By.name("lastname")).sendKeys(lastname);
		   WebElement sdate = driver.findElement(By.name("support_start_date"));
		   sdate.clear();
		   sdate.sendKeys(startDate);
		   
		   WebElement edate = driver.findElement(By.name("support_end_date"));
		   edate.clear();
		   edate.sendKeys(endDate);
		   
		   
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String actStartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		   if (actStartdate.equals(startDate)) {
			   System.out.println(startDate + " information is verified==PASS");
		   }   else {
		   System.out.println(startDate + " information is not verified==FAIL");
	       }
		   String actEnddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		   if (actEnddate.equals(endDate)) {
			   System.out.println(endDate + " information is verified==PASS");
		   }   else {
		   System.out.println(endDate + " information is not verified==FAIL");
	       }
		  
		   driver.quit();
	}

}

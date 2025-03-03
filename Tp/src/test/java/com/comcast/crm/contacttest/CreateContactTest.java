package com.comcast.crm.contacttest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		String LastName = elib.getDataFromExcel("contact", 1, 2)+randomInt;		
		
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
		   
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get(URL);
		   driver.manage().window().maximize();
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.linkText("Contacts")).click();
		   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		   driver.findElement(By.name("lastname")).sendKeys(LastName);
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		   if(actLastName.equals(LastName)) {
			   System.out.println(LastName + " information is verified==PASS");
		   }else {
			   System.out.println(LastName + " information is not verified==FAIL");
		   }
		   driver.quit();

	}

}

package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./configAppdata/ddt.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("./testdata/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString()+randomInt;
		String Industry=row.getCell(3).toString();
		String Type=row.getCell(4).toString();
		wb.close();
		
		
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
		   
		   driver.get(URL);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   driver.manage().window().maximize();
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   WebElement wbsel1=driver.findElement(By.name("industry"));
		   Select sel1=new Select(wbsel1);
		   sel1.selectByVisibleText(Industry);
		   WebElement wbsel2 = driver.findElement(By.name("accounttype"));
		   Select sel2=new Select(wbsel2);
		   sel2.selectByVisibleText(Type);
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		   if (actIndustries.equals(Industry)) {
			   System.out.println(Industry + " information is created==PASS");
		   }   else {
		   System.out.println(Industry + " information is not created==FAIL");
	       }
		   String actType = driver.findElement(By.id("dtlview_Type")).getText();
		   if (actType.equals(Type)) {
			   System.out.println(Type + " information is created==PASS");
		   }   else {
		   System.out.println(Type + " information is not created==FAIL");
	       }
		   
		   driver.quit();
		   }
}



package com.crm.comcast.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoProduct2 {
@Test(dataProvider = "getData")
public void getproductinfoTest(String brandName , String ProductName) {
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
	String x = "//span[text()='"+ProductName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}
@DataProvider
	public Object[][] getData() throws Throwable {
	
	  ExcelUtility elib=new ExcelUtility();
	  int rowCount = elib.getRowcount("product");
		Object[][] objArr=new Object[rowCount][2];
		for(int i=0; i<rowCount;i++) {
		objArr[i][0]= elib.getDataFromExcel("product", i+1, 0);
		objArr[i][1]= elib.getDataFromExcel("product", i+1, 1);
		}
		return objArr;
}

}
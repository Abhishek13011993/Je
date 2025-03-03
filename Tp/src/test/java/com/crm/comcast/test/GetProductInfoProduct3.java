package com.crm.comcast.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoProduct3 {
@Test(dataProvider = "getData")
public void getproductinfoTest(String brandName , String ProductName) {
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(brandName,Keys.ENTER);
	String x = "";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}
@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[3][2];
		objArr[0][0]= "Samsung";
		objArr[0][1]= "";
		
		objArr[1][0]= "Samsung";
		objArr[1][1]= "Samsung Galaxy S23 FE 5G (Graphite 128 GB Storage) (8 GB RAM)";
		
		objArr[2][0]= "Samsung";
		objArr[2][1]= "Samsung Galaxy S23 Ultra 5G AI Smartphone (Green, 12GB, 256GB Storage)";
	return objArr;
}
}

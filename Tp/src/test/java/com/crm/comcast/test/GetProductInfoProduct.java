package com.crm.comcast.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoProduct {
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
	public Object[][] getData() {
		Object[][] objArr=new Object[3][2];
		objArr[0][0]= "Samsung";
		objArr[0][1]= "Samsung Galaxy F15 5G (Ash Black, 6GB RAM, 128 GB Storage)";
		
		objArr[1][0]= "Samsung";
		objArr[1][1]= "Samsung Galaxy S23 FE 5G (Graphite 128 GB Storage) (8 GB RAM)";
		
		objArr[2][0]= "Samsung";
		objArr[2][1]= "Samsung Galaxy S23 Ultra 5G AI Smartphone (Green, 12GB, 256GB Storage)";
	return objArr;
}
}

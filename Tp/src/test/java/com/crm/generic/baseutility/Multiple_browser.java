package com.crm.generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Multiple_browser {
@Test(invocationCount = 4,threadPoolSize = 2)
public void demo() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.google.com");
	Thread.sleep(2000);
	driver.quit();
}
}

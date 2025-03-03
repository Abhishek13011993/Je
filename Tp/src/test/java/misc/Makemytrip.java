package misc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Makemytrip {

	@Test
	public void mmt() {
		String monandyear="March 2025";
		int number=28;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		WebElement search=driver.findElement(By.xpath("//div[text()='"+monandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+number+"']"));
		Actions act=new Actions(driver);
		
		
		act.doubleClick(search).perform();
		}

}

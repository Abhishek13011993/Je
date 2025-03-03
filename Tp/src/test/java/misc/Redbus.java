package misc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redbus {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")).click();
	    
	   WebElement ele = driver.findElement(By.xpath("//span[text()='27']"));
	   ele.click();
	   System.out.println(ele);
	   
		
		
	}
}

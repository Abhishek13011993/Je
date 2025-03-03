package misc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Airasia {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.airindia.com/");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.id("dpFromDate_label")).click();
		driver.findElement(By.xpath("//div[contains(text(),'March 2025')]")).click();
		
		
		

	}

}

package misc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Isrtc {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='ui-state-default ng-tns-c58-10 ui-state-active ui-state-highlight ng-star-inserted']")).click();
		

	}

}

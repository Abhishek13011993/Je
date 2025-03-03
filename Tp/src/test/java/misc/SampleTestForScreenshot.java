package misc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot 
{
	@Test
	public void AmazonTest() throws IOException
	{
	WebDriver driver=new ChromeDriver();
	driver.get("http://amazon.com");
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("./Screenshot/test.png"));
	}
}

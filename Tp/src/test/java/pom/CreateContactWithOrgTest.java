package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		String Lastname=elib.getDataFromExcel("contact", 1, 2);
		String orgName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		
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
		   
		   
		   wlib.waitForPageToLoad(driver);
		   driver.get(URL);
		   driver.manage().window().maximize();
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if (headerInfo.contains(orgName)) {
			   System.out.println(orgName + " header is verified==PASS");
		   }   else {
		   System.out.println(orgName + " header is not verified==FAIL");
	       }
		   
		   driver.findElement(By.linkText("Contacts")).click();
		   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		   driver.findElement(By.name("lastname")).sendKeys(Lastname);
		   driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
		   while (it.hasNext()) {
			 String windowID = it.next();
			 driver.switchTo().window(windowID);
			 String actUrl=driver.getCurrentUrl();
			 if(actUrl.contains("module=Accounts")){
		   break;	 
			 }	
		}
		   driver.findElement(By.name("search_text")).sendKeys(orgName);
		   driver.findElement(By.name("search")).click();
		   driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		   Set<String> set1= driver.getWindowHandles();
		   Iterator<String> it1 = set1.iterator();
		   while (it1.hasNext()) {
			 String windowID = it1.next();
			 driver.switchTo().window(windowID);
			 String actUrl=driver.getCurrentUrl();
			 if(actUrl.contains("Contacts&action")){
		   break;	 
			 }	
		}
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		   if(actOrgName.trim().equals(orgName)) {
			   System.out.println(orgName + " information is created==PASS");
		   }else {
			   System.out.println(orgName + " information is not created==FAIL");
			   		
		   }
		   
		   driver.quit();
		   
	}
}
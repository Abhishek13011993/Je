package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.crmcast.crm.generic.objectrepositoryutility.ContactPage;
import com.crmcast.crm.generic.objectrepositoryutility.ContactinfoPage;
import com.crmcast.crm.generic.objectrepositoryutility.CreateContactPage;
import com.crmcast.crm.generic.objectrepositoryutility.HomePage;
import com.crmcast.crm.generic.objectrepositoryutility.LoginPage;


public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib =new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		String LastName = elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
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
		   
		   

		   
		   LoginPage lp=new LoginPage(driver);
		   lp.loginToapp(URL, USERNAME, PASSWORD);
		   
		   HomePage hp=new HomePage(driver);
		   hp.getContactLink().click();
		   
		   ContactPage cp=new ContactPage(driver);
		   cp.getCreatecntbtn().click();
		   
		   CreateContactPage ccp=new CreateContactPage(driver);
		   ccp.getLastNameEdit().sendKeys(LastName);
		   ccp.getSaveContactBtn().click();
		   
		   ContactinfoPage cip=new ContactinfoPage(driver);
		   String header = cip.getHeaderTextVerify().getText();
		   if(header.contains(LastName) )
		   {
				System.out.println(LastName+" contact is created");
			}
			else
			{
				System.out.println(LastName+" contact is not created");
			}

		  
		   
		   String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		   if(actLastName.equals(LastName)) {
			   System.out.println(LastName + " information is verified==PASS");
		   }else {
			   System.out.println(LastName + " information is not verified==FAIL");
		   }
		   
		   hp.logout();
		   
		   driver.quit();

	}

}

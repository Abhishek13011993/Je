package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebDriverUtility;
import com.crmcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.crmcast.crm.generic.objectrepositoryutility.HomePage;
import com.crmcast.crm.generic.objectrepositoryutility.LoginPage;
import com.crmcast.crm.generic.objectrepositoryutility.OrganizationPage;

public class CreateOrgWithPhone {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		
		String orgName =elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		String type=elib.getDataFromExcel("org", 4, 4);
		String industry=elib.getDataFromExcel("org", 4, 3);
		String phone=elib.getDataFromExcel("org", 7, 3);
		
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
		   
		   driver.get(URL);
		   wlib.waitForPageToLoad(driver);
		   
		   LoginPage lp=new LoginPage(driver);
		   lp.loginToapp(URL, USERNAME, PASSWORD);
		   
		   HomePage hp=new HomePage(driver);
		   hp.getOrgLink().click();
		   
		   OrganizationPage op=new OrganizationPage(driver);
		   op.getCreatenewBtn().click();
		    
		   CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		   cnp.getOrgNameEdt().sendKeys(orgName);
		   cnp.getTypeDB().sendKeys(type);
		   cnp.getIndustryDB().sendKeys(industry);
		   cnp.getPhoneedit().sendKeys(phone);
		   cnp.getSaveBtn().click();
		   
		   
		   String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();
		   if(actPhone.equals(phone)) {
			   System.out.println(phone + " information is created==PASS");
		   }else {
			   System.out.println(phone + " information is not created==FAIL");
		   }
		   driver.quit();
		   }

		
	

	}



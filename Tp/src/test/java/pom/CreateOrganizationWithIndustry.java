package pom;

import java.io.IOException;

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
import com.crmcast.crm.generic.objectrepositoryutility.OrganizationInfoPage;
import com.crmcast.crm.generic.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable, IOException {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		String orgName=elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		String type=elib.getDataFromExcel("org", 4, 3);
		String industry=elib.getDataFromExcel("org", 4, 4);
		
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
		   lp.loginToapp(URL,USERNAME, PASSWORD);
		   
		   HomePage hp=new HomePage(driver);
		   hp.getOrgLink().click();
		   
		   OrganizationPage op=new OrganizationPage(driver);
		   op.getCreatenewBtn().click();
		   
		   CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		   cp.getOrgNameEdt().sendKeys(orgName);
		   cp.getIndustryDB().sendKeys(industry);
		   cp.getTypeDB().sendKeys(type);
		   cp.getSaveBtn().click();
		   
		   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		   String actorgName=oip.getHeaderMsg().getText();
		   if(actorgName.contains(orgName)) {
			   System.out.println(orgName+" name is verified ==PASS");
		   }
		   else {
			   System.out.println(orgName+" name is not verified =FAIL");
		   }
		   driver.quit();
		   }
}



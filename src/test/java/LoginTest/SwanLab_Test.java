package LoginTest;

//import org.testng.annotations.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM_DDF_TestNG.SwanLabHomePage;
import Pom_TestNG_completeFramework.SwanLabLogoutpage;
import Pom_TestNG_completeFramework.SwanlabLoginpage;
import libraryfiles.Utilityclass;
import libraryfiles.baseclass;

//import org.testng.annotations.*;
public class SwanLab_Test  extends baseclass{
 //WebDriver driver;
 SwanlabLoginpage login;
 SwanLabHomePage home;
 SwanLabLogoutpage logout;
 int TCID;
	@BeforeClass
   public void enter_url() throws EncryptedDocumentException, IOException
	 {
		initweb();
		login=new SwanlabLoginpage(driver);
		home= new SwanLabHomePage(driver);
		logout=new SwanLabLogoutpage(driver);
	 }
  
			
	

	@BeforeMethod
	public void Login() throws InterruptedException, EncryptedDocumentException, IOException
	{
	login.InputEnterUN(Utilityclass.getTDfmpc("UN"));
	Thread.sleep(1000);
	login.InputEnterPWD(Utilityclass.getTDfmpc("PWD"));
	Thread.sleep(1000);
	login.ClickLOginbutton();
	Thread.sleep(3000);
	}
	@Test
	public void verify() throws EncryptedDocumentException, IOException
	{  TCID=101;
		String expres=Utilityclass.getTD(0, 3);
		String actres= home.verifyResult();
		Assert.assertEquals(actres,expres);
		
	}
	@AfterMethod
	public void logout(ITestResult s1) throws InterruptedException, IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utilityclass.captureSS(driver, TCID);
		}
		 home.clickMenuBtn();
	Thread.sleep(2000);
	    logout.clickLogout();
	    Thread.sleep(2000);
	}
	
		
	

	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
}

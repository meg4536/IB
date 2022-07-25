package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseclsKite;
import BaseClass.utility;
import POMClasses.Homepage_pom;
import POMClasses.Login_pom;
import POMClasses.Pin_Pom;

public class TC03_HomepageShareBtnVerify {
	WebDriver driver;
	BaseclsKite bs;
	 utility ut;
	 String TcID;
	 Homepage_pom h;
	 Login_pom b;
	 Pin_Pom p;
	
	 
	 
  @BeforeClass
	public void launchbrowser() {
		 bs=new BaseclsKite();
		 driver= bs.initDriver();
		   ut = new utility();
			 h=new Homepage_pom(driver);
			 p=new Pin_Pom(driver);
	}
  
  @BeforeMethod
  public void login() throws IOException, InterruptedException {
	  b=new Login_pom(driver);
		 b.inpKiteLogin1PagePassword(utility.readpropertiesfile("pass1"));
		 
		 //enter username
		 b.inpKiteLogin1PageUsername(utility.readpropertiesfile("userid"));
		 
		 //login button clicked
		 b.clickKiteLogin1PageLoginBtn();
		 
		 //redirect to mpin page
		 
		 //enter mpin
        Thread.sleep(3000);
		 p.pinEnter(utility.readpropertiesfile("mpin"));
		 p.Continuebtn();
	
		 
	  
  }
  
  @Test
  public void verifybuttonclickable() throws InterruptedException, IOException {
	  
	  Thread.sleep(3000);
	  h.clickicici();
	  h.buybtn();
	  Thread.sleep(1000);
	  Reporter.log(".......checking Minumum quantity.........");
	  h.quant(utility.readpropertiesfile("quantity"));
	  
	  h.errorbuy("str");
      
  }
  
  //@AfterMethod
 // public void logout() throws IOException, InterruptedException {
	//  if(ITestResult.FAILURE==e.getStatus()){
		//	bs.takescreesnhot(TcID);
			//}
			
//			Thread.sleep(2000);
//			h.cick();
//			Thread.sleep(2000);
//			h.clicklog();
  }

	


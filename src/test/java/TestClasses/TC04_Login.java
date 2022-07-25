package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseclsKite;
import BaseClass.utility;
import POMClasses.Homepage_pom;
import POMClasses.Login_pom;
import POMClasses.Pin_Pom;

public class TC04_Login {
	BaseclsKite bs;
	WebDriver driver;
	 utility ut;
	 Login_pom b;
	 Pin_Pom p;
	 Homepage_pom h;
	 String TcID;
	  
	@BeforeClass /////launch browser
	public void launchbrowser() {
		 bs=new BaseclsKite();
		 driver= bs.initDriver();
		   ut = new utility();
			 p=new Pin_Pom(driver);
			 h=new Homepage_pom(driver);
			 
		   
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		// enter password 
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
	public void tc01() {
		TcID="101";
		System.out.println("tc01 success");
	}

	
	@AfterMethod
	
	public void logout(ITestResult e) throws InterruptedException, IOException {
		if(ITestResult.FAILURE==e.getStatus()){
		bs.takescreesnhot(TcID);
		}
		
		Thread.sleep(2000);
		h.cick();
		Thread.sleep(2000);
		h.clicklog();
		 
	}
}

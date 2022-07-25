package TestClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseclsKite;
import BaseClass.utility;
import POMClasses.Login_pom;


public class TC01_Login {
	//WebDriver driver;
	Login_pom pomclass1;
	String tcID;
	Sheet sh;
	BaseclsKite ab;
	utility ut;

	

	
	@BeforeClass
	public void launchBrow() throws EncryptedDocumentException, IOException {
		// FileInputStream file =new FileInputStream(config.excelsheetpath);
		// sh = WorkbookFactory.create(file).getSheet("Sheet1");

		 ab = new BaseclsKite();
		BaseclsKite.driver = ab.initDriver();
		pomclass1 = new Login_pom(BaseclsKite.driver);
		
		ut = new utility();
		
	}

	@BeforeMethod
	public void refresh() {
		BaseclsKite.driver.navigate().refresh();

	}

	@Test
	public void tc01() throws EncryptedDocumentException, IOException, InterruptedException {
		tcID = "101";
		Thread.sleep(2000);
		pomclass1.inpKiteLogin1PageUsername(ut.readExcelSheet(0, 0));
		Thread.sleep(2000);
		pomclass1.clickKiteLogin1PageLoginBtn();
		String actual = pomclass1.errorpass();
		String Expected = "Password should be minimum 6 characters.";

        	Assert.assertEquals(actual, Expected);

	}
	@Test
	public void tc02() {
		tcID="102";
		pomclass1.inpKiteLogin1PagePassword("1234778");
		pomclass1.clickKiteLogin1PageLoginBtn();
		String actual=pomclass1.erroruname();
		String Expected="User ID should be minimum 6 characters.";
		Assert.assertEquals(actual, Expected);
	
	}
	
	
	@Test
	public void tc03() {
		tcID="103";
		pomclass1.clickKiteLogin1PageLoginBtn();
		String actual=pomclass1.errorpass();
		String Expected="Password should be minimum 6 characters.";
		
		Assert.assertEquals(actual, Expected);
      
		 String actual1=pomclass1.erroruname();
		 String Expected1="User ID should be minimum 6 characters.";
		 Assert.assertEquals(actual1, Expected1);
		 
		
	}
// @AfterMethod
// public void logout(ITestResult e) throws IOException {
//	 if(ITestResult.FAILURE==e.getStatus()) {
//	 ab.takescreesnhot(tcID);
//	 }
//	
 }


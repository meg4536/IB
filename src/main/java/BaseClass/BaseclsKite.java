package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import Configuration.config;

public class BaseclsKite {
	public static WebDriver driver;
	public WebDriver initDriver() {
	System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
	
	 driver=new ChromeDriver();
	  driver.get("https://kite.zerodha.com/");
	  driver.manage().window().maximize();
	return driver;
	
	

}
	public void takescreesnhot(String tcID) throws IOException {
	     
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Date d=new Date();
		String str = d.toString();
		
		str=str.replace(" ", "_");
		str=str.replaceAll(":","_");
		System.out.println(str);
				
				File Dest=new File(config.screenshotpath+tcID+str+".jpeg" );
		FileHandler.copy(src, Dest);
}
}
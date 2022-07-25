package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pin_Pom {
       @FindBy(xpath="//input[@type='password']") private WebElement passpin;
       @FindBy(xpath= "//button[@type='submit']") private WebElement btnpin;


   public Pin_Pom ( WebDriver driver) {
	   
	PageFactory.initElements(driver, this);   
   }

 public void pinEnter(String str) {
	 passpin.sendKeys(str);
 }

 public void Continuebtn () {
	 btnpin.click();
 }
 
}

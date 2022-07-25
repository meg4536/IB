package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_pom {
	@FindBy(xpath ="//div[@class='avatar']")private WebElement btnforlog;
	@FindBy(xpath= "//a[@target='_self']")private WebElement btnlog ;
	@FindBy(xpath= "(//span[text()='ICICIBANK'])[1]")private WebElement clkicici;
	@FindBy(xpath= "(//button[@type='button'])[1]")private WebElement buybtn;
	@FindBy(xpath= "//button[@class='button-orange sell']")private WebElement sellbtn;
	@FindBy(xpath=  "(//button[@class='button-outline'])[1]")private WebElement marketdepthbtn;
	@FindBy(xpath= "(//button[@class='button-outline'])[2]")private WebElement chartbtn;
	@FindBy(xpath= "//button[@class='context-menu-button button-outline']")private WebElement morebtn;
    @FindBy(xpath= "(//input[@type='number'])[1]")private WebElement  quantity;
    @FindBy(xpath= "//div[contains(text(),'NSE is disabled for your account. You can activate the segment on ')]")private WebElement errormsgbuy;

   public Homepage_pom(WebDriver driver){
	  
	PageFactory.initElements(driver, this);
	
}
	
   public void cick() {
	   btnforlog.click();
   }
   public void clicklog() {
	  btnlog.click();
  }   
   public void clickicici() {
	   clkicici.click();
   }
   public void buybtn() {
	  buybtn.click();
   }
   public void clicksellbtn() {
	   sellbtn.click();
   }
   public void clickmarketdepthbtn() {
	  marketdepthbtn.click();
   }
   public void clickchartbtn() {
	   chartbtn.click();
   }
   
   public void clickmorebtn() {
	   morebtn.click();
   }
   public void quant(String st) {
	   quantity.sendKeys(st);
   }
  public void errorbuy(String str) {
	  errormsgbuy.getText();
  }
    

}

package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_pom {
	@FindBy(xpath = "//input[@id='userid']") private WebElement UN; 	//private WebElement UN = driver.findelement(By.xpath(""))
	@FindBy(xpath = "//input[@id='password']") private WebElement pwd; 	//private WebElement UN = driver.findelement(By.xpath(""))
	@FindBy(xpath = "//button[@class='button-orange wide']") private WebElement loginBtn; //private WebElement UN = driver.findelement(By.xpath(""))

	@FindBy(xpath = "//span[contains(text(),'Password should')]") private WebElement errorMsgPWD;
	@FindBy(xpath = "//span[contains(text(),'User ID')]") private WebElement errorMsgUN;
	

	
	// step2: initialization
	public Login_pom(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// usage
	public void inpKiteLogin1PageUsername(String username) {

		UN.sendKeys(username);
	}

	public void inpKiteLogin1PagePassword(String passwords) {
		pwd.sendKeys(passwords);
	}

	public void clickKiteLogin1PageLoginBtn() {
		loginBtn.click();
	}

	public String errorpass() {
		String actText = errorMsgPWD.getText();
		return actText;
	}

	public String erroruname() {
		String actText = errorMsgUN.getText();
		return actText;
	}

}



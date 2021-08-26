package POM_Filpkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public WebDriver driver;
	@FindBy(xpath="(//input[@type=\"text\"])[2]")
	private WebElement inputTest;
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement password;
	@FindBy(xpath="(//span[.='Login'])[3]")
	private WebElement loginbutton;
	@FindBy(xpath="//div[@class=\"exehdJ\"]")
	private WebElement login;
	@FindBy(xpath="//div[.='Logout']")
	private WebElement logout;
	
	public  Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public  void username(String user) {
		inputTest.clear();
		inputTest.sendKeys(user);
		
	}
	public void password(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	public void loginbutton() {
		loginbutton.click();
	}
	public void login() {
		JavascriptExecutor js	=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login);
	}
	public void logout() {
		logout.click();
	}

}

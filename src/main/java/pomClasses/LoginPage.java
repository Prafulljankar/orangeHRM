package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	//private variable of Webelement
	
	//@FindBy()
	
	@FindBy(name="username")
	private WebElement usernameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	
	//constructor to initialize webelement
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//public methods to perform action on webelement

	public void enterUsername(String username)
	{
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) 
	{
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() 
	{
		loginButton.click();
	}

}

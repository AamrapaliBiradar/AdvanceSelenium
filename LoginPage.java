package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver d;

	// identify username
	@FindBy(name = "user_name")
	private WebElement Usernametf;

	// identify password
	@FindBy(name = "user_password")
	private WebElement Passwordtf;

	// click on login
	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametf() {
		return Usernametf;
	}

	public WebElement getPasswordtf() {
		return Passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	// create a constructor-initialize webelements
	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);

	}

	// create a method--(to perform the action)
	public HomePage Login(String usernamedata, String passworddata) {
		Usernametf.sendKeys(usernamedata);
		Passwordtf.sendKeys(passworddata);
		loginbtn.click();
		return new HomePage(d);
	}
}

package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil {
	public WebDriver d;
	// Identify organization
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement Organizationtf;

	// identify contact
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacttf;

	// identify image
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement imagetf;

	// identify signout
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signouttf;

	public WebElement getOrganizationtf() {
		return Organizationtf;
	}

	public WebElement getContacttf() {
		return contacttf;
	}

	public WebElement getImagetf() {
		return imagetf;
	}

	public WebElement getSignouttf() {
		return signouttf;
	}

	// create a constructor
	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	// create a method
	public OrganizationsPage Home() {
		// click on organizations
		Organizationtf.click();
		return new OrganizationsPage(d);
	}

	public LoginPage Home(WebDriver d) {

		// MouseHover on image
		mousehover(d, imagetf);
		// click on signout btn
		signouttf.click();
		return new LoginPage(d);

	}
}

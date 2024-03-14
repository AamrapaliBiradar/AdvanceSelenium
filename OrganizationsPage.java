package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	public WebDriver d;
 //identify create organization..(+)
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganization;

	public WebElement getCreateOrganization() {
		return createOrganization;
	}
	
	//create a constructor
	public OrganizationsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	//create a method
	public OrganizationInformationPage Organizations() {
		//click on create organization..(+)
		createOrganization.click();
		return new OrganizationInformationPage(d);
	}
}

package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class OrganizationInformationPage {
	public WebDriver d;
	WebDriverUtil wutil = new WebDriverUtil();
	// identify organization name
	@FindBy(name = "accountname")
	private WebElement organizationnametf;

	// identify group radio button
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;

	// identify the dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	// identify save button
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}

//create a constructor
	public OrganizationInformationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

//create  a method
	public HomePage OrganizationInformation(String Orgnamedata, String groupdata) {

		// to enter organization name
		organizationnametf.sendKeys(Orgnamedata);
		// click on group radio button
		groupbtn.click();
		// select support group in the dropdown
		wutil.handledropdown(dropdown, groupdata);
		// click on save button
		savebtn.click();
		return new HomePage(d);

	}

}

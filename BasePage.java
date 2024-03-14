package BasicPom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import Pom.HomePage;
import Pom.LoginPage;
import Pom.OrganizationInformationPage;
import Pom.OrganizationsPage;

public class BasePage {

	public static WebDriver d;

	public static void main(String[] args) throws InterruptedException, IOException {

		// create object of propertyfileutil
		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		JavaUtil jutil = new JavaUtil();

		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		String URL = putil.getDataFromPropertyFile("Url");

		// to read data from excel file
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);

		// to launch the browser
		if (BROWSER.equals("Chrome")) {
			d = new ChromeDriver();
		} else if (BROWSER.equals("Edge")) {
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}

		// WebDriver d=new ChromeDriver();

		// to maximize the browser window
		d.manage().window().maximize();
		// to launch the browser
		// d.get("http://localhost:8888/");
		d.get(URL);

		// Create object of LoginPage
		LoginPage lp = new LoginPage(d);
		// login to the application
		lp.Login(USERNAME, PASSWORD);

		// to intitialize webelements
		// PageFactory.initElements(d, lp);

		// create object of Homepage
		HomePage hp = new HomePage(d);

		// click on organizations

		hp.Home();

		// create object of organizationspage
		OrganizationsPage op = new OrganizationsPage(d);
		// click on create organization...(+)
		op.Organizations();

		// create object of OrganizationInformationPage
		OrganizationInformationPage oip = new OrganizationInformationPage(d);
		// to enter organization name
		oip.OrganizationInformation(ORGNAME + jutil.getRandomNumber(), GROUP);

		Thread.sleep(2000);
		hp.Home(d);

		// select support group in the dropdown
		// wutil.handledropdown(oip.getDropdown(), GROUP);

		// MouseHover on image
		// wutil.mouseHover(d, hp.getImagetf());
//		
//		//click on signout button

//		

	}

}

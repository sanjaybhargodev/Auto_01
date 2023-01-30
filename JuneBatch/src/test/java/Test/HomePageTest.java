package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.SearchPageProductsPageObjects;
import utils.CommonUtility;

public class HomePageTest {
	WebDriver driver;
	HomePageObjects hpo;
	SearchPageProductsPageObjects sppo;
	CommonUtility cu= new CommonUtility();
	
	@BeforeSuite
	@Parameters({"browser", "url"})
	void initSetup(String browser, String url) 
	{
		driver = cu.initSetup(browser);
		cu.lanuchURL(url);
	}
	@BeforeTest
	@Parameters("url")
	void lanuchURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@BeforeClass
	void initObjs() 
	{
		hpo = new HomePageObjects(driver);
		sppo= new SearchPageProductsPageObjects(driver);
	}
	@Test (priority=1)
	void urlTest() 
	{
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://medisolve.co.in/", "urlTest Successful");
	}
	
	@Test(priority=2)
	void logoTest() 
	{
		
		boolean actualLogo  = hpo.isLogoPresent();
		Assert.assertTrue(actualLogo, "Logo Test is Successful");
	}
	@Test (priority=3)
	void searchFieldTest()
	{
		boolean SearchBarFlag = hpo.isSearchBarPresent();
		Assert.assertTrue(SearchBarFlag, "Search Field is Displaying on Home Page");
		hpo.setSearchBarField("Blood Pressure");
		Assert.assertTrue(hpo.SearchIconPresent(), "SearchIcon is present");
		hpo.clickSerachIcon();
		sppo.validateHeaderPage("Searched Products");
		sppo.clickFirstProduct();
	}
	
//	@AfterClass
//	void closeBrowser()
//	{
//		driver.close();
//	 }


}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
WebDriver driver;
	
	@FindBy (xpath = "//div[@class='logo']/a/img")
	private WebElement logo;
	
	@FindBy (xpath ="//span[@id='x']")
	private WebElement closeBtnOnIntroPopUp;
	
	@FindBy (xpath ="//input[@id='key']")
	private WebElement SearchBar;
	
	@FindBy (xpath="//button/i[@class='ion-ios-search-strong']")
	private WebElement SearchIcon;
	
    public HomePageObjects(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    
    public boolean isLogoPresent() 
    { 
      boolean logoFlag = logo.isDisplayed();
      return logoFlag;
    }
    public void clickOnLogo() 
    {
    	logo.click();
    }
      public void closeIntroPopUp() 
    {
    	if (closeBtnOnIntroPopUp.isDisplayed()) 
    	{
    		closeBtnOnIntroPopUp.click();
    	}
    	else 
    	{
    		System.out.println("CloseIntroPop is not Displaying");
    	}
    }
    public boolean isSearchBarPresent() 
    {
    	boolean searchBarFlag = SearchBar.isDisplayed();
    	return searchBarFlag;
    }
    public void setSearchBarField(String input) 
    {
      SearchBar.sendKeys(input);
    }
    public boolean SearchIconPresent()
    {
    	boolean SearchIconFlag = SearchIcon.isDisplayed();
    	return SearchIconFlag;
    	
    }
    public void clickSerachIcon()
    {
    	SearchIcon.click();
    }
    

}

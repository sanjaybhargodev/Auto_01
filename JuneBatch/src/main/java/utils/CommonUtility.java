package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonUtility {
	
   WebDriver driver = null;
	public WebDriver initSetup(String browser) 
	{
		if (browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanju\\Desktop\\JAVA\\chromedriver.exe ");
		 driver = new ChromeDriver();
	}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Sanju\\Desktop\\JAVA\\msedgedriver.exe");
			driver = new EdgeDriver();
	}
		return driver;
	}
	

	public void lanuchURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	}
	
	

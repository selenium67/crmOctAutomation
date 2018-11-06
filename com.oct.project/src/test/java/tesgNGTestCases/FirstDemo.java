package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstDemo {
	
	WebDriver driver;
	
 
	  @Test(priority=0)
		public void openBrowser() {
			
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.freecrm.com/index.html?e=2");
		}  
}

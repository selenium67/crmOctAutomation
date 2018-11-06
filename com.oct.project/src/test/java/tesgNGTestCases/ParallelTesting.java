package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting {
	
	WebDriver driver;
	
	@Test(priority=0)
	@Parameters("browserName")
	public void openBrowser(String browser) {
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriverwin/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void openUrl() {
		driver.get("https://www.freecrm.com/index.html?e=2");
	}

}

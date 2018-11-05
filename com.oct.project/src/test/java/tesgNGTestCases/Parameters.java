package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parameters {
	
	WebDriver driver;
	
	@Test(priority=0)
	@org.testng.annotations.Parameters({"selectBrowser"})
	public void openBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriverwin/chromedriver.exe");
			driver = new ChromeDriver();
			
		}else {
			
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void openUrl() {
		driver.get("https://www.freecrm.com/index.html?e=2");
	}
	
	
	@Test(priority=2)
	@org.testng.annotations.Parameters({"userName","pass"})
	public void login(String userName,String password) throws Exception {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);;
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

}

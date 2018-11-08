package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginCRM {

	WebDriver driver;

	@Test
	public void login() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			System.setProperty("webdriver.chrome.driver", 
					"./lib/chromedriverwin/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://freecrm.com/index.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//WebElement userName = driver.findElement(By.xpath("//input[@placeholder ='Username']"));
			
			try {
				// Enter data in text field using java script
				js.executeScript("document.getElementsByName('username')[0].value='sampathkk';");
			} catch (Exception e) {
				e.printStackTrace();
			}		
			//driver.findElement(By.xpath("//input[@placeholder ='Username']")).sendKeys("sampathkk");
			
			driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("123456");
			Thread.sleep(3000);
			WebElement login = driver.findElement(By.xpath("//input[@value ='Login']"));
			// click on webelement using java script
			js.executeScript("arguments[0].click();", login);
			
			login.click();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

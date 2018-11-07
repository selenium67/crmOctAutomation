package sampath;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DocsTestCase {
	
	WebDriver driver;
	
	
	@Test 

		
		public void FreeCRMLogin() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HP\\\\Desktop\\\\downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder ='Username']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name ='password']"));
		
		username.sendKeys("sampathkk");
		Password.sendKeys("123456");
		WebElement login = driver.findElement(By.xpath("//input[@value ='Login']"));
		login.click();
		}
	@Test	
	
		public void SwitchToFrame() throws Exception {
		
			Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='mainpanel']")));
			
 
		WebElement doc = driver.findElement(By.xpath("//a[@title='Docs']"));
		Actions a = new Actions(driver);
		a.moveToElement(doc).perform();
		
	driver.findElement(By.xpath("//a[@title='New Document']")).click();
	driver.findElement(By.xpath("//input[@id='title']")).sendKeys("New Document testing");
	driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("text message : Starting ChromeDriver 2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e) on port 32507");
	driver.findElement(By.xpath("//input[@id='version']")).sendKeys("v1.0.1");
	driver.findElement(By.xpath("//input[@type='file']")).click();
	
	//(.exe file build using autoit )is execution it is purely a java command
	
	Runtime.getRuntime().exec("C:\\Users\\HP\\Desktop\\Selenium software files\\autoit\\Docs.exe");

	
	driver.findElement(By.xpath("//form[@id='docForm']/table/tbody/tr[14]/td[2]/input")).click();
	
		
}	
}
				
				







package sampath;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CustomViews {
	
	WebDriver driver;
	
	
	@Test 
	public void FreeCRMLogin() throws Exception {
	
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
	
		Thread.sleep(3000);
	
	driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='mainpanel']")));
		

	WebElement customview = driver.findElement(By.xpath("//a[@title='Custom Views']"));
	customview.click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value='New View']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Creating a new Custom View record");
	
	Select s = new Select(driver.findElement(By.xpath("//select[@name='available_fields']")));
	

	s.selectByValue("first_name|surname");
	s.selectByVisibleText("First Name");
	s.selectByValue("surname");
	s.selectByValue("phone");
	s.selectByVisibleText("Email");
	s.selectByVisibleText("Birthday");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value=' - ADD ->']")).click();

}
		
		
	}

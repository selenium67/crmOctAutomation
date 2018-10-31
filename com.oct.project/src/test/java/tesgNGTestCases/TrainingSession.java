package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TrainingSession {
	
	
WebDriver driver =null;
	
	
	@Test()	
	public void OpenBrowser () throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HP\\\\Desktop\\\\downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://github.com/");
		
		NewUserRegistration();
		
	}

	private void NewUserRegistration() throws Exception {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//header[@role='banner']/div/div[2]/div/span/div/a[2]")).click();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("kancham27");
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("kk0227sampath@gmail.com");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("lkjhgfdsamnbvcxz@123");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='signup_button']")).click();
		
	}


}

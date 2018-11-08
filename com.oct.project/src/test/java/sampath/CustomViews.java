package sampath;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.freecrm.webpages.LoginPOM;

public class CustomViews {

	public Properties getRepositoryData() {
		
		Properties prop = null;
		try {
			File src = new File("./src/main/resources/Objects.properties");
			FileInputStream fin = new FileInputStream(src);
			prop = new Properties();
			prop.load(fin);
			
		} catch (Exception e) {
			e.printStackTrace();		
	}
		return prop;
	
	}	
	WebDriver driver;

	@Test
	public void FreeCRMLogin() throws Exception {

		/*
		 * Path of the File Read the File Create an for Properties Load the file into
		 * properties
		 */

		System.setProperty(getRepositoryData().getProperty("CHROMEKEY"), getRepositoryData().getProperty("CHROMEVALUE"));
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		LoginPOM login = PageFactory.initElements(driver, LoginPOM.class);
		login.username.sendKeys("sampathkk");
		login.password.sendKeys("123456");
		login.getLogin().click();
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.xpath(getRepositoryData().getProperty("FREECRM.FRAME"))));
		WebElement customview = driver.findElement(By.xpath(getRepositoryData().getProperty("customview")));
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
		driver.findElement(By.xpath("//form[@name='viewGenForm']/table/tbody/tr[4]/td/input")).click();

	}

}

package sampath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OrangeHRM {

	static WebDriver driver;

	@Test
	
	public static void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		
	/*	Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"))).build().perform();
	    a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"))).click().build().perform(); 
		*/
	
	Actions a= new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"))).click().build().perform();
		
		Thread.sleep(2000);
		//WebElement add = driver.findElement(By.xpath("//input[@value='Add']"));
		
		//WebElement add = driver.findElement(By.xpath("(//input[@type='button'])[5]"));
		
		//driver.findElement(By.xpath("//div[@id='customerList']/div/div/form/div/input[1]")).click();
		
		//driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		
		//driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.name("btnAdd")).click();
		
		//add.click();
	
	}
}

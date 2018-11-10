package sampath;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrangeHRM {

	public static Properties getRepositoryData() {

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

	static WebDriver driver;

	@Test
	public static void Login() throws Exception {

		System.setProperty(getRepositoryData().getProperty("CHROMEKEY"),
				getRepositoryData().getProperty("CHROMEVALUE"));
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"))).click().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		new Select(driver.findElement(By.id("systemUser_userType"))).selectByVisibleText("Admin");
		WebElement empName = driver.findElement(By.id("systemUser_employeeName_empName"));
		empName.sendKeys("Joh");
		empName.sendKeys(Keys.ENTER);
		driver.findElement(By.id("systemUser_userName")).sendKeys("Sampath123");
		driver.findElement(By.id("systemUser_password")).sendKeys("Test@123");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Save']")).click();

	}
}

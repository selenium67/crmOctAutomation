package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewCompany {

	WebDriver driver = null;
	
	@BeforeSuite
	public void queOne() {
		
		System.out.println("This Method will execute first @beforeSuite");
		System.out.println();
	}
	
	@BeforeTest
	public void queTwo() {
		
		System.out.println("This Method will execute Second @BeforeTest");
	}
	
	
	@AfterSuite
	public void last() {
		
		System.out.println("This Method will execute last");
	}
	
	
	@AfterTest
	public void aTest() {
		
		System.out.println("This Method will execute before @AfterClass i.e @AfterTest");
	}
	
	@BeforeClass
	public void initBrowser() {
		
		openBrowser();
	}
	
	@BeforeMethod
	@Parameters({"user","pass"})
	public void init(String userName, String passWord) throws Exception {
			
		openUrl();
		login(userName,passWord);		
	}
	
	@Test(priority=0,description = "Creating a New Company in FRM Which is available in Companies Menu")
	public void createNew() throws Exception {
		
		switchToMenu("Companies");
		driver.findElement(By.xpath("//a[@title='New Company']")).click();
		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("New LTD Company");
		new Select(driver.findElement(By.xpath("//select[@name='status']"))).selectByVisibleText("On Hold");
		driver.findElement(By.xpath("//textarea[@id='service']")).sendKeys("Hello Service");
		driver.findElement(By.xpath("//input[@value='Max']/following::input")).click();
	}
	
	@Test(priority=1,description="Yet to Implement")
	public void combinedForm() {
		switchToMenu("Deals");
		System.out.println("Please Complete this test case");
	}
	
	@AfterMethod
	public void tearDown() {
		logout();
		
	}
	
	@AfterClass
	public void closeSession() {
		
		driver.close();
	}

	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "./lib/chromedriverwin/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void openUrl() {
		driver.get("https://www.freecrm.com/index.html?e=2");
	}

	
	public void login(String user,String pass) throws Exception {

		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(3000);
		login.click();
	}

	public void switchToMenu(String name) {
		// Naviagated to Top Menu Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='mainpanel']")));
		WebElement menuName = driver.findElement(By.xpath("//a[@title='"+name+"']"));
		Actions action = new Actions(driver);
		// MouseHover to a particular webelement
		action.moveToElement(menuName).build().perform();
	}
	
	public void logout() {
		
		driver.findElement(By.xpath("(//a[@class='topnavlink'])[3]")).click();
	}

}

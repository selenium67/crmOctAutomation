package tesgNGTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test

public class TestDemo {
	{
	
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.osmania.ac.in");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		
		
		
		//WebElement footer = driver.findElement(By.xpath("//section[@id='yt_spotlight8'"));
	
		
		//System.out.println(footer.findElements(By.tagName("a")).size());
		
		
		
		
		
	
	}
}

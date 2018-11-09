package tesgNGTestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.freecrm.webpages.LoginPOM;

import sampath.CustomViews;

public class FindElementsPractice extends CustomViews {

	@Test
	public void getElements() {

		try {
			System.setProperty(getRepositoryData().getProperty("CHROMEKEY"),
					getRepositoryData().getProperty("CHROMEVALUE"));
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
			
			Actions action = new Actions(driver);
			
			action.moveToElement(driver.findElement(By.xpath("//a[@title='Campaigns']"))).build().perform();
			
			List<WebElement> campaigns = driver.findElements(By.xpath("//a[@title='Campaigns']/../ul/li"));
			/* Suresh - suresh
			 * 
			 */
			for (WebElement ele : campaigns) {
				
				System.out.println(ele.getText());
				
				if (ele.getText().equalsIgnoreCase("Print Campaigns")) {
					
					ele.click();
					break;
				}
				
			}
			driver.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}

package tesgNGTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.freecrm.webpages.LoginPOM;

import sampath.CustomViews;

public class Blogs extends CustomViews {

	public Properties prop = null;

	public void getRepo() {
		try {
			File src = new File("./src/main/resources/Objects.properties");
			FileInputStream fin = new FileInputStream(src);
			prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getBlog() {

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

			driver.findElement(By.xpath("//a[@title='Blog']")).click();

			/*
			 * ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
			 * 
			 * driver.switchTo().window(tab.get(1));
			 */
			String parent = driver.getWindowHandle();

			Set<String> tabs = driver.getWindowHandles();

			Iterator<String> ite = tabs.iterator();

			while (ite.hasNext()) {

				String child = ite.next();

				if (!child.equals(parent)) {

					driver.switchTo().window(child);

					List<WebElement> blogs = driver.findElements(By.xpath("//div[@id='post-listing']/article/h3/a"));

					for (WebElement ele : blogs) {

						System.out.println(ele.getText());

						if (ele.getText().equalsIgnoreCase("Managing the Customer Experience")) {

							ele.click();
							break;
						}
					}
					driver.close();
				}
			}
			
			driver.switchTo().window(parent);
			driver.switchTo().frame(driver.findElement(By.xpath(getRepositoryData().getProperty("FREECRM.FRAME"))));
			driver.findElement(By.xpath("//a[@title='Knowledge Base']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

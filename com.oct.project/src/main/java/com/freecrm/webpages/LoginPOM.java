package com.freecrm.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPOM {
	
	
	@FindBy(xpath="//input[@placeholder ='Username']")
	public WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@name ='password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@value ='Login']")
	private WebElement login;
	
	public WebElement getLogin() {
		
		return login;
	}
	

}

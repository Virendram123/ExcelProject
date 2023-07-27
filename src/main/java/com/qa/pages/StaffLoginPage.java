package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import com.qa.base.Base;

public class StaffLoginPage extends Base {
	WebDriver d;

	public StaffLoginPage(WebDriver d) {
		this.d = d;
	}

	@FindBy(how = How.NAME, using = "userId")
	@CacheLookup
	private WebElement username;
	@FindBy(how = How.NAME, using = "userPassword")
	@CacheLookup
	private WebElement password;

	
	public void staffLogin(String uname, String upassword) throws Throwable {
		username.sendKeys(uname);
		password.sendKeys(upassword);
		
	}

}

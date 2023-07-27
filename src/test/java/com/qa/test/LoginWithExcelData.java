package com.qa.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.Base;
import com.qa.pages.StaffLoginPage;

public class LoginWithExcelData extends Base {
	
	@BeforeTest
	public void setUp() throws Throwable
	{
		Base b = new Base();
		b.loadConfig();
	}
	
	@Test(dataProvider="getData")
	public void staffLoginCredential(String uname,String upwd) throws Throwable
	{
		StaffLoginPage s= PageFactory.initElements(d, StaffLoginPage.class);
		s.staffLogin(uname,upwd);
	}
	
	@AfterTest
	public void tearDown()
	{
		d.close();
	}
	

}

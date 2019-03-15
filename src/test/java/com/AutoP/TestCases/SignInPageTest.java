package com.AutoP.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutoP.Pages.HomePage;
import com.AutoP.Pages.SignInPage;
import com.AutoP.baseclass.TestBaseClass;

public class SignInPageTest extends TestBaseClass {
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initbrowser();
		homepage = new HomePage();
		signinpage = new SignInPage();
		homepage.ClickOnSignIn();
	}
	
	
	@Test
	public void LoginFuncTest() {
		signinpage.loginFunc();
		Assert.assertEquals(SignInPage.actitle,	 "My account - My Store");
	}
		
	@Test
	public void regfunctiontestforself() throws Exception {
		String Em = prop.getProperty("email");
		signinpage.RegFuncForSelf(Em);
		Assert.assertEquals(SignInPage.retitle, "	Authentication");
				
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.AutoP.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutoP.Pages.HomePage;
import com.AutoP.baseclass.TestBaseClass;

public class HomePageTest extends TestBaseClass {

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initbrowser();
		homepage = new HomePage();
		
	}
	
	@Test(priority = 1)
	public void ValidateMyStoreLogoTest() {
		boolean b= homepage.validateMyStoreLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority = 2)
	public void ValidateMyCartLinkTest() {
		boolean b = homepage.validateMyCartLink();
		Assert.assertTrue(b);
	}
	
	@Test(priority = 3)
	public void SearchForItemTest() {
		homepage.searchForItem();
		Assert.assertEquals(HomePage.stitle, "Search - My Store");
	}
	
	@Test(priority = 4)
	public void signInPageNavigationTest() {
		homepage.ClickOnSignIn();
		Assert.assertEquals(HomePage.ltitle, "Login - My Store");
		
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
		
	
	
	
	
}

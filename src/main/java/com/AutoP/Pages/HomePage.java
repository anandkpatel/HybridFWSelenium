package com.AutoP.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutoP.baseclass.TestBaseClass;

public class HomePage extends TestBaseClass {
	
	public static String stitle; 
	public static String ltitle; 
	
	
	@FindBy(xpath = "//img[@class = 'logo img-responsive']")
	WebElement mystorelogo;
	
	
	@FindBy(xpath = "//a[@title = 'View my shopping cart']")
	WebElement mycart;
	
	@FindBy(name = "search_query")
	WebElement searchbar;
	
	@FindBy(name = "submit_search")
	WebElement searchbtn;
	
	@FindBy(xpath = "//a[@class ='login']")
	WebElement signbtn;
	
	@FindBy(xpath = "//h1[@class='page-heading  product-listing']") 
	WebElement pageHeading;
	
	// initializing the page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateMyStoreLogo() {
		return mystorelogo.isDisplayed();
		
	}
	
	public boolean validateMyCartLink() {
		return mycart.isDisplayed();
	}
	
	public SearchPage searchForItem() {
		searchbar.sendKeys("dress");
		searchbtn.click();
		stitle = driver.getTitle();
		return new SearchPage();
	}
	
	public SignInPage ClickOnSignIn() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", signbtn);
    	signbtn.click();
		ltitle = driver.getTitle();
		return new SignInPage();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


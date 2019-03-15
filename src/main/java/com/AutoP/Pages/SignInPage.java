package com.AutoP.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutoP.baseclass.TestBaseClass;

public class SignInPage extends TestBaseClass {
	public static String actitle;
	public static String retitle;
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitbtn;
	
	@FindBy(id = "email_create")
	WebElement createEmail;
	
	@FindBy(id = "SubmitCreate")
	WebElement createSubmitBtn;
	
	//@FindBy(xpath = "//h1[@class='page-heading']")
	//WebElement regheading;
	
	@FindBy(xpath= "//span[@class = 'navigation_page']")
	WebElement regpageheadong;
	
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}


	public MyAccountPage loginFunc() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		submitbtn.click();
		actitle = driver.getTitle();
		return new MyAccountPage();
	}
	
	
	public RegPage RegFuncForSelf(String em) throws Exception {
		
		createEmail.sendKeys(em);
		Thread.sleep(1000);
		createSubmitBtn.click();
		retitle = regpageheadong.getText();
		return new RegPage();
		
		
		
	}



	public RegPage RegFunc(String NewEmail) {
		
		createEmail.sendKeys(NewEmail);
		createSubmitBtn.click();
		return new RegPage();
		




	}



}

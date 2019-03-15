package com.AutoP.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutoP.baseclass.TestBaseClass;

public class RegPage extends TestBaseClass {

	
		
	@FindBy(id="customer_firstname")
	WebElement cu_firstname;
	
	@FindBy(id="customer_lastname")
	WebElement cu_lastname;
	
	@FindBy(id="email")
	WebElement email_1;

	@FindBy(id="passwd")
	WebElement pass_word;
	
	@FindBy(id="firstname")
	WebElement ad_firstname;
	
	@FindBy(id="lastname")
	WebElement ad_lastname;
	
	@FindBy(id="address1")
	WebElement address_1;
	
	
	@FindBy(id="city")
	WebElement city_1;
	
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state_1;
	
	@FindBy(id="postcode")
	WebElement postal_code;
	
	@FindBy(id="phone_mobile")
	WebElement phonenum;
	
	@FindBy(id="submitAccount")
	WebElement submitbtn;
	
	@FindBy(xpath = "//span[@class = 'navigation_page']")
	WebElement Myaccpageheading;
	 
	public RegPage() {
		PageFactory.initElements(driver, this);
	}
	
	public RegPage creatAccount(String NewEmail, String firstname, String lastname,  String password, String address, String city, String state, String postalcode, String phoneNumber) throws InterruptedException {
		signinpage.RegFunc(NewEmail);
		cu_firstname.sendKeys(firstname);
		cu_lastname.sendKeys(lastname);
	
		pass_word.sendKeys(password);
		address_1.sendKeys(address);
		city_1.sendKeys(city);
		Select se = new Select(state_1);
		se.selectByVisibleText(state);
		postal_code.sendKeys(postalcode);
		phonenum.sendKeys(phoneNumber);
		submitbtn.click();
		Thread.sleep(2000);
		myaccpage = Myaccpageheading.getText();
		return new RegPage();
	
	
	}
	
	

}

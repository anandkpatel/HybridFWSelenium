
package com.AutoP.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AutoP.Pages.HomePage;
import com.AutoP.Pages.RegPage;
import com.AutoP.Pages.SignInPage;
import com.AutoP.Utility.TestUtil;
import com.AutoP.Utility.XlUtils;
import com.AutoP.baseclass.TestBaseClass;

public class RegPageTest extends TestBaseClass {
	
	
	
	public RegPageTest(){
		super();
	}
	

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initbrowser();
		homepage = new HomePage();
		testutil = new TestUtil();
		signinpage = new SignInPage();
		TestUtil.runTimeInfo("error", "login successful");
		homepage.ClickOnSignIn();
		regpage = new RegPage();
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="C:\\Users\\Anand\\eclipse\\java_code\\AutomationSitePracticeTesting\\src\\main\\java\\com\\AutoP\\testdata\\DataAutoPractice.xlsx";
		
		int rowno=XlUtils.getRowCount(path, "DataAuto");
		int colcount=XlUtils.getCellCount(path,"DataAuto",1);
		System.out.println(rowno);
		System.out.println(colcount);
		String logindata[][]=new String[rowno][colcount];
		
		for(int i=1;i<=rowno;i++)
		{
			for(int j=0;j<colcount;j++) 
			{
			 logindata[i-1][j]=XlUtils.getCellData(path,"DataAuto", i,j);//1 0
			}
				
		}
	return logindata;
	}
	@Test(dataProvider= "LoginData")
	public void CreateUserTest(String NewEmail, String firstname, String lastname, String password, String address, String city, String state, String postalcode, String phoneNumber) throws InterruptedException {
		
		regpage.creatAccount(NewEmail, firstname, lastname,  password, 
				address, city, state, postalcode, phoneNumber);
		Assert.assertEquals(RegPage.myaccpage,	 "My account");
		
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void TearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	


















}

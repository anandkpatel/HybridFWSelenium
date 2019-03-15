package com.AutoP.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.AutoP.Pages.HomePage;
import com.AutoP.Pages.MyAccountPage;
import com.AutoP.Pages.RegPage;
import com.AutoP.Pages.SearchPage;
import com.AutoP.Pages.SignInPage;
import com.AutoP.Utility.TestUtil;
import com.AutoP.Utility.WebEventListener;


public class TestBaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static HomePage homepage;
	public static RegPage regpage;
	public static SignInPage signinpage;
	public static String sheetName = "Sheet1";
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static TestUtil testutil;
	public static String retitle;
	public static String myaccpage;
	
	public TestBaseClass() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Anand\\eclipse\\java_code\\AutomationSitePracticeTesting\\src\\main\\java\\com\\AutoP\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initbrowser() {
		String browsername = prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver= new ChromeDriver();
			}
		else if (browsername=="firefox") {
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
			
		
	}
		
		
		
		
	}
	
	
	
	


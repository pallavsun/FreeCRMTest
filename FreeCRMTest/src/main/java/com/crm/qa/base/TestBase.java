package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    
    //Hello
	public TestBase(){
		
		try
		{
		  prop=new Properties();
		  FileInputStream ip=new FileInputStream("C:\\Users\\Lenovo\\git\\FreeCRMTest\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		  prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initalization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.endsWith("chrome"))
		{
			
			
//		WebDriverManager.chromedriver().setup();
			
	//========= Set the Path of Chrome driver================		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\Project\\Driver\\chromedriver.exe");
	
//=========Set the path of Chrome Browser==============	
			ChromeOptions co = new ChromeOptions();
			co.setBinary("C:\\software\\Chrome\\chrome.exe");
			
		   driver=new ChromeDriver(co);
		}
		
		else if(browserName.endsWith("FF"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new FirefoxDriver();
		}
		
		
	//=========================WebEventListener===================================
		
		e_driver=new EventFiringWebDriver(driver);
	// Now create object of EventListener to register it with EventFiringWebdriver	
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		
		
	
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_LOAd_TIME_OUT,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	  driver.get(prop.getProperty("url"));	
		
	}
	
	
	
	
	
	
	
}


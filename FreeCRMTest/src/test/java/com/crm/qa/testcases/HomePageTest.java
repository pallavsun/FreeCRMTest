package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}

	/*
	
   TestCases should be independent with each other
   before each testcase launch the browser and login
   @test------execute the testcase	
   after each testcase close the browser
   
   	*/
	@BeforeMethod
	public void setUp(){
		
		initalization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	    homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		homePage.verifyHomePageTitle();
	}
	
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{    
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

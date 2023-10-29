package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName="contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initalization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
	    loginPage=new LoginPage();
	    homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	    testUtil.switchToFrame();
	   
	    
	}

	@Test(priority=1)
	public void verifyContactsPagelabel()
	{ 
		contactsPage=homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifycontactsLabel(),"Contacts label is missing on the page");
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException 
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company)   //fetch the data from excel sheet and put in these arguments 
	{
		homePage.clickOnNewContactLink();
	//	contactsPage.createNewContacts("Mr.","Tom","Peter","Google");
		contactsPage.createNewContacts(title, firstName, lastName, company);
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'pallav kumar')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	@CacheLookup
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement tasksLink;
	
	
	public HomePage() {
	    	
	PageFactory.initElements(driver, this);
	  
	 }
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName() 
	{
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() 
	{
		contactsLink.click();
		return new ContactsPage();           // landing page after click on contacts
    }
	
	
	public DealsPage clickOnDealsLink() 
	{
		dealsLink.click();
		return new DealsPage();
    }
	
	
	 
	
	public void clickOnNewContactLink() 
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	 
	 
	 
	 
	 

}

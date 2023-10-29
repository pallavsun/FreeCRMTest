package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	

	@FindBy(id="first_name")
    WebElement firstName;
	

	@FindBy(id="surname")
    WebElement lastName;
	
	@FindBy(name="client_lookup")
    WebElement company;
	

	@FindBy(xpath="//input[@type='submit' and @value='Save']")
    WebElement saveBtn;
	
	
	
   public  ContactsPage() {
	    	
	PageFactory.initElements(driver, this);
	  
	}
   
   public boolean verifycontactsLabel()
   {
	  return contactslabel.isDisplayed();   
   }
	
	
   public void createNewContacts(String title,String fname,String lname,String comp)
   {
	Select select=new Select(driver.findElement(By.name("title"))); 
	select.selectByVisibleText(title);
	
	firstName.sendKeys(fname);
	lastName.sendKeys(lname);
	company.sendKeys(comp);
	saveBtn.click();
	   
   }
	
 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}

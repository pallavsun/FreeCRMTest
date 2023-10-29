package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory(Object Repositories)
	
	@FindBy(name="username")
	WebElement username;
	

	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	
    @FindBy(xpath="//img[contains(@class,img-responsive)]")
	WebElement crmLogo;
	
	
    
 // We have to initialize all the above webelemts by using the below driver 
    
   // Initializing the page objects 
    public LoginPage() {
    	
    	PageFactory.initElements(driver, this);
    }
    
    
    //================Actions================
    
    public String validateLoginPageTitle() {
    	
    	return driver.getTitle();
    }
    
    public boolean validateCRMImage() {
    	
    	return crmLogo.isDisplayed();
	}
    
    public HomePage login(String un,String pwd)
    {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	
    	return new HomePage();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
}

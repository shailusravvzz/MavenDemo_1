package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver,this);
		}
	
	/*
 --------------------------------------------------------------------------------
	 * here loginPage is constructor.     -LoginPage(WebDriver rdriver)
	 * 
	 * A constructor in Java is a special method that is used to initialize objects. 
	  The constructor is called when an object of a class is created
--------------------------------------------------------------------------------	
	*Here WebDriver is interface
	*
	*The interface in Java can be defined as the blueprint of the class. An interface 
	*can have abstract methods and static constants
----------------------------------------------------------------------------------
	*Abstract methods don’t have body
	*
	*abstract keyword is used to declare the method as abstract.
	*You have to place the abstract keyword before the method name in the method declaration.
	*An abstract method contains a method signature, but no method body
----------------------------------------------------------------------------------
	Page Factory in Selenium WebDriver
	
	 *Page Factory is a class provided by Selenium WebDriver to implement the Page Object Model.
	 *POM creates our testing code maintainable, reusable.
	 *
----------------------------------------------------------------------------------
	 *initElements
	 *
	 *The initElements is a static method of PageFactory class which is used in conjunction with @FindBy annotation. 
	 *Using the initElements method we can initialize all the web elements located by @FindBy annotation.
----------------------------------------------------------------------------------
	@CacheLookup
	The CacheLookup property will tell Selenium to cache the web object the first time it is found. 
	For subsequent uses of this object it will not be looked up on the object tree again, it will simply be reused.
----------------------------------------------------------------------------------

	 *
	*/
	

	
		@FindBy(name = "uid")
		@CacheLookup
		WebElement txtUsername;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
		@CacheLookup
		WebElement lnkLogout;
		
		
		//@FindBy(name="btnReset")
		//WebElement btnReset;
		
		
		//		public − This is the access specifier that states that the method can be accesses publically
		
		// 		static − Here, the object is not required to access static members. 
			
		//		void − This states that the method doesn’t return any value.		
		
	
		/*Java static method
		 * 
		A static method belongs to the class rather than the object of a class.
		A static method can be invoked without the need for creating an instance of a class.
		A static method can access static data member and can change the value of it.
		
		*/
		
		
		public void setUserName(String uname) {
			
			txtUsername.sendKeys(uname);
			
		}
		
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		
		public void clickSubmit() {
			btnLogin.click();
		}
		
		
		public void clickLogout() {
			lnkLogout.click();
			
		}
}

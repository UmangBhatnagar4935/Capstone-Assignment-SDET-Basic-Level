
//		author                                    Umang Bhatnagar     @umangbhatnagar@virtusa.com
//		*************************************     Here the whole script is written keeping MacOS		    *************************************
//		*************************************	  in mind. "BaseUtilitiesTestClass" class has been written	    *************************************			
//		*************************************	  for the low level implementation by segregating into 	    *************************************
//		*************************************	  different methods. These methods are later called   	    *************************************
//		*************************************	  as in need in class "TestDriverClass"	to come		    *************************************
//		*************************************	  up with a meaningful script as asked for.					*************************************


package com.avirtusaa;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class TestDriverClass {

	private String loginErrorText, pageTitle = null;
	private BaseUtilitiesTestClass baseUtilitiesTestClassI;
	private String userNameSet, passwordSet = null;
	private WebElement useName, passwordThrown, login, errorLogin, burgerMenu, logout = null;



	public TestDriverClass()

	{
		this.baseUtilitiesTestClassI = new BaseUtilitiesTestClass("Chrome", 2000); 

	}

	

	@Given("with few user credentials including both valid and invalid user credentials in an external excel file.")
	@And("user is done with reading all the login credentials from Excel file ")
	@Then("store all that read-information in a local buffer called as Data Provider technically.")
	@And("that buffer can be any 2d array sufficing this need.")
	public void sauceDemoTestDriverInitializer(String userNameDataProvided, String passwordDataProvided) throws InterruptedException
	{

		Thread.sleep(1000);
		System.err.println("Username: "+userNameDataProvided+ '\t'+ '\t'+ '\t'+ '\t' + "Password: "+passwordDataProvided);
		this.userNameSet = userNameDataProvided;
		this.passwordSet = passwordDataProvided;
		baseUtilitiesTestClassI.maximizeBrowser();
		baseUtilitiesTestClassI.visitPage("https://www.saucedemo.com/");

		this.useName = baseUtilitiesTestClassI.elementGrabber("//input[@id = 'user-name']");
		this.passwordThrown = baseUtilitiesTestClassI.elementGrabber("//input[@id = 'password']"); 
		this.login =  baseUtilitiesTestClassI.elementGrabber("//input[@id = 'login-button']"); 

	}

	
	@Given("that user successfully logs in,")
	
	public void enterCredsAndLogin()
	{

		//Entering credentials 
		baseUtilitiesTestClassI.typeStringValues(useName, userNameSet);
		baseUtilitiesTestClassI.typeStringValues(passwordThrown, passwordSet);

		//Logging in
		baseUtilitiesTestClassI.waitForAnElement(login);
		baseUtilitiesTestClassI.clickTheElement(login);
	}


	@Given("The user with wrong credentials tries to log in")
	@Then("The error is thrown and is captured to get verified against as expected")
	public String checkInvalidUser()
	{

		if(userNameSet.equals("locked_out_user"))
		{
			this.errorLogin = baseUtilitiesTestClassI.elementGrabber("//h3[@data-test = 'error']");
			baseUtilitiesTestClassI.waitForAnElementTextDiscovery(errorLogin, "Epic sadface: Sorry, this user has been locked out.");
			this.loginErrorText = baseUtilitiesTestClassI.elementTextGrabber(errorLogin);	
		}
		return this.loginErrorText;
	}


	@Then("capture the title of the page and get that verified.")
	@And("once the user lands upon a Home Page")
	@Then("he should log out and wait for next input from data provider as illustrated above already.")
	public String logsAndFetchTitle() throws InterruptedException
	{

		//Inside the web page and logging out
		Thread.sleep(1000);
		this.burgerMenu  = baseUtilitiesTestClassI.elementGrabber("//button[contains(@id, 'menu')]");
		baseUtilitiesTestClassI.waitForAnElement(burgerMenu);
		baseUtilitiesTestClassI.clickTheElement(burgerMenu);
		this.logout = baseUtilitiesTestClassI.elementGrabber("//a[contains(@id, 'logout')]");

		this.pageTitle = baseUtilitiesTestClassI.getTitle();
		baseUtilitiesTestClassI.waitForAnElement(logout);
		Thread.sleep(1000);
		baseUtilitiesTestClassI.clickTheElement(logout);


		Thread.sleep(500);

		return this.pageTitle;

	}


	public void sauceDemoTestQuitBrowser()
	{
		baseUtilitiesTestClassI.terminateBrowser();
	}

}

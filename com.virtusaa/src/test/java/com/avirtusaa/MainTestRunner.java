
//		author                                    Umang Bhatnagar     @umangbhatnagar@virtusa.com
//		*************************************     Here the whole script is written keeping MacOS		    *************************************
//		*************************************	  in mind. "BaseUtilitiesTestClass" class has been written	    *************************************			
//		*************************************	  for the low level implementation by segregating into 	    *************************************
//		*************************************	  different methods. These methods are later called   	    *************************************
//		*************************************	  as in need in class "TestDriverClass"	to come		    *************************************
//		*************************************	  up with a meaningful script as asked for.					*************************************



package com.avirtusaa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MainTestRunner extends TestDriverClass{




	@Test(dataProvider = "User Credentials", dataProviderClass = SauceDemoUserCrendentialsDataProviderClass.class)
	public void name(String userNameReceived, String passwordReceived) throws EncryptedDocumentException, IOException, InterruptedException
	{

		sauceDemoTestDriverInitializer(userNameReceived, passwordReceived);
		enterCredsAndLogin();
		
		if (userNameReceived.equals("locked_out_user"))
		{

			String errorText = checkInvalidUser();
			Assert.assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.", "The error has been verified");

		}
		

		else
		{
			//sauceDemoTestDriverInitializer(userNameReceived, passwordReceived);
			String pageTitle  = logsAndFetchTitle();
			Assert.assertEquals(pageTitle, "Swag Labs", "Page title has been verified");
		}

		Reporter.log("The tests have found to have been passed !!");
	}


	@AfterClass
	public void closeAllTests()
	{
		sauceDemoTestQuitBrowser();
	}


}
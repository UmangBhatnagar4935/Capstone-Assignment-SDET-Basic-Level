
#		author                                    Umang Bhatnagar     @umangbhatnagar@virtusa.com
#		*************************************     Here the whole script is written keeping MacOS		    *************************************
#		*************************************	  in mind. "BaseUtilitiesTestClass" class has been written	    *************************************			
#		*************************************	  for the low level implementation by segregating into 	    *************************************
#		*************************************	  different methods. These methods are later called   	    *************************************
#		*************************************	  as in need in class "TestDriverClass"	to come		    *************************************
#		*************************************	  up with a meaningful script as asked for.					*************************************





Feature:
Read different sets of login credentials from an external Excel sourcefile and capture page title and wrong user info error.




Background:
	
	Scenarios:

		Scenario: Login with valid User credentials !!

			Given with few user credentials including both valid and invalid user credentials in an external excel file.

			And  user is done with reading all the login credentials from Excel file,		

			Then store all that read-information in a local buffer called as Data Provider technically.

			And that buffer can be any 2d array sufficing this need.





		Scenario: Once logged in, capture the title of the pag and verify against as expected value !!
			
			Given that user successfully logs in,
			
			Then capture the title of the page and get that verified.
			
			And once the user lands upon a Home Page
			
			Then he should log out and wait for next input from data provider as illustrated above already.




		Scenario:	Also fetches the wrong user error

			Given The user with wrong credentials tries to log in

			Then The error is thrown and is captured to get verified against as expected 


	


 
 
Feature: User Portal Sign Up Page Functionalities
	Verify that User is able to sign up and logged in.


@UserSignUp
Scenario: Verify User is able to login
	Given User has launch the browser. 
	Then Swiggy has been opened.
	Then User enters data in fields required for sign up and clicks continue.

@UserLogin
Scenario: Verify User is able to login
	Given User has launch the browser. 
	Then Swiggy has been opened.
	Then User logged in using Mobile Phone Number.
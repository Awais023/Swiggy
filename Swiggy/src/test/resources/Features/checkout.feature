Feature: User Portal Sign Up Page Functionalities
	Verify that User is able to sign up and logged in.


@SearchProduct
Scenario: Verify User is able to login
	Given User has launch the browser. 
	Then Swiggy has been opened.
	Then User enters delivery location and search nearby resturants.

@CompleteCheckout
Scenario: Verify User is able to login
	Given User has launch the browser. 
	Then Swiggy has been opened.
	Then User enters delivery location and search nearby resturants.
	Then User add product to cart.
	Then user completed the checkout process.

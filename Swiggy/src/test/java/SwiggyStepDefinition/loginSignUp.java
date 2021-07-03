package SwiggyStepDefinition;

import SwiggyAutomationCases.loginSignUpFunctionality;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginSignUp {

	loginSignUpFunctionality loginSignUp_ = new loginSignUpFunctionality();
	
	@Given("^User has launch the browser\\.$")
	public void user_has_launch_the_browser() throws Throwable {
		loginSignUp_.setExtent();
		loginSignUp_.launchBrowser();		
	}

	@Then("^Swiggy has been opened\\.$")
	public void swiggy_has_been_opened() throws Throwable {
		loginSignUp_.launchSwiggy();
	}

	@Then("^User enters data in fields required for sign up and clicks continue\\.$")
	public void user_enters_data_in_fields_required_for_sign_up_and_clicks_continue() throws Throwable {
		loginSignUp_.signUp();
	}
	@Then("^User logged in using Mobile Phone Number\\.$")
	public void user_logged_in_using_Mobile_Phone_Number() throws Throwable {
		loginSignUp_.logIn();
		
	}


}

package SwiggyStepDefinition;

import SwiggyAutomationCases.checkoutProcess;
import cucumber.api.java.en.Then;

public class Checkout {

	checkoutProcess checkout = new checkoutProcess();

	@Then("^User enters delivery location and search nearby resturants\\.$")
	public void user_enters_delivery_location_and_search_nearby_resturants() throws Throwable {
		checkout.searchLocation();
	}

	
	@Then("^User add product to cart\\.$")
	public void user_add_product_to_cart() throws Throwable {
		checkout.addToCart();
	}

	@Then("^User enters data in search field to search retuarants or products\\.$")
	public void user_enters_data_in_search_field_to_search_retuarants_or_products() throws Throwable {
		checkout.searchRestuarants_Product();
	}

	@Then("^user completed the checkout process\\.$")
	public void user_completed_the_checkout_process() throws Throwable {
	}
}

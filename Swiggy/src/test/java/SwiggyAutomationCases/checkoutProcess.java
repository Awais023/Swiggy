package SwiggyAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class checkoutProcess extends loginSignUpFunctionality {

	checkoutProcess checkout_;

	@FindBy(how = How.ID, using = "location")
	public WebElement enterlocation;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/span[2]\r\n")
	public WebElement selectlocation;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/a/div/div")
	public WebElement selectRestuarant;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/header/div/div/ul/li[5]/div/a")
	public WebElement clickSearch;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div/div/div/div/div/input")
	public WebElement enterSearch;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]")
	public WebElement addToCart;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div/div[3]/div[3]")
	public WebElement clickCheckout;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[2]")
	public WebElement clickCheckoutLogin;

	@FindBy(how = How.ID, using = "mobile")
	public WebElement enterCheckoutLoginMobile;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/form/div[2]/a")
	public WebElement clickCheckoutLoginBtn;

	@FindBy(how = How.ID, using = "name")
	public WebElement enterSignUpName;

	@FindBy(how = How.ID, using = "email")
	public WebElement enterSignUpEmail;

	@FindBy(how = How.ID, using = "password")
	public WebElement enterSignUpPassword;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/form/div[2]/a")
	public WebElement clickCheckoutSignUp;

	@FindBy(how = How.ID, using = "otp")
	public WebElement enterSignUpOtp;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div")
	public WebElement productName;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/form/div[2]/a")
	public WebElement verifySignUpOtp;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div/div[2]/div/div[1]/div/h1")
	public WebElement restName;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void searchLocation() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			checkout_ = PageFactory.initElements(driver, checkoutProcess.class);
			checkout_.enterlocation.sendKeys("Lahore");
			checkout_.selectlocation.click();
			test = extent.createTest("Search Location")
					.pass(MarkupHelper.createLabel("Search field has been entered.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Area has been searched Successfully.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Search Location")
					.fail(MarkupHelper.createLabel("Area has not been searched Successfully.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void searchRestuarants_Product() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			checkout_.clickSearch.click();
			checkout_.enterSearch.sendKeys("Tandoori Chicken");
			checkout_.enterSearch.sendKeys(Keys.RETURN);
			test = extent.createTest("Search Restuarant")
					.pass(MarkupHelper.createLabel("Restuarant has been entered.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Restuarant has been searched Successfully.", ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Search Restuarant")
					.fail(MarkupHelper.createLabel("Restuarant has not been searched Successfully.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void addToCart() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			checkout_.selectRestuarant.click();
			checkout_.addToCart.click();
			checkout_.clickCheckout.click();
			String productName = checkout_.productName.getText();
			test = extent.createTest("Add To Cart")
					.pass(MarkupHelper.createLabel(
							"Product " + productName + " has been selected and being order from restuarant.",
							ExtentColor.GREEN));
			test.pass(
					MarkupHelper.createLabel("Product " + productName + " has been added to cart.", ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Add to Cart")
					.fail(MarkupHelper.createLabel("Product has not been added to cart successfully", ExtentColor.RED));
			extent.flush();
		}
	}

	public void checkout() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			checkout_.clickCheckoutLogin.click();
			checkout_.enterCheckoutLoginMobile.sendKeys(phoneNumber);
			checkout_.clickCheckoutLoginBtn.click();
			checkout_.enterSignUpName.sendKeys(name_);
			checkout_.enterSignUpEmail.sendKeys(email_);
			checkout_.enterSignUpPassword.sendKeys("test1234");
			checkout_.clickCheckoutSignUp.click();
			checkout_.enterSignUpOtp.sendKeys("####");
			checkout_.verifySignUpOtp.click();
			test = extent.createTest("Checkout")
					.pass(MarkupHelper.createLabel(
							"User has been logged in and payment and address details has been entered successfully",
							ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Phone Number :" + phoneNumber, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Name :" + name_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Email :" + email_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Checkout has been completed successfully.", ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Checkout")
					.fail(MarkupHelper.createLabel("Checkout has not been completed successfully.", ExtentColor.RED));
			extent.flush();
		}

	}

}

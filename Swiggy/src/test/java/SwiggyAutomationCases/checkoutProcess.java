package SwiggyAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class checkoutProcess extends loginSignUpFunctionality{

	checkoutProcess checkout_;
	
	@FindBy(how = How.ID, using = "location")
	public WebElement enterlocation;
	

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/span[2]\r\n")
	public WebElement selectlocation;
	

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[1]/a/div/div[1]/div/div[1]")
	public WebElement selectRestuarant;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/header/div/div/ul/li[5]/div/a")
	public WebElement clickSearch;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div/div/div/div/div/input")
	public WebElement enterSearch;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]")
	public WebElement addToCart;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div/div[3]/div[3]")
	public WebElement clickCheckout;

	public void searchLocation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_ = PageFactory.initElements(driver, checkoutProcess.class);
		checkout_.enterlocation.sendKeys("Lahore");
		checkout_.selectlocation.click();
		test = extent.createTest("Search Location")
				.pass(MarkupHelper.createLabel("Search field has been entered.", ExtentColor.GREEN));
		test.pass(MarkupHelper.createLabel("Location has been searched Successfully.", ExtentColor.GREEN));
		extent.flush();

	}

	public void searchRestuarants_Product() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_.clickSearch.click();
		checkout_.enterSearch.sendKeys("Tandoori Chicken");
		checkout_.enterSearch.sendKeys(Keys.RETURN);
		test = extent.createTest("Search Restuarant")
				.pass(MarkupHelper.createLabel("Restuarant has been entered.", ExtentColor.GREEN));
		test.pass(MarkupHelper.createLabel("Restuarant has been searched Successfully.", ExtentColor.GREEN));
		extent.flush();

	}
	
	public void addToCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_.selectRestuarant.click();
		checkout_.addToCart.click();
		checkout_.clickCheckout.click();
	}

}

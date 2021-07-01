package SwiggyAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class checkoutProcess extends loginSignUpFunctionality{

	checkoutProcess checkout_;
	
	@FindBy(how = How.ID, using = "location")
	public WebElement enterlocation;
	

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/span[2]\r\n")
	public WebElement selectlocation;
	

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div/div/div[5]/div/div/div[2]/div[1]/div/div[1]/div[1]/a/div/div[1]")
	public WebElement selectRestuarant;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[1]")
	public WebElement addToCart;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div/div[3]/div[3]")
	public WebElement clickCheckout;

	public void searchLocation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_ = PageFactory.initElements(driver, checkoutProcess.class);
		checkout_.enterlocation.sendKeys("Lahore");
		checkout_.selectlocation.click();
	}
	
	public void addToCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_.selectRestuarant.click();
		checkout_.addToCart.click();
		checkout_.clickCheckout.click();
	}

}

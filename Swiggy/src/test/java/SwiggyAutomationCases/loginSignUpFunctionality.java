package SwiggyAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class loginSignUpFunctionality {
	
	loginSignUpFunctionality loginSignUp_;
	public static WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[2]")
	public WebElement signUp_;

	@FindBy(how = How.ID, using = "mobile")
	public WebElement PhoneNumber;

	@FindBy(how = How.ID, using = "email")
	public WebElement Email;

	@FindBy(how = How.ID, using = "name")
	public WebElement Name;

	@FindBy(how = How.ID, using = "password")
	public WebElement Password;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/form/div[2]/a")
	public WebElement continueBtn;
	
	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[1]")
	public WebElement clickLogin;

	@FindBy(how = How.ID, using = "mobile")
	public WebElement enterLoginMobileNumber;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/form/div[2]/a")
	public WebElement clickLoginbtn;

	public void launchBrowser() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/awais.sultan/git/TPG/TpgAutomation/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loginSignUp_ = PageFactory.initElements(driver, loginSignUpFunctionality.class);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void launchSwiggy() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void signUp() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.signUp_.click();
		loginSignUp_.PhoneNumber.sendKeys("0912345678");
		loginSignUp_.Name.sendKeys("Awais");
		loginSignUp_.Email.sendKeys("042waisi@gmail.com");
		loginSignUp_.Password.sendKeys("awias1234");
		loginSignUp_.continueBtn.click();
	}
	public void logIn() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.clickLogin.click();
		loginSignUp_.enterLoginMobileNumber.sendKeys("03364592456");
		loginSignUp_.clickLoginbtn.click();
	}

}

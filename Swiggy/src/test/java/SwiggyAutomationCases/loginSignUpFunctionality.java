package SwiggyAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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

	@FindBy(how = How.ID, using = "otp")
	public WebElement otp;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/form/div[2]/a")
	public WebElement verifyOtp;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/form/div[2]/a")
	public WebElement continueBtn;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[1]")
	public WebElement clickLogin;

	@FindBy(how = How.ID, using = "mobile")
	public WebElement enterLoginMobileNumber;

	@FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/form/div[2]/a")
	public WebElement clickLoginbtn;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void setExtent() throws Throwable {
		try {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("./reports/AutomationReport.html");
			spark.config().setEncoding("utf-8");
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Test Resuts");
			spark.config().setTheme(Theme.STANDARD);
			extent.attachReporter(spark);
		} catch (Exception e) {
			System.out.println("EXTENT REPORTS HAS NOT BEEN INITIATED!.");
		}
	}

	public void launchBrowser() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/awais.sultan/git/TPG/TpgAutomation/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loginSignUp_ = PageFactory.initElements(driver, loginSignUpFunctionality.class);
			test = extent.createTest("Launch Browser")
					.pass(MarkupHelper.createLabel("Chrome Driver has been Launching.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Chromer Driver has been launched Successfully.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Launch Browser")
					.fail(MarkupHelper.createLabel("Chrome Driver has been Launching", ExtentColor.RED));
			extent.flush();
		}
	}

	public void launchSwiggy() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.swiggy.com");
			driver.manage().window().maximize();
			test = extent.createTest("Launch Swiggy Website")
					.pass(MarkupHelper.createLabel("Swiggy.com has been launched.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Swiggy.com has been launched Successfully.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Launch Swiggy.com")
			.fail(MarkupHelper.createLabel("Swiggy.com has not been launched Successfully.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void signUp() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.signUp_.click();
		loginSignUp_.PhoneNumber.sendKeys("9156454646");
		loginSignUp_.Name.sendKeys("Awais");
		loginSignUp_.Email.sendKeys("042waisi@gmail.com");
		loginSignUp_.Password.sendKeys("awias1234");
		loginSignUp_.continueBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.otp.sendKeys("####");
		loginSignUp_.verifyOtp.click();
		test = extent.createTest("Sign Up")
				.pass(MarkupHelper.createLabel("Sign Up details has been entered.", ExtentColor.GREEN));
		test.pass(MarkupHelper.createLabel("Sign Up details has been entered Successfully.", ExtentColor.GREEN));
		extent.flush();
	}

	public void logIn() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.clickLogin.click();
		loginSignUp_.enterLoginMobileNumber.sendKeys("9156454646");
		loginSignUp_.clickLoginbtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginSignUp_.otp.sendKeys("####");
		loginSignUp_.verifyOtp.click();
		test = extent.createTest("Log In")
				.pass(MarkupHelper.createLabel("User has been logged in.", ExtentColor.GREEN));
		test.pass(MarkupHelper.createLabel("User has been logged in Successfully.", ExtentColor.GREEN));
		extent.flush();
	}

}

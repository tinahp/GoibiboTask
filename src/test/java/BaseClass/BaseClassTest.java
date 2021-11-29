package BaseClass;

import PageObjects.CreditCardPage;
import PageObjects.HotelBookingPage;
import PageObjects.HotelMenuPage;
import PageObjects.LandingPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import reports.ExtentManager;

public class BaseClassTest {
    // Create a WebDriver object
    //public WebDriver driver;
    public static WebDriver driver;
    public static WebDriver startdriver(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver=new ChromeDriver();
        }else
            return driver;
        return null;
    }
    ExtentTest test;
    ExtentReports reports;
    ExtentManager extentManager = new ExtentManager();
    // Create a Landing page Object
    protected LandingPage landingPage;
    // Create a HotelsMenu page Object
    protected HotelMenuPage hotelsMenuPage;
    protected HotelBookingPage hotelBookingPage;
    protected CreditCardPage creditCardPage;

    @BeforeTest
    public void setUp() {
        reports = ExtentManager.getReports();
        test = reports.createTest("BaseClassTest");
        // Set chromeBrowser
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        test.log(Status.INFO, "Opening Browser");
        // maximize window
        driver.manage().window().maximize();
        //Open the page URL
        driver.get("https://www.goibibo.com/");
        test.log(Status.INFO, "Starting test case Hotel_Search");

        //Instantiate login page after launching the browser
        landingPage = new LandingPage (driver);
    }
}

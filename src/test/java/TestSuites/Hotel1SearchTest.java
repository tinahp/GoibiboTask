package TestSuites;

import BaseClass.BaseClassTest;
import PageObjects.HotelBookingPage;
import PageObjects.HotelMenuPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.ExtentManager;

import java.util.concurrent.TimeUnit;

public class Hotel1SearchTest extends BaseClassTest {
    ExtentTest test;
    ExtentReports reports;

    //set Extent report methods
    @BeforeMethod
    public void init(){
        //ExtentManager.getReports();
        reports = ExtentManager.getReports();
        ExtentReports reports = ExtentManager.getReports();
        test = reports.createTest("Hotel_1SearchTests");
    }

    @AfterMethod
    public void quit() {
        reports.flush(); //generates the reports
    }

    // Test cases
    @Test (priority = 0)
    public void hotelNav() throws InterruptedException {
        //click hotels
        landingPage.clickHotels();
        test.log(Status.INFO, "Searching Hotels");
        System.out.println("PASSED: Hotels page opened");
        test.log(Status.INFO, "Test Passed");
        Thread.sleep(1000);
    }

    @Test (priority = 1)
    public void hotelSearch() throws InterruptedException {
        HotelMenuPage hotelsMenuPage=new HotelMenuPage(driver);
        //choose country type
       hotelsMenuPage.CountryType();
        //test.log(Status.INFO, "Choose country type");
        //Thread.sleep(1000);
        //input location
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        hotelsMenuPage.enterHotelArea("Delhi");
        Thread.sleep(1500);
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        test.log(Status.INFO, "Entered location: Delhi");
        hotelsMenuPage.autoSelectArea();
        // maximize window
        driver.manage().window().maximize();
        //select check in date (28 October)
        hotelsMenuPage.clickCheckIn();
        Thread.sleep(500);
        hotelsMenuPage.checkInDate();
        Thread.sleep(1000);
        test.log(Status.INFO, "Selected Check in details: 28 October");
        //select check out date (31 October)
        hotelsMenuPage.clickCheckOut();
        Thread.sleep(500);
        hotelsMenuPage.CheckOutDate();
        test.log(Status.INFO, "Selected Check out details: 31 October");
        Thread.sleep(500);
        //choose number of guest
        hotelsMenuPage.clickRG();
        Thread.sleep(1000);
        hotelsMenuPage.selectGuest();
        test.log(Status.INFO, "Selected number of guest: 2");
        Thread.sleep(1000);

        Thread.sleep(1000);
        hotelsMenuPage.clickSearch();
        test.log(Status.INFO, "Clicked search");
        //print success message
        System.out.println("PASSED: Hotel search displayed successfully");
        test.log(Status.PASS, "Test Passed");
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void selectHotel() throws InterruptedException {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        //select hotel
       hotelBookingPage.selectName();
        System.out.println("PASSED: Hotel name selected");
        Thread.sleep(3500);
        //Log Hotel title to testNG
        String result = driver.findElement(By.xpath("//div[@id='root']/div[2]/div/section[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/h4")).getText().split(" ")[2];
        System.out.println(result);
        test.log(Status.INFO, result);
        //System.out.println(hotelBookingPage.getHotelName());
        test.log(Status.INFO, "Hotel title logged to TestNG");
}

    }


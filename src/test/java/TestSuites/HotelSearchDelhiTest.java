package TestSuites;

import BaseClass.BaseClassTest;
import PageObjects.CreditCardPage;
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


public class HotelSearchDelhiTest extends BaseClassTest {

    ExtentTest test;
    ExtentReports reports;

    //set Extent report methods
    @BeforeMethod
    public void init() {
        //ExtentManager.getReports();
        reports = ExtentManager.getReports();
        ExtentReports reports = ExtentManager.getReports();
        test = reports.createTest("HotelSearchDelhiTest");
    }

    @AfterMethod
    public void quit() {
        reports.flush(); //generates the reports
    }

    // Test cases
    @Test(priority = 0)
    public void hotelNav() throws InterruptedException {
        //click hotels
        landingPage.clickHotels();
        test.log(Status.INFO, "Searching Hotels");
        System.out.println("PASSED: Hotels page opened");
        test.log(Status.PASS, "hotelNav Passed");
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void hotelSearch() throws InterruptedException {
        HotelMenuPage hotelsMenuPage = new HotelMenuPage(driver);
        //choose country type
        hotelsMenuPage.CountryType();
        test.log(Status.INFO, "Choose country type");
        Thread.sleep(1000);
        //select check in date (28 October)
        hotelsMenuPage.clickCheckIn();
        Thread.sleep(500);
        hotelsMenuPage.checkInDate();
        Thread.sleep(1000);
        test.log(Status.INFO, "Selected Check in details: 28 October");
        //select check out date (31 October)
        hotelsMenuPage.clickCheckOut();
        Thread.sleep(1500);
        hotelsMenuPage.CheckOutDate();
        test.log(Status.INFO, "Selected Check out details: 31 October");
        Thread.sleep(500);
        //choose number of guest
        hotelsMenuPage.clickRG();
        Thread.sleep(1000);
        hotelsMenuPage.selectGuest();
        test.log(Status.INFO, "Selected number of guest: 2");
        Thread.sleep(1000);
        //input location
        hotelsMenuPage.enterHotelArea(" Delhi"); //"Ooty");
        Thread.sleep(1500);
        test.log(Status.INFO, "Entered location: Delhi");
        hotelsMenuPage.autoSelectArea();
        Thread.sleep(1000);
        hotelsMenuPage.clickSearch();
        test.log(Status.INFO, "Clicked search");
        //print success message
        System.out.println("PASSED: Hotel search displayed successfully");
        test.log(Status.PASS, "hotelSearch Passed");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void selectHotel() throws InterruptedException {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        //select hotel
        hotelBookingPage.selectName();
        System.out.println("PASSED: Hotel name selected");
        Thread.sleep(3500);
        test.log(Status.PASS, "selectHotel Passed");
    }

    @Test(priority = 2)
    public void hotelDetails() throws InterruptedException {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        //Log Hotel title to testNG
        //  String result = driver.findElement(By.xpath("//*[@id=\"root\"]/section[1]/section[3]/section/div/div[2]/h1")).getText().split(" ")[1];
        String result =
                driver.findElement(By.xpath("//div[@id='root']/div[2]/div/section[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/h4")).getText().split(" ")[1];
        System.out.println(result);
        test.log(Status.INFO, result);
        //System.out.println(hotelBookingPage.getHotelName());
        test.log(Status.INFO, "Hotel title logged to TestNG");
        //click select room
        hotelBookingPage.selectName();
        test.log(Status.INFO, "navigated to user details page");
        test.log(Status.PASS, "hotelDetails passed");
        Thread.sleep(2000);


    }



    @Test(priority = 3)
    public void selectRoom() throws InterruptedException {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        //Log Hotel title to testNG
        driver.findElement(By.xpath("(//*[@data-testid='selectRoomBtn'])[1]")).click();
        //System.out.println(result);
        // test.log(Status.INFO, result);
       // System.out.println(hotelBookingPage.selectRoom());
        test.log(Status.INFO, "Selected Hotel logged to TestNG");
        //click select room
        hotelBookingPage.selectRoom();
        test.log(Status.INFO, "navigate to the room option");
        test.log(Status.PASS, "RoomDetails passed");
        Thread.sleep(2000);

    }
}

    @Test(priority = 3)
    public void guestDetails() throws InterruptedException {
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        CreditCardPage creditCardPage = new CreditCardPage(driver);
        //Enter guest details
        hotelBookingPage.enterFirstName("Cynthia"); //first name
        test.log(Status.INFO, "entered first name");
        hotelBookingPage.enterLastName("Nwankwo"); //last name
        test.log(Status.INFO, "entered last name");
        hotelBookingPage.enterEmail("Cynthia@yhoo.com"); //email
        test.log(Status.INFO, "entered email");
        Thread.sleep(1000);
        hotelBookingPage.selectCountryCode();
        test.log(Status.INFO, "selected country dialing code");
        hotelBookingPage.enterPhone("8035527000");
        test.log(Status.INFO, "entered phone number");
        Thread.sleep(1000);
        //click proceed to payment
        hotelBookingPage.paymentButton();
        Thread.sleep(2000);
        test.log(Status.PASS, "guestDetails passed");
    }

}



   /* @Test (priority = 4)
    public void guestPayment() throws InterruptedException {
        CreditCardPage creditCardPage = new CreditCardPage(driver);

        //Enter card details
        creditCardPage.enterCardNum("5399834434000625");
        test.log(Status.INFO, "entered card number");
        creditCardPage.enterCardNam("Tinah peter");
        test.log(Status.INFO, "entered card name");
        creditCardPage.enterCardExp("0724");
        test.log(Status.INFO, "entered card expiring date");
        creditCardPage.enterCardCVV("732");
        test.log(Status.INFO, "entered card CVV");
        Thread.sleep(1000);
        //Enter card address details
        creditCardPage.enterCardAddress("House 42, Lekki - Lagos");
        test.log(Status.INFO, "entered address");
        creditCardPage.enterCardZC("200200");
        test.log(Status.INFO, "entered card address zip code");
        creditCardPage.enterCardCity("Lagos");
        test.log(Status.INFO, "entered card address city");
        creditCardPage.enterCardState("Lagos");
        test.log(Status.INFO, "entered card address state");
        creditCardPage.enterCardCountry();
        test.log(Status.INFO, "entered card country");
        Thread.sleep(500);
        creditCardPage.clickPayment();
        test.log(Status.INFO, "clicked payment");
        String errorMsg = driver.findElement(By.xpath("//*[@id=\"card\"]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/p")).getText().split(" ")[2];
        System.out.println(errorMsg);
        test.log(Status.INFO, "Logged error message: Please Enter Valid Card Number");
        test.log(Status.PASS, "guestPayment");
    }

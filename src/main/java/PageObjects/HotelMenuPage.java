package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HotelMenuPage {

    //instantiate webdriver
    public WebDriver driver;

    public HotelMenuPage (WebDriver driver) {
        this.driver = driver;
    }


    //locate element on webpage
   // private By autoArea = By.xpath("//ul[@role='listbox']");//*[name()='path' and contains(@d,'M15.61 13.')]
    private By autoArea = By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']");
    private By autoSearch = By.xpath("//li[@id='downshift-1-item-0']/span");//li[@id='downshift-13-item-0']
    private By CountryType = By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[1]/div[1]/input");//
    private By checkIn = By.xpath("//div[@data-testid='openCheckinCalendar']");
    private By inDate = By.xpath("//body//div//li[32]");
    private By checkOut = By.xpath("//div[normalize-space()='Check-out']");
    private By outDate = By.xpath("//span[normalize-space()='31']");
    private By guestNo = By.xpath("//input[@value='2 Guests in 1 Room ']");//span[normalize-space()='Guests & Rooms']
    private By oneRoom = By.xpath("(//span[@class='PaxWidgetstyles__ContentItemTextWrapperSpan-sc-gv3w6r-3 jwbaWz'])[1]");
    private By oneGuest = By.xpath("//div[@class='SearchBlockUIstyles__AutoSuggestInnerWrap-sc-fity7j-1 emHEpq']//div[2]//div[1]//h4[1]");
    private By guestDone = By.xpath("//div[@id='root']/div[2]/div/section/div/div[2]/div[4]/div/div/div/div[4]/button");//button[normalize-space()='Done']
    private By searchGo = By.xpath("//div[@id='root']/div[2]/div/section/div/div/button");//button[normalize-space()='Search Hotels']

    //select country type
    public void CountryType() {
        driver.findElement(CountryType).click();
    }
    //enter hotel location
    public void enterHotelArea(String hArea) throws InterruptedException{
        WebElement hotelArea = driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']"));
        hotelArea.click();
    }
    public void autoSelectArea() {

        driver.findElement(autoArea).click();
        driver.findElement(autoArea).sendKeys("Delhi");
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
       // WebElement autoSearch = driver.findElement(autoArea);
        driver.findElement((By) autoSearch).click();

    }

    //select check-in date (28 October)

    public void clickCheckIn() {
        driver.findElement(checkIn).click();
    }
    public void checkInDate() {
        driver.findElement(inDate).click();
    }
    //select check-out date ( july)
    public void clickCheckOut()  {
        driver.findElement(checkOut).click();
    }
    public void CheckOutDate() {
        driver.findElement(outDate).click();
    }
    //select number of guest (1)
    public void clickRG() {
        driver.findElement(guestNo).click();
    }
    public void selectGuest() {
        driver.findElement(oneGuest).click();
        driver.findElement(guestDone).click();
    }

    //search hotels
    public HotelBookingPage clickSearch() {
        driver.findElement(searchGo).click();
        return new HotelBookingPage(driver);
    }

    }


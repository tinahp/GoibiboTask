package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    //instantiate webdriver
    public WebDriver driver;

    public LandingPage (WebDriver driver) {
        this.driver = driver;
    }

    //locate element on webpage
    private By clickHotels = By.xpath("//div[contains(@class,'sticky-gutter')]//li[2]");
   public HotelMenuPage clickHotels() throws InterruptedException {
        //click on Hotels
        Thread.sleep(1000);
        driver.findElement(clickHotels).click();
        return new HotelMenuPage(driver);


    }
}
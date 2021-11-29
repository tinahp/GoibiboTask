package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelBookingPage {
    public WebDriver driver;

    public HotelBookingPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locate element on Webpage

    private By selectName = By.xpath("//div[@id='root']/div[2]/div/section[2]/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/h4");//h4[normalize-space()='CP VILLA']
    private By hotelName = By.xpath("//div[@id='root']/section/section[3]/section/div/div[2]/h1");
    private By viewRM = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='per night'])[1]/following::div[4]");
    private By selectRM = By.xpath("(//*[@data-testid='selectRoomBtn'])[1]");
    private By verifyNM = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Deluxe Room With Window - Complimentary Juice'])[3]/preceding::button[1]");////select[@class='PersonalProfile__NameEnterSelect-sc-1r9ak8b-7 hkMeMW']
    private By verifytitle  = By.xpath("//div[@class='TextFieldExpt__Tag-sc-7a7pro-0 bxWEDo']");
    private By firstNM = By.xpath("//input[@value='']");
    private By lastNM = By.xpath("(//input[@value=''])[2]");//input[@placeholder='Enter Last Name']
    private By gtEmail = By.xpath("(//input[@value=''])[3]");//input[@placeholder='Enter Email Address']
    // private By CCNumDD = By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div[1]/div/select");
    private By CCodeNum = By.xpath("//div[@id='root']/div[2]/div/div/div[2]/div[2]/div/div/div[3]/div/div/select");//select[@class='PersonalProfile__CountryCodeWrap-sc-1r9ak8b-10 ca-dHee']
    private By phoneNUM = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mobile Number'])[1]/following::select[1]");//input[@placeholder='Enter Phone Number']
    private By goPayment = By.xpath("//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-10 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 KETBj blGWwt']");


    //select a hotel
    public void selectName() {
        driver.findElement(selectName).click();
    }

    //get hotel name
    public String gethotelName() {
        String result = driver.findElement(hotelName).getText().split(" ")[2];
        System.out.println(result);
        return null;
    }

    //select room button
    public void selectRoom() throws InterruptedException {
        driver.findElement(viewRM).click();
        driver.findElement(selectRM).click();
    }

    //verify room name
    public String verifyRoomName() {
        String resultName = driver.findElement(verifyNM).getText().split("")[2];
        System.out.println(resultName);
        return null;
    }

    //first name field
    public void enterFirstName(String fname) {
        driver.findElement(verifytitle).click();
        driver.findElement(firstNM).sendKeys(fname);
    }

    //last name field
    public void enterLastName(String lname) {
        driver.findElement(lastNM).sendKeys(lname);
    }

    //email field
    public void enterEmail(String mail) {
        driver.findElement(gtEmail).sendKeys(mail);
    }

    //phone number field
    public void selectCountryCode() throws InterruptedException {
        driver.findElement(CCodeNum).click();
        //driver.findElement(CC).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneNUM).sendKeys(phone);
    }

    //proceed to payment
    public CreditCardPage paymentButton() {
        driver.findElement(goPayment).click();
        return new CreditCardPage(driver);
    }
}
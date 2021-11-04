package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QAConcortPage {

    WebDriver driver;

    public QAConcortPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement usernameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    public void ConcortHotelLogin()  {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        qaConcortPage.loginButonu.click();
    }

    //US0010 test locatorleri
    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement AnaSayfaRoomsSecenegi;

    public void ConcortHotelRoomsGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
    }

    //Rooms sayfasi
    public void ConcortHotelRoomsBilgiGiris() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        ReusableMethods rm = new ReusableMethods();
        Actions actions = new Actions(Driver.getDriver());
        qaConcortPage.advancedSearchBasligiCheckinDateBox.clear();
        rm.waitFor(1);
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckinDateBox, "15/12/2021").perform();
        qaConcortPage.advancedSearchBasligiCheckoutDateBox.clear();
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckoutDateBox, "20/12/2021").perform();
        Select select = new Select(qaConcortPage.selectRoomTypeDropdown);
        select.selectByVisibleText("Single");
        Select select1 = new Select(qaConcortPage.selectAdultCountDropdown);
        select1.selectByVisibleText("1 Adult");
        Select select2 = new Select(qaConcortPage.childrenDropdown);
        select2.selectByVisibleText("0 Children");
        rm.scrollInToWiew(qaConcortPage.searchButton);
        rm.waitFor(1);
        actions.sendKeys(qaConcortPage.locationTextBox, "USA").perform();
        rm.waitFor(1);
        actions.click(qaConcortPage.searchButton).perform();
        rm.waitFor(2);
        actions.click(qaConcortPage.bookNow).perform();
    }

    @FindBy(xpath = "//h3[@class='heading mb-4']")
    public WebElement advancedSearchBasligi;

    @FindBy(xpath = "//h1[text()='Rooms']")
    public WebElement roomsSayfasiRoomsBasligi;

    @FindBy(id = "checkin_date")
    public WebElement advancedSearchBasligiCheckinDateBox;

    @FindBy(id = "checkout_date")
    public WebElement advancedSearchBasligiCheckoutDateBox;

    @FindBy(id = "IDRoomType")
    public WebElement selectRoomTypeDropdown;

    @FindBy(id = "AdultCount")
    public WebElement selectAdultCountDropdown;

    @FindBy(id = "ChildrenCount")
    public WebElement childrenDropdown;

    @FindBy(id = "location")
    public WebElement locationTextBox;

    @FindBy(xpath = "(//div[@class='form-group'])[7]")
    public WebElement searchButton;

    @FindBy(xpath = "(//a[@class='btn-custom'])[1]")
    public WebElement bookNow;

    //***TodBruen Room Sayfasi
    @FindBy(xpath = "(//a[text()='Log in'])[2]")
    public WebElement TodBruenOdaSayfasindakiLogIn;

    @FindBy(id = "checkin_date")
    public WebElement TodBruenOdaSayfasindakiCheckinDateBox;

    @FindBy(xpath = "(//tbody//tr//td)[16]")
    public WebElement TodBruenOdaSayfasindakiCheckinDateTakvimi;

    @FindBy(id = "checkout_date")
    public WebElement TodBruenOdaSayfasindakiCheckoutDateBox;

    @FindBy(xpath = "(//tbody//tr//td)[21]")
    public WebElement TodBruenOdaSayfasindakiCheckoutDateTakvimi;

    @FindBy(id = "AdultCount")
    public WebElement TodBruenOdaSayfasindakiSelectAdultCountDropdown;

    @FindBy(id = "ChildrenCount")
    public WebElement TodBruenOdaSayfasindakiChildrenDropdown;

    @FindBy(id = "NameSurname")
    public WebElement TodBruenOdaSayfasindakiNameSurnameTextboxi;

    @FindBy(id = "EmailAddress")
    public WebElement TodBruenOdaSayfasindakiEmailTextboxi;

    @FindBy(id = "PhoneNumber")
    public WebElement TodBruenOdaSayfasindakiPhoneNumberTextboxi;

    @FindBy(id = "NameOnCreditCard")
    public WebElement TodBruenOdaSayfasindakiNameOnCreditCardTextboxi;

    @FindBy(id = "CreditCardNumber")
    public WebElement TodBruenOdaSayfasindakiCreditCardNumberTextboxi;

    @FindBy(xpath = "//select[@name='CreditCardExpirationMonth']")
    public WebElement TodBruenOdaSayfasindakiSelectExpirationMonthForCreditCardDropdownu;

    @FindBy(xpath = "//select[@name='CreditCardExpirationYear']")
    public WebElement TodBruenOdaSayfasindakiSelectExpirationYearForCreditCardDropdownu;

    @FindBy(id = "CVV")
    public WebElement TodBruenOdaSayfasindakiCVVTextboxi;

    @FindBy(id = "Message")
    public WebElement TodBruenOdaSayfasindakiMessageTextboxi;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement TodBruenOdaSayfasindakiBookThisRoomButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement reservationWasMadeSuccessfully;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement thisFieldIsRequiredYazisi;

    @FindBy(xpath = "//div[@class='col-md-12 room-single mt-4 mb-5 ftco-animate fadeInUp ftco-animated']")
    public WebElement theBestHotelInTheRegionYazisi;

}

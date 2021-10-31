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

    public void ConcortHotelLogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        Thread.sleep(2000);
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(1000);
        qaConcortPage.loginButonu.click();
    }
//US0001 test locatorleri










    //US0002  test locatorleri













    //US0003 test locatorleri














    //US0004-US0005 ortak alan locatorleri
    //Once ortak alan locatorlere bakilacak sonrasinda locate edilmediyse locate edilecek.












    //US0004 test locatorleri






    //US0005 test locatorleri








    //US0006-US0007 ortak alan locatorleri
    //Once ortak alan locatorlere bakilacak sonrasinda locate edilmediyse locate edilecek.







    //US0006 test locatorleri











    //US0007 test locatorleri








    //US0008-US0009 ortak alan locatorleri
    //Once ortak alan locatorlere bakilacak sonrasinda locate edilmediyse locate edilecek.













    //US0008 test locatorleri











    //US0009 test locatorleri










    //US0010 test locatorleri
    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement AnaSayfaRoomsSecenegi;

    public void ConcortHotelRoomsGiris() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        Thread.sleep(1000);
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
        Thread.sleep(2000);
    }

    //Rooms sayfasi
    public void ConcortHotelRoomsBilgiGiris() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        Actions actions = new Actions(Driver.getDriver());
        qaConcortPage.advancedSearchBasligiCheckinDateBox.clear();
        Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckinDateBox, "15/12/2021").perform();
        qaConcortPage.advancedSearchBasligiCheckoutDateBox.clear();
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckoutDateBox, "20/12/2021").perform();
        Select select = new Select(qaConcortPage.selectRoomTypeDropdown);
        select.selectByVisibleText("Single");
        //Thread.sleep(1000);
        Select select1 = new Select(qaConcortPage.selectAdultCountDropdown);
        select1.selectByVisibleText("1 Adult");
        // Thread.sleep(1000);
        Select select2 = new Select(qaConcortPage.childrenDropdown);
        select2.selectByVisibleText("0 Children");
        //Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.locationTextBox, "USA").perform();
        Thread.sleep(2000);
        actions.click(qaConcortPage.searchButton).perform();
        Thread.sleep(2000);
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

    @FindBy (xpath = "(//tbody//tr//td)[16]")
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

}

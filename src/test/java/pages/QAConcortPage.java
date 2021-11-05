package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

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

    public void ConcortHotelLogin() {
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

    //US008 test locatorleri
    //List Of Rezervations sayfasi

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementSekmesi;

    @FindBy(linkText = "Room reservations")
    public WebElement roomReservationsSekmesi;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfReservationYazısı;

    @FindBy(xpath = "//select[@name='datatable_ajax_length']")
    public WebElement viewSelectDropDown;

    @FindBy(xpath = "//div[@class='table-scrollable']")
    public List<WebElement> lisOfReservationListesi;

    @FindBy(xpath = "//*[text()='Found total 226 records']")
    public WebElement foundTotalListeSayısı;

    @FindBy(xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;

    @FindBy(xpath = "//a[text()='List Of Hotelroomreservatıons']")
    public WebElement listOfHotelroomreservartions;

    @FindBy(id = "IDUser")
    public WebElement idUserDropdownu;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement idHotelRoomDropdownu;

    @FindBy(id = "Price")
    public WebElement pricetextBoxi;

    @FindBy(id = "DateStart")
    public WebElement dateStarttextBoxi;

    @FindBy(xpath = "(//button[@class='btn default'])[2]")
    public WebElement dateStartTakvimIkonu;

    @FindBy(xpath = "(//td[@class='day'])[2]")
    public WebElement dateStartTakvimi;

    @FindBy(xpath = "(//button[@class='btn default'])[3]")
    public WebElement dateEndTakvimIkonu;

    @FindBy(xpath = "(//td[@class='day'])[3]")
    public WebElement dateEndTakvimi;

    @FindBy(id = "DateEnd")
    public WebElement dateEndTextBoxi;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmountTextBoxi;

    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmountTextBoxi;

    @FindBy(id = "ContactNameSurname")
    public WebElement contactNameSurnameTextBoxi;

    @FindBy(id = "ContactPhone")
    public WebElement contactPhoneTextBoxi;

    @FindBy(id = "ContactEmail")
    public WebElement contactEmailTextBoxi;

    @FindBy(id = "Notes")
    public WebElement notesTextBoxi;

    @FindBy(xpath = "(//div[@class='form-group'])[12]")
    public WebElement approvedCheckbox;

    @FindBy(id = "Approved")
    public WebElement approvedCheckboxTiklamakIcin;

    @FindBy(id = "uniform-IsPaid")
    public WebElement isPaidCheckbox;

    @FindBy(id = "btnSubmit")
    public WebElement createHotelroomreservatıonSaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement roomReservationWasInsertedSuccesfullyYazisi;


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
        qaConcortPage.advancedSearchBasligiCheckinDateBoxUs010.clear();
        rm.waitFor(1);
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckinDateBoxUs010, "15/12/2021").perform();
        qaConcortPage.advancedSearchBasligiCheckoutDateBoxUs010.clear();
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckoutDateBoxUs010, "20/12/2021").perform();
        Select select = new Select(qaConcortPage.selectRoomTypeDropdownUs010);
        select.selectByVisibleText("Single");
        Select select1 = new Select(qaConcortPage.selectAdultCountDropdownUs010);
        select1.selectByVisibleText("1 Adult");
        Select select2 = new Select(qaConcortPage.childrenDropdownUs010);
        select2.selectByVisibleText("0 Children");
        rm.scrollInToWiew(qaConcortPage.searchButtonUs010);
        rm.waitFor(1);
        actions.sendKeys(qaConcortPage.locationTextBoxUs010, "USA").perform();
        rm.waitFor(1);
        actions.click(qaConcortPage.searchButtonUs010).perform();
        rm.waitFor(2);
        actions.click(qaConcortPage.bookNowUs010).perform();
    }

    @FindBy(xpath = "//h3[@class='heading mb-4']")
    public WebElement advancedSearchBasligi;

    @FindBy(xpath = "//h1[text()='Rooms']")
    public WebElement roomsSayfasiRoomsBasligi;

    @FindBy(id = "checkin_date")
    public WebElement advancedSearchBasligiCheckinDateBoxUs010;

    @FindBy(id = "checkout_date")
    public WebElement advancedSearchBasligiCheckoutDateBoxUs010;

    @FindBy(id = "IDRoomType")
    public WebElement selectRoomTypeDropdownUs010;

    @FindBy(id = "AdultCount")
    public WebElement selectAdultCountDropdownUs010;

    @FindBy(id = "ChildrenCount")
    public WebElement childrenDropdownUs010;

    @FindBy(id = "location")
    public WebElement locationTextBoxUs010;

    @FindBy(xpath = "(//div[@class='form-group'])[7]")
    public WebElement searchButtonUs010;

    @FindBy(xpath = "(//a[@class='btn-custom'])[1]")
    public WebElement bookNowUs010;

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
    public WebElement reservationWasMadeSuccessfullyUs010;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement thisFieldIsRequiredYazisiUs010;

    @FindBy(xpath = "//div[@class='col-md-12 room-single mt-4 mb-5 ftco-animate fadeInUp ftco-animated']")
    public WebElement theBestHotelInTheRegionYazisiUs010;

}

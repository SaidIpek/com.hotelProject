package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

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

//US0010 test locatorleri
    @FindBy (xpath = "(//a[@class='nav-link'])[2]")
    public WebElement AnaSayfaRoomsSecenegi;

    public void ConcortHotelRoomsGiris() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        Thread.sleep(1000);
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
      Thread.sleep(7000);
    }
    //Rooms sayfasi

    @FindBy (xpath = "//h1[text()='Rooms']")
    public WebElement roomsSayfasiRoomsBasligi;

    @FindBy (id = "checkin_date")
    public WebElement advancedSearchBasligiCheckinDateBox;

    @FindBy (id = "checkout_date")
    public WebElement advancedSearchBasligiCheckoutDateBox;

    @FindBy (id = "IDRoomType")
    public WebElement selectRoomTypeDropdown;

    @FindBy (id = "AdultCount")
    public WebElement selectAdultCountDropdown;

    @FindBy (id = "ChildrenCount")
    public WebElement childrenDropdown;

    @FindBy (id = "location")
    public WebElement locationTextBox;

    @FindBy (xpath = "(//div[@class='form-group'])[7]")
    public WebElement searchButton;

    @FindBy (linkText = "Book Now ")
    public WebElement bookNow;

    //List Of Rezervations sayfasi------------------------
    @FindBy(linkText = "System Management")
    public WebElement systemManagementSekmesi;

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementSekmesi;

    @FindBy(linkText = "Room reservations")
    public WebElement roomReservationsSekmesi;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfReservationYazısı;

    @FindBy(xpath = "(//*[text()=' Details'])[1]")
    public WebElement detailsButonu;

    @FindBy(linkText = "General Data")
    public WebElement generalDataBolumu;

    @FindBy(linkText = "Properties")
    public WebElement propertiesBolumu;

    @FindBy(className = "caption")
    public WebElement hotelRoomReservationDataBasligi;

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

    @FindBy(xpath = "(//*[text()='Save'])[1]")
    public WebElement roomReservationsSaveButonu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement roomReservationsDeleteButonu;

    @FindBy(id = "btnSubmit")
    public WebElement createHotelroomreservatıonSaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement roomReservationWasInsertedSuccesfullyYazisi;

}

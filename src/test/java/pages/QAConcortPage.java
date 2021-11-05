package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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



    //US0006-US0007 ortak alan locatorleri
    //Once ortak alan locatorlere bakilacak sonrasinda locate edilmediyse locate edilecek.
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementElementi;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsElementi;

    @FindBy(xpath = "//span[contains(text(), 'List')]")
    public WebElement listOfHotelRoomsElementi;



    public void hotelRooms(){
        Assert.assertTrue(hotelManagementElementi.isDisplayed());
       hotelManagementElementi.click();
        hotelRoomsElementi.click();
        Assert.assertTrue(listOfHotelRoomsElementi.isDisplayed(),"List Of Hotel Rooms element is not Displayed");

    }


    //US0007 test locatorleri

    @FindBy(xpath = "(//div[@class='caption'])[1]")
    public WebElement editHotelRoomElement;

    @FindBy(xpath = "//a[@href='#tab_general']")
    public WebElement generalDataElement;

    @FindBy(xpath = "(//div[@class='caption'])[2]")
    public WebElement hotelRoomDataElement;

    @FindBy(xpath = "//a[contains(text(), ' Details')]")
    public WebElement hotelDetailsButton;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement hotelRoomDataHotelDropDown;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement hotelRoomDateHotelCodeBox;

    @FindBy(xpath = "//div[@id='products']/div/ul/li[2]")
    public WebElement hotelRoomPriceDragDrop;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement hotelRoomPriceBox;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement hotelRoomDescriptionElement;

    @FindBy(id = "IDGroupRoomType")
    public WebElement hotelRoomRoomType;

    @FindBy(id = "IsAvailable")
    public WebElement hotelRoomIsAvailable;

    @FindBy(xpath = "(//button[@class='btn green'])[1]")
    public WebElement hotelRoomSaveButton;

    @FindBy(xpath = "(//div[text()='HotelRoom was updated successfully'])")
    public WebElement hotelRoomSuccess;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement hotelRoomOkButton;

    @FindBy(id = "btnDelete")
    public WebElement hotelRoomDeleteButton;



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

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement hotelRoomDeleteQuestion;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement hotelRoomDeleteMessage;

    @FindBy(className = "bootbox-body")
    public WebElement hotelRoomFailSaveMessage;



    public void details(){
        QAConcortPage qaConcortPage = new QAConcortPage();
        ArrayList<Integer>random=new ArrayList<>();
        int count=0;
        random.add(0);
        while (count<=3){
            Random rnd = new Random();
            int detail = rnd.nextInt(10) + 1;

            if (!random.contains(detail)){
                random.add(detail);
                Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).isDisplayed(),"Details Button is not Displayed");
                Assert.assertTrue( Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).isEnabled());
                Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();
                Assert.assertEquals(qaConcortPage.editHotelRoomElement.getText(), ConfigReader.getProperty("EditHotelRoomElementi"),"Edit Hotelroom element is not Displayed");
                Assert.assertTrue(qaConcortPage.generalDataElement.isDisplayed());
                Assert.assertEquals(qaConcortPage.hotelRoomDataElement.getText(),ConfigReader.getProperty("HotelRoomDataElementi"));
                Driver.getDriver().navigate().back();
                count++;
            }

        }
    }





}


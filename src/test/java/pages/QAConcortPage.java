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
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        qaConcortPage.loginButonu.click();
    }
    //US_0001 test Locatorlari

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement AnaSayfaHomeSecenegi;

    @FindBy(xpath = "(//a[@class='nav-link'])[3]")
    public WebElement AnaSayfaRestaurantSecenegi;

    @FindBy(xpath = "(//a[@class='nav-link'])[4]")
    public WebElement AnaSayfaAboutSecenegi;

    @FindBy(xpath = "(//a[@class='nav-link'])[5]")
    public WebElement AnaSayfaBlogSecenegi;

    @FindBy(xpath = "(//a[@class='nav-link'])[6]")
    public WebElement AnaSayfaContactSecenegi;

    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement AnaSayfaLoginSecenegi;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement AnaSayfaCONCORTHOTELYazisi;

    @FindBy(xpath = "//h1[text()='OurRestaurant']")
    public WebElement restaurantSayfasiOurRestaurantBasligi;

    @FindBy(xpath = "//h1[text()='About']")
    public WebElement aboutSayfasiAboutBasligi;

    @FindBy(xpath = "//h1[text()='Blog']")
    public WebElement blogSayfasiBlogBasligi;

    @FindBy(xpath = "//h1[text()='Contact Form']")
    public WebElement contactSayfasiContactFormBasligi;

    @FindBy(xpath = "//h1[text()='Log in']")
    public WebElement LoginSayfasiLoginBasligi;

    @FindBy(id = "checkin_date")
    public WebElement anaSayfaCheckinDateYazisi;

    @FindBy(id = "checkout_date")
    public WebElement anaSayfaCheckoutDateYazisi;

    @FindBy(id = "IDRoomType")
    public WebElement anaSayfaRoomTypeDropDown;

    @FindBy(id = "AdultCount")
    public WebElement anaSayfaAdultsDropDown;

    @FindBy(xpath = "//input[@value='Check Availability']")
    public WebElement CheckAvailabilityYazisi;

    @FindBy(xpath = "(//h2[@class='mb-4'])[1]")
    public WebElement WelcomeToOurHotelYazisi;

    @FindBy(xpath = "(//span[@class='icon-facebook'])[1]")
    public WebElement FacebookIcon1;

    @FindBy(xpath = "//span[@class='icon-google-plus']")
    public WebElement GoogleIcon;

    @FindBy(xpath = "(//span[@class='icon-instagram'])[1]")
    public WebElement InstagramIcon1;

    @FindBy(xpath = "(//a[@class='btn-custom'])[1]")
    public WebElement ilkViewRoomDetails;

    @FindBy(xpath = "//h1[@class='mb-4 bread']")
    public WebElement ilkRoomgirisSayfasiBasligi;

    @FindBy(xpath = "//h2[text()='Recent Blog']")
    public WebElement anasayfaRecentBlogYazisi;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 6']")
    public WebElement text6Yazisi;

    @FindBy(xpath = "//h1[text()='Blog6']")
    public WebElement Blog6Yazisi;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 5']")
    public WebElement text5Yazisi;

    @FindBy(xpath = "//h1[text()='Blog5']")
    public WebElement Blog5Yazisi;

    @FindBy(xpath = "//span[text()='Instagram']")
    public WebElement instagramYazisi;

    @FindBy(xpath = "(//div[@class='icon d-flex justify-content-center'])[2]")
    public WebElement instagramFoto2;

    @FindBy(xpath = "//img[@src='/FileStorage/2/13/35130insta-4.jpg']")
    public WebElement Foto2Ciktisi;

    @FindBy(xpath = "(//span[@class='icon-instagram'])[2]")
    public WebElement InstagramIcon2;

    @FindBy(xpath = "(//span[@class='icon-facebook'])[2]")
    public WebElement FacebookIcon2;

    @FindBy(xpath = "//span[@class='icon-twitter']")
    public WebElement twittericon;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[1]")
    public WebElement FooterBlogYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[2]")
    public WebElement FooterRoomYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[3]")
    public WebElement FooterAmenitiesYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[4]")
    public WebElement FooterGiftCardYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[5]")
    public WebElement FooterCareerYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[6]")
    public WebElement FooterAboutYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[7]")
    public WebElement FooterContactYazisi;

    @FindBy(xpath = "(//a[@class='py-2 d-block'])[8]")
    public WebElement FooterServiceYazisi;

    @FindBy(xpath = "(//span[@class='text'])[1]")
    public WebElement FooterAdress;

    @FindBy(xpath = "(//span[@class='text'])[2]")
    public WebElement FooterPhone;

    @FindBy(xpath = "(//span[@class='text'])[3]")
    public WebElement FooterEmail;


    //US_0003 test locatorleri

    @FindBy(xpath = " //span[text()='Create a new account']")
    public WebElement createAnewAccountbutonu;

    @FindBy(xpath = "//h2[@class='mb-4']")
    public WebElement registrationFormSayfası;

    @FindBy(xpath = "(//div[@class='form-group'])[1]")
    public WebElement registrationUsernameButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[2]")
    public WebElement registrationPasswordButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[3]")
    public WebElement registrationEmailButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[4]")
    public WebElement registrationFullnameButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[5]")
    public WebElement registrationPhoneNoButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[6]")
    public WebElement registrationSocialSecurityButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[7]")
    public WebElement registrationDrivingLicenseButonu;

    @FindBy(id = "IDCountry")
    public WebElement registrationSelectCountryDropdown;

    @FindBy(xpath = "(//div[@class='form-group'])[9]")
    public WebElement registrationSelectStateDropdown;

    @FindBy(id = "Address")
    public WebElement registrationAdressButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[11]")
    public WebElement registrationWorkingSectorButonu;

    @FindBy(xpath = "(//div[@class='form-group'])[12]")
    public WebElement registrationBirthDateDropdown;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement registrationSaveButonu;

    @FindBy(id = "IDState")
    public WebElement statesUSA;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement insertedSuccesfullyButonu;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement okButonu;

    @FindBy(id = "divMessage")
    public WebElement okButonuTıklandı;

//US_0004  Test Locatorlari

    @FindBy(linkText = "System Management")
    public WebElement US4OtelEklemeSystemManagementMenüsü;

    @FindBy(xpath = "//tbody")
    public WebElement US4OtelEklemeListOfUsersTablosu;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement US04HotelManagementMenüsü;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement US04HotelList;

    @FindBy(xpath = "//tbody")
    public WebElement US4OtelEklemeListOfHotelsTablosu;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement US4AddHotelButonu;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement US4CreateHotelYazisi;

    @FindBy(id = "Code")
    public WebElement US4CodeTextbox;

    @FindBy(id = "IDGroup")
    public WebElement US4IDGroupDropdown;

    @FindBy(id = "btnSubmit")
    public WebElement US4SaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement US4OtelBasariliEklendiYazisi;

    @FindBy(xpath = "//input[@name='IDHotel']")
    public WebElement USO4SearchIDHotelKutusu;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement US04SearchButonu;

    @FindBy(id = "datatable_ajax_info")
    public WebElement US04FoundYazisi;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement USO4SearchCodeKutusu;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement USO4SearchNameKutusu;

    @FindBy(xpath = "//input[@name='Address']")
    public WebElement USO4SearchAdressKutusu;

    @FindBy(xpath = "//input[@name='Phone']")
    public WebElement USO4SearchPhoneKutusu;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement USO4SearchEmailKutusu;

    @FindBy(id = "lkpGroups")
    public WebElement US4SearchIDGroupDropdown;

    //US0005 test locatorlari
    // hotel list sayfasi

    @FindBy (xpath = "//span[text()='System Management']")
    public WebElement systemManagementLinki;

    @FindBy (xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementLinki;

    @FindBy (xpath = "(//a[@href='/admin/HotelAdmin'])[1]")
    public WebElement hotelListLink;

    @FindBy (xpath = "//span[text()='List Of Hotels']")
    public WebElement ListOfHotelYAziElementi;

    @FindBy (xpath = "(//*[text()=' Details'])[1]")
    public WebElement detailsListButonu;

    @FindBy (xpath = "(//div[@class='caption'])[1]")
    public WebElement EditHotelListYAziElementi;

    @FindBy (xpath = "//*[@id=\"edit-form\"]/div/div[2]/div/ul/li[2]/a")
    public WebElement photosListLinki;

    @FindBy (xpath = "//a[text()='Properties']")
    public WebElement PropertiesListLinki;

    @FindBy (partialLinkText = "General Data")
    public WebElement GeneralDataListLinki;

    @FindBy (xpath = "(//div[@class='caption'])[2]")
    public WebElement HotelDataListLinki;

    @FindBy(xpath = "(//div[@class='col-md-2 name'])[1]")
    public WebElement codeListYazisi;

    @FindBy(xpath = "(//input[@class='form-control input-lg required'])[1]")
    public WebElement codeListTexBox;

    @FindBy (xpath ="(//div[@class='col-md-2 name'])[2]")
    public WebElement nameListYazisi;

    @FindBy (xpath ="(//*[@type='text'][1])")
    public WebElement nameListTextBoxi;

    @FindBy (xpath ="(//div[@class='col-md-2 name'])[3]")
    public WebElement AddressListYazisi;

    @FindBy (xpath ="//*[@title='Address']" )
    public WebElement AdressListTextBoxi;

    @FindBy (xpath ="(//div[@class='col-md-2 name'])[4]")
    public WebElement phoneYazisi;

    @FindBy (xpath = "//*[@title='Phone']")
    public WebElement phoneListTextBoxi;

    @FindBy(xpath = "//input[@value='josue.bradtke@gmail.com']")
    public WebElement EmailListTextBoxi;

    @FindBy(id = "//*[@id='IDGroup']")
    public WebElement GroupDropDownListBoxi;

    @FindBy(xpath = "(//button[@class='btn green'])[1]")
    public WebElement hotelDataListSaveButonu;

    @FindBy(xpath = "(//i[@class='fa fa-check'])[1]")
    public WebElement saveListIkonu;

    @FindBy(xpath = "//*[text()='Hotel was updated successfully']")
    public WebElement hotelDataListSuccesfullYazisi;

    @FindBy(xpath = "//*[text()='OK'")
    public WebElement alertOKListButonu;

    @FindBy(id = "btnDelete")
    public WebElement deleteListButonu;

    @FindBy (xpath = "(//div[@class='caption'])[4]")
    public WebElement deleteHotelYaziElementi;

    @FindBy(xpath = "//a[@class='collapse']")
    public WebElement deleteListIkonu;

    //US006test locatorleri

    @FindBy(linkText = "Hotel Management")
    public WebElement hotelManagementButonu;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsButonu;

    @FindBy(linkText = "List Of Hotelrooms")
    public WebElement listOfHotelroomsLinki;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomButonu;

    @FindBy(xpath = "//div[@class='portlet-title']")
    public WebElement createHotelRoomUstYazisi;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='Location']")
    public WebElement locationBolumuInCreateHotelRoom;

    @FindBy(xpath = "//div[@id='cke_1_contents']")
    public WebElement descriptionBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement priceBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='MaxAdultCount']")
    public WebElement maxAdultCountBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='MaxChildCount']")
    public WebElement maxChildCountBolumuInCreateHotelRoom;

    @FindBy(xpath = "//input[@id='IsAvailable']")
    public WebElement isAvailableBolumuInCreateHotelRoom;

    @FindBy(xpath = " //button[@id='btnSubmit']")
    public WebElement saveButonuInCreateHotelRoom;

    @FindBy(xpath = "//li[@data-id='200']")
    public WebElement priceDrop200;

    @FindBy(xpath = "//li[@data-id='300']")
    public WebElement priceDrop300;

    @FindBy(xpath = "//li[@data-id='400']")
    public WebElement priceDrop400;

    @FindBy(xpath = "//li[@data-id='500']")
    public WebElement priceDrop500;

    @FindBy(xpath = "//li[@data-id='600']")
    public WebElement priceDrop600;

    @FindBy(xpath = "//li[@data-id='700']")
    public WebElement priceDrop700;

    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement dropDownMenuListOfHotelRooms;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement codeBolumuListOfHotelRooms;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement nameBolumuListOfHotelRooms;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButonuListOfHotelRooms;


    //US0007 test locatorleri

    public void hotelRooms(){
        Assert.assertTrue(hotelManagementElementi.isDisplayed());
        hotelManagementElementi.click();
        hotelRoomsElementi.click();
        Assert.assertTrue(listOfHotelRoomsElementi.isDisplayed(),"List Of Hotel Rooms element is not Displayed");
    }

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementElementi;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsElementi;

    @FindBy(xpath = "//span[contains(text(), 'List')]")
    public WebElement listOfHotelRoomsElementi;

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


    //US_0009 test locatorleri

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

    @FindBy(linkText = "System Management")
    public WebElement systemManagementSekmesi;

    @FindBy(xpath = "(//*[text()=' Details'])[1]")
    public WebElement detailsButonu;

    @FindBy(linkText = "General Data")
    public WebElement generalDataBolumu;

    @FindBy(linkText = "Properties")
    public WebElement propertiesBolumu;

    @FindBy(className = "caption")
    public WebElement hotelRoomReservationDataBasligi;

    @FindBy(xpath = "(//*[text()='Save'])[1]")
    public WebElement roomReservationsSaveButonu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement roomReservationsDeleteButonu;

    //US0010 test locatorleri

    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement AnaSayfaRoomsSecenegi;


    //Rooms sayfasi

    public void ConcortHotelRoomsGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
    }

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


}








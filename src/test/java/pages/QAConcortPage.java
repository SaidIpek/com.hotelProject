package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

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

    //US0006 test locatorleri


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

    //US0008-US0009 ortak alan locatorleri
    //Once ortak alan locatorlere bakilacak sonrasinda locate edilmediyse locate edilecek.


    //US0008 test locatorleri


    //US0009 test locatorleri


    //US0010 test locatorleri
    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement AnaSayfaRoomsSecenegi;

    public void ConcortHotelRoomsGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
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
        Select select1 = new Select(qaConcortPage.selectAdultCountDropdown);
        select1.selectByVisibleText("1 Adult");
        Select select2 = new Select(qaConcortPage.childrenDropdown);
        select2.selectByVisibleText("0 Children");
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

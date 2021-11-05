package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

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

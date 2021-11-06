package tests.us0003;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


//3-Textboxlar kullanici bilgilerini kabul edebilir olmali
//a-Kullanıcı concorthotel sayfasına girebilir, create a new account butonuna tıklayabilir,Registration Form sayfasını görebilmeli.
//b-Username,Password,Email ,Full Name,Phone No,Sosial Security Number,
// Driving Licence,Adress,Working Sector butonuna tıklanabilmeli ve veri girişi yapılabilmeli
//password=Manager1!, Email=hotelteam.05@gmail.com
//FullName=Berrin Kose Phone=11223344, Sosial s. Number=678
//Drivig licence=B Address=Çankaya/Ankara ,Working Sector=IT
//FullName=Berrin Kose Phone=11223344, Sosial s. Number=679
//Country=Türkiye, State=-,Birth day=17-09
//c-Country , State ve Birth Day butonlarına tıklanabilmeli ve seçim yapılabilmeli.

public class Tc_003 {
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage concortHotelPage = new QAConcortPage();
        Actions actions= new Actions(Driver.getDriver());
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.createAnewAccountbutonu.click();
        Assert.assertTrue(concortHotelPage.registrationFormSayfası.isDisplayed());
        Faker faker = new Faker();
        String usernameFaker =faker.name().username();
        System.out.println(usernameFaker);
        String passwordFaker ="Manager.7"+faker.internet().password();
        System.out.println(passwordFaker);
        Actions actions1 = new Actions(Driver.getDriver());
        actions.sendKeys(concortHotelPage.registrationUsernameButonu,usernameFaker)
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationPasswordButonu,passwordFaker)
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationEmailButonu,faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationFullnameButonu,faker.name().fullName()).perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB)
                .sendKeys("1231231234").perform();
        Thread.sleep(2000);

        actions.sendKeys(concortHotelPage.registrationSocialSecurityButonu,"678-98-8907")
                .sendKeys(concortHotelPage.registrationDrivingLicenseButonu,"B").perform();
        ReusableMethods reusableMethods = new ReusableMethods();
        reusableMethods.scrollInToWiew(concortHotelPage.registrationSaveButonu);
        Select select=new Select(concortHotelPage.registrationSelectCountryDropdown);
        select.selectByVisibleText("United States");
        Select select1=new Select(concortHotelPage.statesUSA);
        select1.selectByVisibleText("Florida");
        concortHotelPage.registrationAdressButonu.sendKeys(faker.address().state());
        actions
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationAdressButonu,faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationWorkingSectorButonu,faker.job().field())
                .sendKeys(Keys.TAB)
                .sendKeys(concortHotelPage.registrationBirthDateDropdown,faker.date().birthday().toString())
                .perform();
    }
}

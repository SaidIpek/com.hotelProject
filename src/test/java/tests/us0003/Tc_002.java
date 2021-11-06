package tests.us0003;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
//2-"Registration Form" sayfasi gorunur olmalı
//a-Kullanıcı concorthotel sayfasına gidebilmeli ve create a new account butonuna tıklayabilmeli.
//b-Kullanıcı Registration Form sayfasını görebilmeli.
public class Tc_002 {
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage concortHotelPage = new QAConcortPage();
        concortHotelPage.ilkLoginLinki.click();
        concortHotelPage.createAnewAccountbutonu.click();
        Assert.assertTrue(concortHotelPage.registrationFormSayfası.isDisplayed());
        Driver.closeDriver();
    }
}

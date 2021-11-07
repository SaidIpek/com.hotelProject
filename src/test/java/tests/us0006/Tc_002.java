package tests.us0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_002 {

    //"Add Hotel Room" butonu gorulur, tiklanabilir ve dogru sayfaya yönlendirebiliyor olmali

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        qaConcortPage.hotelManagementButonu.click();
        qaConcortPage.hotelRoomsButonu.click();
        qaConcortPage.addHotelRoomButonu.click();
        Assert.assertTrue(qaConcortPage.createHotelRoomUstYazisi.isDisplayed(), "Create Hotelroom yazisi gorulmedi");
        Driver.closeDriver();
    }
}


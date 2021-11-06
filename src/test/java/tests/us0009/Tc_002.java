package tests.us0009;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_002{

    @Test
    public void test(){

        QAConcortPage qaConcortPage = new QAConcortPage();

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));


        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        qaConcortPage.loginButonu.click();


        WebElement dropDown = qaConcortPage.systemManagementSekmesi;

        qaConcortPage.hotelManagementSekmesi.click();

        qaConcortPage.roomReservationsSekmesi.click();

        qaConcortPage.detailsButonu.click();

        Assert.assertTrue(qaConcortPage.generalDataBolumu.isDisplayed());

        Assert.assertTrue(qaConcortPage.propertiesBolumu.isDisplayed());

        Assert.assertTrue(qaConcortPage.hotelRoomReservationDataBasligi.isDisplayed());

        Driver.closeDriver();
    }
}

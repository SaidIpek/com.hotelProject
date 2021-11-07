package tests.us0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {

    // "Hotel Rooms" yazisi gorulur ve tiklanabilir olmali

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys("manager");
        qaConcortPage.passwordKutusu.sendKeys("Manager1!");
        qaConcortPage.loginButonu.click();
        qaConcortPage.hotelManagementButonu.click();
        qaConcortPage.hotelRoomsButonu.click();
        Assert.assertTrue(qaConcortPage.listOfHotelroomsLinki.isDisplayed(), " List of Hotel yazisi gorunmedi ");

        Driver.closeDriver();
    }
}

package tests.us0003;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage concortHotelPage = new QAConcortPage();

        concortHotelPage.ilkLoginLinki.click();

        concortHotelPage.usernameKutusu.sendKeys("manager");

        concortHotelPage.passwordKutusu.sendKeys("Manager1!");
        concortHotelPage.loginButonu.click();
        Assert.assertTrue(concortHotelPage.createAnewAccountbutonu.isDisplayed());
        Driver.closeDriver();
    }
}
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

        Assert.assertTrue(concortHotelPage.createAnewAccountbutonu.isDisplayed());
        Assert.assertTrue(concortHotelPage.createAnewAccountbutonu.isEnabled());

        Driver.closeDriver();
    }
}
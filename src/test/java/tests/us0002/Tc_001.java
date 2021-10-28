package tests.us0002;

import org.testng.annotations.Test;
import pages.QAConcortHotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001   {

    @Test
    public void test () throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        qaConcortHotelPage.ConcortHotelLogin();
        Driver.closeDriver();

    }
}

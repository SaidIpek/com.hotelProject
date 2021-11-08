package tests.us0010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_001 {

    // 1) Rooms sayfasina girilebilmeli.

    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        Assert.assertTrue(qaConcortPage.AnaSayfaRoomsSecenegi.isDisplayed(), "Ana Sayfa navbardaki Rooms secenegi gorunmuyor!");
        qaConcortPage.AnaSayfaRoomsSecenegi.click();
        ReusableMethods.waitForVisibility(qaConcortPage.roomsSayfasiRoomsBasligi, 10);
        Assert.assertTrue(qaConcortPage.roomsSayfasiRoomsBasligi.isDisplayed(), "Rooms sayfasindaki rooms basligi gorunmuyor!");

        Driver.closeDriver();
    }
}

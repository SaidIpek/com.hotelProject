package tests.us0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;


public class Tc_001 {




        // 1) Rooms sayfasina girilebilmeli.
        @Test
        public void test () throws InterruptedException {
            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
            QAConcortPage qaConcortPage = new QAConcortPage();
            qaConcortPage.AnaSayfaRoomsSecenegi.click();
            Assert.assertTrue(qaConcortPage.roomsSayfasiRoomsBasligi.getText().equals("Rooms"),"Rooms sayfasindaki rooms basligi gorunmuyor!");
            Driver.closeDriver();
        }

}

package tests.us0004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_003 {
    @Test
    public void test() throws InterruptedException {

        // 1- Sag ustte bulunan add hotel butonuna tiklar
        QAConcortPage qaConcortPage= new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.US04HotelManagementMenüsü.click();
        Thread.sleep(2000);
        qaConcortPage.US04HotelList.click();
        qaConcortPage.US4AddHotelButonu.click();

        // 2- Create Hotel sayfasini gorebilir
        Assert.assertTrue(qaConcortPage.US4CreateHotelYazisi.isDisplayed());

        Driver.closeDriver();
    }



}

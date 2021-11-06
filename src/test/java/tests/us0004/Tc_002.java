package tests.us0004;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_002 {
    @Test
    public void test() throws InterruptedException {

        // 1-Acilan sayfada sol menuden "System Management" menusunun altindaki
        // "Hotel Management" sekmesine  tiklar
        QAConcortPage qaConcortPage= new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();
        Thread.sleep(2000);

        qaConcortPage.US04HotelManagementMenüsü.click();

        // 2-Ardindan "Hotel List" secenegine tiklar.
        qaConcortPage.US04HotelList.click();

        // "LIST OF HOTEL" sayfasinda otel listesinin tablosu gorunmeli
        Assert.assertTrue(qaConcortPage.US4OtelEklemeListOfHotelsTablosu.isDisplayed());

        Driver.closeDriver();

    }
}

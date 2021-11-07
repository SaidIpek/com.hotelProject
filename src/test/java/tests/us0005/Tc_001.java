package tests.us0005;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_001 {
    //TC-001 "System Management" Menusunun icerisinde "Hotel List" sekmesi gorunmeli ,
    // tiklanilabilmeli ve acilan sayfada "LIST OF HOTELS" table'i gorunmeli
    // 1-Kullanici Concort Hotel (Admin) sayfasina gider.
    //  2-Sag ustte log in butonunu tiklar ardindan Username ve Sifre girilmeli
    // 3-Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
    //  4-Ardindan "Hotel List" secegine tiklar.
    //  5-Acilan sayfada "LIST OF HOTELS" yazisi gorunmeli
    @Test
    public  void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        ReusableMethods.waitForClickablility( qaConcortPage.hotelManagementLinki,10);
        qaConcortPage.hotelManagementLinki.click();
        ReusableMethods.waitForClickablility( qaConcortPage.hotelListLink,10);
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
   Driver.closeDriver();
    }

}

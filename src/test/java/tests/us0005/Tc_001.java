package tests.us0005;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class Tc_001 {
    //TC-001 "System Management" Menusunun icerisinde "Hotel List" sekmesi gorunmeli ,
    // tiklanilabilmeli ve acilan sayfada "LIST OF HOTELS" table'i gorunmeli
    // 1-Kullanici Concort Hotel (Admin) sayfasina gider.
    //  2-Sag ustte log in butonunu tiklar ardindan Username ve Sifre girilmeli
    // 3-Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
    //  4-Ardindan "Hotel List" secegine tiklar.
    //  5-Acilan sayfada "LIST OF HOTELS" yazisi gorunmeli
    @Test
    public  void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        // 3-Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
//        Actions actions = new Actions(Driver.getDriver());
//        Thread.sleep(5000);
//        actions.click(qaConcortPage.systemManagementLinki).perform();
//        actions.moveToElement(qaConcortPage.systemManagementLinki).perform();
//        Thread.sleep(10000);
//
//        actions.moveToElement(qaConcortPage.hotelManagementLinki).perform();
//        actions.click(qaConcortPage.hotelManagementLinki).perform();
//        Thread.sleep(10000);
//        //  4-Ardindan "Hotel List" secegine tiklar.
//
//        actions.moveToElement(qaConcortPage.hotelListLink).perform();
//        actions.click(qaConcortPage.hotelListLink).perform();
//        Thread.sleep(5000);
        //  5-Acilan sayfada "LIST OF HOTELS" yazisi gorunmeli
        Actions actions = new Actions(Driver.getDriver());
        //actions.click(qaConcortPage.systemManagementLinki).perform();
        //  actions.contextClick().perform();
        // qaConcortPage.menuAcilisIkonu.click();
        // qaConcortPage.menuAcilisOku.click();
        Thread.sleep(5000);
        qaConcortPage.hotelManagementLinki.click();
        Thread.sleep(5000);
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
   Driver.closeDriver();
    }

}

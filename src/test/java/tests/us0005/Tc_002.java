
    package tests.us0005;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
    public class Tc_002 {
        /*US-2 -Tabloda bulunan "Details" Butonunun gorulebilir ve tiklanabilir olmasi gerekir, Acilacak olan sayfada ise "Edit Hotel" yazisi gorunmeli,
        "General Data","Photos","Properties" sekmeleri bulunmali
         TC-002
         1-Kullanici Concort Hotel (Admin) sayfasina gider.
         2-Sag ustte log in butonunu tiklar ardindan Username ve Sifre girilmeli
         3-Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
         4-Ardindan "Hotel List" secegine tiklar.
         5-"LIST OF HOTELS" tablosunda bulunan "DETAILS"  butonu gorulmeli ardindan tiklanmali
         6-"Edit Hotel" basliginin altinda "General Data", "Photos", "Properties" bolumleri bulunmali
         ve tiklanabilir olmali
         7-Acilacak "Edit Hotel" sayfasinda "Hotel Data" bolumu bulunmali
       */
        @Test
        public void test() throws InterruptedException {
            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
            QAConcortPage qaConcortPage = new QAConcortPage();
            Thread.sleep(2000);
            qaConcortPage.ConcortHotelLogin();
//            Actions actions = new Actions(Driver.getDriver());
//            Thread.sleep(5000);
//            qaConcortPage.hotelManagementLinki.click();
//            Thread.sleep(5000);
//            qaConcortPage.hotelListLink.click();
//            Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
//            Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
//            Assert.assertTrue(qaConcortPage.detailsButonu.isDisplayed(),"detail yazisi gorunmuyor");
//            qaConcortPage.detailsButonu.click();
//            Thread.sleep(5000);
//            Assert.assertTrue(qaConcortPage.GeneralDataListLinki.isDisplayed(),"general data yazisi bulunmuyor");
//            qaConcortPage.photosListLinki.click();
//            Assert.assertTrue(qaConcortPage.photosListLinki.isDisplayed(),"photos yazisi bulunmuyor");
//            qaConcortPage.photosListLinki.click();
//            Assert.assertTrue(qaConcortPage.PropertiesListLinki.isDisplayed(),"properties yazisi bulunmuyor");
//            qaConcortPage.PropertiesListLinki.click();
//            Assert.assertTrue(qaConcortPage.EditHotelListYAziElementi.isDisplayed(),"Edit Hotel YAzi Elementi bulunmuyor");
//            Assert.assertTrue(qaConcortPage.HotelDataListLinki.isDisplayed()," Hotel Data Yazi Elementi bulunmuyor");
   Driver.closeDriver();
        }


    }



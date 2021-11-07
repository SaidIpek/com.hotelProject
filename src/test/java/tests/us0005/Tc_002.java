
    package tests.us0005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

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
        public void test() {
            Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
            QAConcortPage qaConcortPage = new QAConcortPage();
            qaConcortPage.ConcortHotelLogin();
            ReusableMethods.waitForClickablility(qaConcortPage.hotelManagementLinki, 10);
            qaConcortPage.hotelManagementLinki.click();
            ReusableMethods.waitForClickablility(qaConcortPage.hotelListLink, 10);
            qaConcortPage.hotelListLink.click();

            Assert.assertTrue(qaConcortPage.detailsButonu.isDisplayed(), "details yazisi gorunmuyor");
            qaConcortPage.detailsButonu.click();

            String ilkHandle = Driver.getDriver().getWindowHandle();
            Set<String> set = Driver.getDriver().getWindowHandles();
            String ikinciHandle = "";
            for (String w : set
            ) {
                if (!w.equals(ilkHandle)) {
                    ikinciHandle = w;
                }
            }

            Driver.getDriver().switchTo().window(ikinciHandle);
            Assert.assertTrue(qaConcortPage.GeneralDataListLinki.isDisplayed(), "general data yazisi bulunmuyor");
            Assert.assertTrue(qaConcortPage.GeneralDataListLinki.isEnabled(), "general data yazisi etkin degil");
            Assert.assertTrue(qaConcortPage.photosListLinki.isDisplayed(), "photos yazisi bulunmuyor");
            Assert.assertTrue(qaConcortPage.photosListLinki.isEnabled(), "photos yazisi etkin degil");
            Assert.assertTrue(qaConcortPage.PropertiesListLinki.isDisplayed(), "properties yazisi bulunmuyor");
            Assert.assertTrue(qaConcortPage.PropertiesListLinki.isEnabled(), "properties yazisi etkin degil");

            Assert.assertTrue(qaConcortPage.EditHotelListYAziElementi.isDisplayed(), "Edit Hotel YAzi Elementi bulunmuyor");
            Assert.assertTrue(qaConcortPage.HotelDataListLinki.isDisplayed(), " Hotel Data Yazi Elementi bulunmuyor");

            Driver.closeDriver();
        }
    }



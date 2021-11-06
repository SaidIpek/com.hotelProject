package pages.us0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {
    //1) Kullanici Concort Hotel sayfasina gider.
    //2) Sayfanin ust kisminda bulunan butonlar gorunur durumdadir.
    //3) Istenilen butona tiklanildiginda ilgili yere yonlendirir.
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.AnaSayfaAboutSecenegi.click();
        Assert.assertTrue(qaConcortPage.aboutSayfasiAboutBasligi.isDisplayed());


        qaConcortPage.AnaSayfaHomeSecenegi.click();
        Assert.assertTrue(qaConcortPage.AnaSayfaCONCORTHOTELYazisi.isDisplayed());

        qaConcortPage.AnaSayfaRoomsSecenegi.click();
        Assert.assertTrue(qaConcortPage.roomsSayfasiRoomsBasligi.isDisplayed());

        qaConcortPage.AnaSayfaRestaurantSecenegi.click();
        Assert.assertTrue(qaConcortPage.restaurantSayfasiOurRestaurantBasligi.isDisplayed());
        Thread.sleep(2000);




        qaConcortPage.AnaSayfaBlogSecenegi.click();
        Assert.assertTrue(qaConcortPage.blogSayfasiBlogBasligi.isDisplayed());

        qaConcortPage.AnaSayfaContactSecenegi.click();
        Assert.assertTrue(qaConcortPage.contactSayfasiContactFormBasligi.isDisplayed());

        qaConcortPage.AnaSayfaLoginSecenegi.click();
        Assert.assertTrue(qaConcortPage.LoginSayfasiLoginBasligi.isDisplayed());

        Driver.closeDriver();

    }
}


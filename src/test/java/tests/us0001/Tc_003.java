package pages.us0001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_003 {

    @Test
    public void test3() throws InterruptedException {


        //1) Ekranin sol ust kisminda bulunan Concort Hotel yazisina tiklanip ana sayfaya geri gelinir.
        //2) Ana sayfada asagiya inilir ve "Welcome To Our Hotel" yazisi gorunur.
        //3) "Welcome To Our Hotel" yazisinin sol altinda sosyal medya ikonlari tiklanip test edilir.
        //4) Ana sayfada asagiya inilmeye devam edilir ve "Our Rooms" yazisi gorunur.
        //5) "Our Rooms" yazisi altindaki odalar tiklanir ve test  edilir.

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.AnaSayfaCONCORTHOTELYazisi.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(qaConcortPage.WelcomeToOurHotelYazisi.isDisplayed());

        qaConcortPage.FacebookIcon1.click();
        qaConcortPage.GoogleIcon.click();
        qaConcortPage.InstagramIcon1.click();


        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        qaConcortPage.ilkViewRoomDetails.click();
        Assert.assertTrue(qaConcortPage.ilkRoomgirisSayfasiBasligi.isDisplayed());

        Driver.closeDriver();








    }
}

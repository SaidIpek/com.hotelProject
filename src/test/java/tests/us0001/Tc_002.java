package pages.us0001;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_002 {

    //  1) Ekranin sol ust kisminda bulunan Concort Hotel yazisina tiklanip ana sayfaya geri gelinir.
//2) Sayfanin ortasinda bulunan rezervasyon kutulari gorunur durumdadir.
//3) Rezervasyon kutularinda gerekli bilgiler girilir.
//4) "Check availability " butonuna tiklanir  ve Rooms sayfasina yonlendirilir.

    @Test
    public void test2() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.AnaSayfaCONCORTHOTELYazisi.click();

        qaConcortPage.anaSayfaCheckinDateYazisi.click();

        qaConcortPage.anaSayfaCheckoutDateYazisi.click();

        Select select1=new Select(qaConcortPage.anaSayfaAdultsDropDown);
        select1.selectByValue(ConfigReader.getProperty("CHQAAdults"));

        Select select=new Select(qaConcortPage.anaSayfaRoomTypeDropDown);
        select.selectByValue(ConfigReader.getProperty("CHQARoomType"));

        qaConcortPage.CheckAvailabilityYazisi.click();
        Assert.assertTrue(qaConcortPage.roomsSayfasiRoomsBasligi.isDisplayed());





        Driver.closeDriver();








    }
}

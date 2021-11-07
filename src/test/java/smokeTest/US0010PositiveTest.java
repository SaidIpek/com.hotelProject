package smokeTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US0010PositiveTest {

    /* Kullanicinin onceden olusturdugu hesap bilgileriyle sisteme giris yapabildigini test edelim.
    username=kullanici
    password=Kullanici1!
     */

    @Test
    public void test() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciPassword"));
        ReusableMethods.waitForClickablility(qaConcortPage.loginButonu, 5);
        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.theBestHotelInTheRegionYazisiUs010.isDisplayed(), "The best hotel in the region yazisi gorunmuyor!");
        Driver.closeDriver();
    }
}

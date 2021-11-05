package smokeTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US0010PositiveTest {

    /* Kullanicinin onceden olusturdugu hesap bilgileriyle sisteme giris yapabildigini test edelim.
    username=kullanici
    password=Kullanici1!
     */

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciPassword"));
        wait.until(ExpectedConditions.elementToBeClickable(qaConcortPage.loginButonu));
        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.theBestHotelInTheRegionYazisiUs010.isDisplayed(), "The best hotel in the region yazisi gorunmuyor!");
       Driver.closeDriver();
    }
}

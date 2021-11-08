package tests.us0005;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class Tc_005 {

    //TC-0005- "General Data" kisminda "Delete Hotel" yazisinin gorulebilir ve "Delete"  butonu tiklanilabilir olmali
    //ardindan"Hotel successfully deleted" yazisi gorunmeli ve "ok" butonuna tiklanilabilmeli
    //6-Tekrar "DETAILS" kisminda "General Data" bolumune gidilir
    //7-"Delete Hotel" Kisminda "DELETE" butonu gorunur olmali
    //8-"DELETE' butonuna tiklanilmali
    //9-"Hotel successfully deleted" yazisi gorunmeli ve ardindan "OK" butonuna basilmali

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.detailsButonu.click();

        String ilkHandle = Driver.getDriver().getWindowHandle();
        Set<String> set = Driver.getDriver().getWindowHandles();
        String ikinciHandle="";
        for (String w:set
        ) {
            if (!w.equals(ilkHandle)) {
                ikinciHandle=w;
            }
        }

        Driver.getDriver().switchTo().window(ikinciHandle);
        ReusableMethods.scrollDown();
        Assert.assertTrue(qaConcortPage.deleteListButonu.isDisplayed());
        qaConcortPage.deleteListButonu.click();
        ReusableMethods.waitForVisibility(qaConcortPage.wouldULikeToContinue,5);
       Assert.assertTrue(qaConcortPage.wouldULikeToContinue.isDisplayed());
        qaConcortPage.alertOk2.click();

        Driver.closeDriver();
    }
}

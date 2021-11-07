package tests.us0005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class Tc_004 {

    //TC-004- sistem mesaji olarak "Hotel was updated successfully" yazisi gorunmeli, "ok" butonuna tiklanilabilmeli
//6-"Hotel Data" bolumunde butun bilgiler girilir
//7-"Save" butonuna tiklanir ve HTML kodu ile yazilmis sistem mesaji cikar.
//8-"Hotel was updated successfully" yazisi gorulmeli
//9-"OK" butonu tiklanilabilmeli

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue(qaConcortPage.ListOfHotelYAziElementi.isDisplayed(), "list hotel yazisi gorunmuyor");
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
        qaConcortPage.hotelDataListSaveButonu.click();
        qaConcortPage.hotelDataListSuccesfullYazisi.isDisplayed();
        Assert.assertTrue(qaConcortPage.alertOKListButonu.isEnabled());
        qaConcortPage.alertOKListButonu.click();

        Driver.closeDriver();
    }
}
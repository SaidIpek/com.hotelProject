package tests.us0005;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
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
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(5000);
        qaConcortPage.hotelManagementLinki.click();
        Thread.sleep(5000);
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
        actions.sendKeys(qaConcortPage.detailsListButonu)
                .sendKeys(qaConcortPage.GeneralDataListLinki)
                .sendKeys(qaConcortPage.deleteListIkonu)
                .sendKeys(qaConcortPage.deleteListButonu)
                .perform();
        Assert.assertTrue(qaConcortPage.deleteListButonu.isDisplayed());
        qaConcortPage.deleteListButonu.click();
        // Assert.assertTrue();
        //Actions actions1 = new Actions(Driver.getDriver());
        // actions.contextClick().perform();
        Driver.closeDriver();
    }
}

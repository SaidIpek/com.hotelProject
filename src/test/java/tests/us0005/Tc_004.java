package tests.us0005;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
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
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(5000);
        qaConcortPage.hotelManagementLinki.click();
        Thread.sleep(5000);
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue(qaConcortPage.ListOfHotelYAziElementi.isDisplayed(), "list hotel yazisi gorunmuyor");
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Actions actions1 = new Actions(Driver.getDriver());
        // actions.moveToElement(qaConcortPage.hotelDataSaveButonu).click();
        actions.sendKeys(qaConcortPage.hotelDataListSaveButonu).click();
        //Thread.sleep(1000);
        // qaConcortPage.hotelDataSaveButonu.click();
        // Assert.assertTrue(qaConcortPage.hotelDataSaveButonu.isDisplayed(),"save butonu gorunmuyor");
        //    Thread.sleep(1000);
        // actions
        //   .sendKeys(qaConcortPage.HotelDataLinki)
        //   .sendKeys(qaConcortPage.hotelDataSaveButonu)
        //   .sendKeys(qaConcortPage.saveIkonu)
        //   .perform();
        //  qaConcortPage.saveIkonu.click();
        //  System.out.println(qaConcortPage.hotelDataListSuccesfullYazisi.getText());
        //   Assert.assertTrue(qaConcortPage.hotelDataListSuccesfullYazisi.isDisplayed());
        //10. OK butonuna tıklayın.
        //qaConcortPage.alertOKListButonu.click();
        Driver.closeDriver();
    }
}

package tests.us0004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {

    @Test
    public void test() throws InterruptedException {

        // 1-Kullanici Concort Hotel (Admin) sayfasina gider.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        // 2-Sag ustte log in butonunu tiklar ardindan Username ve Password
        // bilgilerini girer
        QAConcortPage qaConcortPage = new QAConcortPage();
        Thread.sleep(2000);
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();

        // 3-Acilan sayfada sol tarafta System Management menusunu ve
        // sag tarafta liste seklinde  LISTOFUSERS tablosunu gorebilir
        Assert.assertTrue(qaConcortPage.US4OtelEklemeSystemManagementMenüsü.isDisplayed());
        Assert.assertTrue(qaConcortPage.US4OtelEklemeListOfUsersTablosu.isDisplayed());


        Driver.closeDriver();
    }
}

package tests.us0005;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;
public class Tc_003 {

    /*
    1-Kullanici Concort Hotel (Admin) sayfasina gider.
2-Sag ustte log in butonunu tiklar ardindan Username ve Sifre girilmeli
3-Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
4-Ardindan "Hotel List" secegine tiklar.
5-"LIST OF HOTELS" tablosunda bulunan "DETAILS"  butonu gorulmeli ardindan tiklanmali
 6-"Code" textbox'i gorunmeli ve degistirilebilmeli.
 7-"Name" textbox'i gorunmeli ve degistirilebilmeli.
8-"Adress" textbox'i gorunmeli ve degistirilebilmeli.
9-"Phone" textbox'i gorunmeli ve degistirilebilmeli.
10-"Email" textbox'i gorunmeli ve degistirilebilmeli.
11-"Group" dropDown'i gorunmeli ve secilebilir olmali
12-"Save" butonu gorunmeli ve tiklanilabilmeli.
     */

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys("manager");
        qaConcortPage.passwordKutusu.sendKeys("Manager1!");
        qaConcortPage.loginButonu.click();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        Assert.assertTrue(qaConcortPage.detailsListButonu.isDisplayed(), "Details butonu gorunmuyor");
        qaConcortPage.detailsListButonu.click();
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
        Assert.assertTrue(qaConcortPage.codeListYazisi.isDisplayed());
        qaConcortPage.codeListTexBox.clear();
        qaConcortPage.codeListTexBox.sendKeys("34");

        Assert.assertTrue(qaConcortPage.nameListYazisi.isDisplayed());
        qaConcortPage.nameListTextBoxi.clear();
        qaConcortPage.nameListTextBoxi.sendKeys("OnurEnes");

        Assert.assertTrue(qaConcortPage.AddressListYazisi.isDisplayed());
        qaConcortPage.AdressListTextBoxi.clear();
        qaConcortPage.AdressListTextBoxi.sendKeys("Istanbul");

        Assert.assertTrue(qaConcortPage.phoneYazisi.isDisplayed());
        qaConcortPage.phoneListTextBoxi.clear();
        qaConcortPage.phoneListTextBoxi.sendKeys("+1 2334 73321");

        Assert.assertTrue(qaConcortPage.emailListYazisi.isDisplayed());
        qaConcortPage.EmailListTextBoxi.clear();
        qaConcortPage.EmailListTextBoxi.sendKeys("34Istanbul@hotmail.com");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

       qaConcortPage.hotelDataListSaveButonu.click();

        Driver.closeDriver();
    }
}
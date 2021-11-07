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
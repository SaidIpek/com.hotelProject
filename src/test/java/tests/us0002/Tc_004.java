package tests.us0002;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_004 {
    //4-Log in butonu gorunur, tiklanabilir olmali ve basarili giris yapilabilmeli
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        Thread.sleep(2000);
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.isDisplayed();
        ReusableMethods.waitForClickablility(qaConcortPage.loginButonu,10);
        qaConcortPage.loginButonu.click();

        Driver.closeDriver();
    }
}

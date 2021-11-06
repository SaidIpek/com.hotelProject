package pages.us0001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_004 {

    @Test
    public void test4() throws InterruptedException {


        //1) Ana Sayfada asagiya inilmeye devam edilir ve "Recent Blog" yazisi gorunur.
        //2) "Recent Blog" yazisi altindaki resim ve yazilarin tiklanabilir oldugu test dilir
        //3) Ana sayfada asagiya inilmeye devam edilir ve "Instagram" yazisi gorunur.
        //4)"Instagram" yazisi altindaki resimlerin tiklanabilir oldugu test edilir

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.anasayfaRecentBlogYazisi.isDisplayed());

        qaConcortPage.text6Yazisi.click();
        Assert.assertTrue(qaConcortPage.Blog6Yazisi.isDisplayed());

        qaConcortPage.AnaSayfaCONCORTHOTELYazisi.click();
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        qaConcortPage.text5Yazisi.click();
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.Blog5Yazisi.isDisplayed());

        qaConcortPage.AnaSayfaCONCORTHOTELYazisi.click();
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.instagramYazisi.isDisplayed());

        qaConcortPage.instagramFoto2.click();
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.Foto2Ciktisi.isDisplayed());

/*
        //======scroll to the exact element====//
        public void scrollInToWiew(WebElement element) {
            JavascriptExecutor js = ((JavascriptExecutor) Driver.getdriver());
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }

*/

        Driver.closeDriver();

    }
}

package pages.us0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_005 extends ReusableMethods {

    @Test
    public void test5(){

        // 1) Ana sayfada asagiya inilmeye devam edilir ve sayfa sonunda Footer bolumune gelinir.

        //2) Footer bolumundeki linklerin ve sosyal medya ikonlarinin tiklanabilir oldugu test edilir.


        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();
        /*
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

         */

        ReusableMethods re=new ReusableMethods();
        //re.scrollInToWiew(Driver.getDriver().findElement(By.xpath("(//a[@class='py-2 d-block'])[1]")));
        re.scrollInToWiew(qaConcortPage.FooterAmenitiesYazisi);


        // qaConcortPage.FooterBlogYazisi.click();
        Assert.assertTrue(qaConcortPage.FooterBlogYazisi.isEnabled());

        qaConcortPage.FooterRoomYazisi.click();
        Assert.assertTrue(qaConcortPage.FooterRoomYazisi.isEnabled());

        qaConcortPage.FooterAmenitiesYazisi.click();
        Assert.assertTrue(qaConcortPage.FooterAmenitiesYazisi.isEnabled());

        qaConcortPage.FooterGiftCardYazisi.click();
        qaConcortPage.FooterCareerYazisi.click();
        qaConcortPage.FooterAboutYazisi.click();
        qaConcortPage.FooterContactYazisi.click();
        qaConcortPage.FooterServiceYazisi.click();
        qaConcortPage.FooterAdress.click();
        qaConcortPage.FooterPhone.click();
        qaConcortPage.FooterEmail.click();

        qaConcortPage.twittericon.click();
        Assert.assertTrue(qaConcortPage.twittericon.isEnabled());

        qaConcortPage.FacebookIcon2.click();
        Assert.assertTrue(qaConcortPage.FacebookIcon2.isEnabled());

        qaConcortPage.InstagramIcon2.click();
        Assert.assertTrue(qaConcortPage.InstagramIcon2.isEnabled());

        Driver.closeDriver();

    }
}

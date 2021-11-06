package tests.us0002;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class Tc_001   {
    //1-Log in butonu gorunur, tiklanabilir olmali, ilgili yere yonlendirmeli
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.isDisplayed();
        qaConcortPage.ilkLoginLinki.click();
        Driver.closeDriver();
    }
}

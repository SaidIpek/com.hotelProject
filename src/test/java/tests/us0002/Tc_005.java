package tests.us0002;

import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;
public class Tc_005 {
    //5-Admin sayfasina gecis yapilabilmeli
    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl="UserAdmin";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL"+expectedUrl+"kelimesini içeriyor test PASS");
        }else{
            System.out.println("URL"+expectedUrl+"kelimesini içermiyor test FAILED");
        }
        Driver.closeDriver();
    }
}

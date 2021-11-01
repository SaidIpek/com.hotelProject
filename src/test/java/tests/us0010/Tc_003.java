package tests.us0010;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_003 {

    //3) Kriter seçiminden sonra gelen otel seçenekleri tiklanabilir olmali.

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        Assert.assertTrue(qaConcortPage.bookNow.isEnabled(), "Otel secenekleri tiklanabilir degil!");
        Driver.closeDriver();
    }
}

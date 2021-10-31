package tests.us0010;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_003 {
    //3) Kriter seçiminden sonra gelen otel seçenekleri tiklanabilir olmali.
    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        qaConcortPage.advancedSearchBasligiCheckinDateBox.clear();
        Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckinDateBox, "15/12/2021").perform();
        qaConcortPage.advancedSearchBasligiCheckoutDateBox.clear();
        actions.sendKeys(qaConcortPage.advancedSearchBasligiCheckoutDateBox, "20/12/2021").perform();
        Select select = new Select(qaConcortPage.selectRoomTypeDropdown);
        select.selectByVisibleText("Single");
        Thread.sleep(1000);
        Select select1 = new Select(qaConcortPage.selectAdultCountDropdown);
        select1.selectByVisibleText("1 Adult");
        Thread.sleep(1000);
        Select select2 = new Select(qaConcortPage.childrenDropdown);
        select2.selectByVisibleText("0 Children");
        Thread.sleep(1000);
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.locationTextBox, "USA").perform();
        Thread.sleep(5000);
        actions.click(qaConcortPage.searchButton).perform();
        Thread.sleep(2000);
        actions.click(qaConcortPage.bookNow).perform();
        Driver.closeDriver();
    }
}

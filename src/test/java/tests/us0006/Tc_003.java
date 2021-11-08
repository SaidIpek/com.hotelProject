package tests.us0006;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_003 {

    //"IDHotel" ,"Code" ,"Name" ,"Location" ,"Description" ,"Price",
    //"Room Type" , "Max Adult count","Max Children count","Approved"
    // bolumlerine istenen formatta bilgilerin girilerek otel odasi kaydi yapilabilmeli

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        Thread.sleep(4000);
        qaConcortPage.hotelManagementButonu.click();
        qaConcortPage.hotelRoomsButonu.click();
        qaConcortPage.addHotelRoomButonu.click();
        WebElement dropDownMenuIdHotel = Driver.getDriver().findElement(By.id("IDHotel"));
        Select dropDownList = new Select(dropDownMenuIdHotel);
        dropDownList.selectByVisibleText("Austin Hotel");
        qaConcortPage.codeBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("Code"));
        qaConcortPage.nameBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("Name"));
        qaConcortPage.locationBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("Location"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.sendKeys(qaConcortPage.descriptionBolumuInCreateHotelRoom, "The best view ...").perform();
        Thread.sleep(2000);
        ReusableMethods.scrollInToWiew(qaConcortPage.saveButonuInCreateHotelRoom);
        qaConcortPage.priceBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("Price"));
        WebElement dropDownMenuRoomType = Driver.getDriver().findElement(By.id("IDGroupRoomType"));
        Select dropDownList2 = new Select(dropDownMenuRoomType);
        dropDownList2.selectByVisibleText("Single");
        qaConcortPage.maxAdultCountBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("MaxAdultCount"));
        qaConcortPage.maxChildCountBolumuInCreateHotelRoom.sendKeys(ConfigReader.getProperty("MaxChildCount"));
        qaConcortPage.isAvailableBolumuInCreateHotelRoom.click();
        qaConcortPage.saveButonuInCreateHotelRoom.click();
        Driver.closeDriver();
    }
}

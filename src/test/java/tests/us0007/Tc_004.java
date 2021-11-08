package tests.us0007;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class Tc_004 {


    @Test
    public void test() throws InterruptedException {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        Thread.sleep(2000);
        qaConcortPage.details();


        qaConcortPage.hotelDetailsButton.click();
        Assert.assertTrue(qaConcortPage.hotelRoomDataHotelDropDown.isDisplayed());
        Select hotel = new Select(qaConcortPage.hotelRoomDataHotelDropDown);
        hotel.selectByIndex(6);


        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomCodeElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomNameElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomLocationElement")).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(2000);

        WebElement description = qaConcortPage.hotelRoomDescriptionElement;
        description.clear();
        description.sendKeys(ConfigReader.getProperty("HotelRoomDescription"));

        actions.dragAndDrop(qaConcortPage.hotelRoomPriceDragDrop, qaConcortPage.hotelRoomPriceBox).perform();

        Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
        roomType.selectByIndex(7);


        actions.sendKeys(Keys.TAB).
                sendKeys("2").
                sendKeys(Keys.TAB).
                sendKeys("0").
                perform();

        qaConcortPage.hotelRoomIsAvailable.click();
        Assert.assertTrue(qaConcortPage.hotelRoomSaveButton.isDisplayed(), "Save button not found");
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        Driver.closeDriver();
    }
}

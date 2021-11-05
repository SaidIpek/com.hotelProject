package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

public class US0007PositiveTest {

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        Random rnd = new Random();
        int detail = rnd.nextInt(10) + 1;
        Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();
        Select hotel = new Select(qaConcortPage.hotelRoomDataHotelDropDown);
        hotel.selectByIndex(1);

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomCodeElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomNameElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomLocationElement")).
                perform();

        Thread.sleep(2000);

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", qaConcortPage.hotelRoomSaveButton);
        Thread.sleep(2000);

        actions.dragAndDrop(qaConcortPage.hotelRoomPriceDragDrop,qaConcortPage.hotelRoomPriceBox).perform();
        Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
        roomType.selectByIndex(1);
        Thread.sleep(2000);

        WebElement adult= Driver.getDriver().findElement(By.id("MaxAdultCount"));
        adult.click();
        adult.clear();
        adult.sendKeys("2",Keys.TAB,"9");
        qaConcortPage.hotelRoomIsAvailable.click();
        Assert.assertTrue(qaConcortPage.hotelRoomSaveButton.isDisplayed(),"Save button not found");
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(2000);
        Assert.assertEquals(qaConcortPage.hotelRoomSuccess.getText(),ConfigReader.getProperty("HotelRoomSuccess"));

        qaConcortPage.hotelRoomOkButton.click();
    }
}

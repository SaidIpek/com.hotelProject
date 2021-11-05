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

public class US0007NegativeTest {

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        Random rnd = new Random();
        int detail = rnd.nextInt(10) + 1;
        Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();
        Select hotel=new Select(qaConcortPage.hotelRoomDataHotelDropDown);
        hotel.selectByIndex(1);

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailCodeElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailNameElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailLocationElement")).
                perform();

        Thread.sleep(2000);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", qaConcortPage.hotelRoomSaveButton);
        Thread.sleep(2000);
        qaConcortPage.hotelRoomPriceBox.sendKeys("A12");
        Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
        roomType.selectByIndex(1);
        Thread.sleep(2000);
        WebElement adult= Driver.getDriver().findElement(By.id("MaxAdultCount"));
        adult.click();
        adult.clear();
        adult.sendKeys("iki",Keys.TAB,"dokuz");

        qaConcortPage.hotelRoomSaveButton.click();

        Assert.assertNotEquals(qaConcortPage.hotelRoomFailSaveMessage.getText(),ConfigReader.getProperty("HotelRoomSuccess"),"Passed by entering wrong information");







    }
}

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
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.Random;

public class US0007NegativeTest extends TestBaseRapor {

    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("Delete Hotel Room Test");
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        extentTest.info("Tested to be on the HotelRoom page");
        Random rnd = new Random();
        int detail = rnd.nextInt(10) + 1;
        Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();
        extentTest.info("Details button tested");
        Select hotel=new Select(qaConcortPage.hotelRoomDataHotelDropDown);
        hotel.selectByIndex(1);
        extentTest.info("Hotel DropDown tested");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailCodeElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailNameElement")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HotelRoomFailLocationElement")).
                perform();
        extentTest.info("#Code - Name - Location# Elements tested");
        Thread.sleep(2000);
        ReusableMethods.scrollInToWiew(qaConcortPage.hotelRoomSaveButton);

        Thread.sleep(2000);
        qaConcortPage.hotelRoomPriceBox.sendKeys("A12");
        Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
        roomType.selectByIndex(1);
        Thread.sleep(2000);
        WebElement adult= Driver.getDriver().findElement(By.id("MaxAdultCount"));
        adult.click();
        adult.clear();
        adult.sendKeys("iki",Keys.TAB,"dokuz");
        extentTest.info("#Description - Price - Room type - Max Adult Count - Max Children Count - IsAvailable# Elements tested");
        qaConcortPage.hotelRoomSaveButton.click();
        extentTest.info("#Save Button# Elements tested");
        Assert.assertNotEquals(qaConcortPage.hotelRoomFailSaveMessage.getText(),ConfigReader.getProperty("HotelRoomSuccess"),"Passed by entering wrong information");
        extentTest.pass("Wrong Information Update Failed");
        ReusableMethods.getScreenshot("Wrong Information Failed");





    }
}
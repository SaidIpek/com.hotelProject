package tests.us0007;


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
import java.util.ArrayList;
import java.util.Random;


public class Tc_005 extends TestBaseRapor {

    @Test
    public void test() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Update Hotel Room Test");
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        qaConcortPage.details();
        extentTest.info("Tested to be on the HotelRoom page");
        ArrayList<Integer> random = new ArrayList<>();
        int count = 0;
        random.add(0);
        while (count <= 1) {
            Random rnd = new Random();
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            int detail = rnd.nextInt(10) + 1;

            if (!random.contains(detail)) {
                random.add(detail);

                Thread.sleep(3000);
                Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();
                extentTest.info("Details button tested");
                Assert.assertTrue(qaConcortPage.hotelRoomDataHotelDropDown.isDisplayed());
                Select hotel = new Select(qaConcortPage.hotelRoomDataHotelDropDown);
                hotel.selectByIndex(6);
                extentTest.info("Hotel DropDown tested");

                actions.sendKeys(Keys.TAB).
                        sendKeys(ConfigReader.getProperty("HotelRoomCodeElement")).
                        sendKeys(Keys.TAB).
                        sendKeys(ConfigReader.getProperty("HotelRoomNameElement")).
                        sendKeys(Keys.TAB).
                        sendKeys(ConfigReader.getProperty("HotelRoomLocationElement")).
                        perform();
                extentTest.info("#Code - Name - Location# Elements tested");
                Thread.sleep(2000);
                JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
                jsexecutor.executeScript("arguments[0].scrollIntoView(true);", qaConcortPage.hotelRoomSaveButton);

                WebElement description = qaConcortPage.hotelRoomDescriptionElement;
                description.clear();
                description.sendKeys(ConfigReader.getProperty("HotelRoomDescription"));
                Thread.sleep(2000);
                actions.dragAndDrop(qaConcortPage.hotelRoomPriceDragDrop, qaConcortPage.hotelRoomPriceBox).perform();
                Driver.getDriver().findElement(By.xpath("//label[text()='Room type']")).click();
                Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
                roomType.selectByIndex(7);

                Thread.sleep(2000);
                WebElement adult = Driver.getDriver().findElement(By.id("MaxAdultCount"));
                adult.click();
                adult.clear();
                adult.sendKeys("2", Keys.TAB, "9");
                extentTest.info("#Description - Price - Room type - Max Adult Count - Max Children Count - IsAvailable# Elements tested");


                qaConcortPage.hotelRoomIsAvailable.click();
                Assert.assertTrue(qaConcortPage.hotelRoomSaveButton.isDisplayed(), "Save button not found");
                actions.sendKeys(Keys.TAB).
                        sendKeys(Keys.ENTER).
                        perform();
                extentTest.info("#Save Button - Is Available box# Elements tested");

                Thread.sleep(2000);
                Assert.assertEquals(qaConcortPage.hotelRoomSuccess.getText(), ConfigReader.getProperty("HotelRoomSuccess"));
                extentTest.info("#Hotel Room Success# text tested");
                if (count == 1) {
                    ReusableMethods.getScreenshot("HotelRoom Updated");
                }

                qaConcortPage.hotelRoomOkButton.click();

                extentTest.pass(count + 1 + ". Edit HotelRoom page Pass");
                Driver.getDriver().navigate().back();
                count++;

            }
        }

        Driver.closeDriver();

    }
}

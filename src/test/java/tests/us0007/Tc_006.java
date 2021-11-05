package tests.us0007;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Random;


public class Tc_006 {
    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelRooms();
        qaConcortPage.details();


        ArrayList<Integer> random=new ArrayList<>();
        int count=0;
        random.add(0);
        while (count<=3){
            Random rnd = new Random();
            int detail = rnd.nextInt(10) + 1;

            if (!random.contains(detail)){
                random.add(detail);

                Driver.getDriver().findElement(By.xpath("(//a[contains(text(), ' Details')])[" + detail + "]")).click();

                Assert.assertTrue(qaConcortPage.hotelRoomDataHotelDropDown.isDisplayed());
                Select hotel=new Select(qaConcortPage.hotelRoomDataHotelDropDown);
                hotel.selectByIndex(6);



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

                WebElement description=qaConcortPage.hotelRoomDescriptionElement;
                description.clear();
                description.sendKeys(ConfigReader.getProperty("HotelRoomDescription"));
                Thread.sleep(2000);
                actions.dragAndDrop(qaConcortPage.hotelRoomPriceDragDrop,qaConcortPage.hotelRoomPriceBox).perform();
                Driver.getDriver().findElement(By.xpath("//label[text()='Room type']")).click();
                Select roomType = new Select(qaConcortPage.hotelRoomRoomType);
                roomType.selectByIndex(7);

                Thread.sleep(2000);
                WebElement adult= Driver.getDriver().findElement(By.id("MaxAdultCount"));
                adult.click();
                adult.clear();
                adult.sendKeys("2",Keys.TAB,"9");


                qaConcortPage.hotelRoomIsAvailable.click();

                actions.sendKeys(Keys.PAGE_DOWN).
                        sendKeys(Keys.PAGE_DOWN).
                        perform();
                Thread.sleep(2000);
                Assert.assertTrue(qaConcortPage.hotelRoomDeleteButton.isDisplayed());
                qaConcortPage.hotelRoomDeleteButton.click();
                Thread.sleep(2000);
                qaConcortPage.hotelRoomDeleteQuestion.click();
                SoftAssert softAssert=new SoftAssert();
                Thread.sleep(1000);
                softAssert.assertEquals(qaConcortPage.hotelRoomDeleteMessage.getText(),ConfigReader.getProperty("HotelRoomSuccessDelete"));
                qaConcortPage.hotelRoomOkButton.click();
                softAssert.assertAll();

                Driver.getDriver().navigate().back();
                count++;


            }

        }



        Driver.closeDriver();

    }

}
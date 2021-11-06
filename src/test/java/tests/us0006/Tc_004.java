package tests.us0006;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_004 {
    // "Price" textboxuna sayfada verilen tum fiyat kutulari drag and drop yapilabilmeli
    // (200, 300, 400, 500, 600, 700)

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword") );
        qaConcortPage.loginButonu.click();
        Thread.sleep(2000);
        qaConcortPage.hotelManagementButonu.click();
        qaConcortPage.hotelRoomsButonu.click();
        qaConcortPage.addHotelRoomButonu.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement dragElementi1 = Driver.getDriver().findElement(By.xpath("//li[@data-id='200']"));
        WebElement dragElementi2 = Driver.getDriver().findElement(By.xpath("//li[@data-id='300']"));
        WebElement dragElementi3 = Driver.getDriver().findElement(By.xpath("//li[@data-id='400']"));
        WebElement dragElementi4 = Driver.getDriver().findElement(By.xpath("//li[@data-id='500']"));
        WebElement dragElementi5 = Driver.getDriver().findElement(By.xpath("//li[@data-id='600']"));
        WebElement dragElementi6 = Driver.getDriver().findElement(By.xpath("//li[@data-id='700']"));

        WebElement dropAlani = Driver.getDriver().findElement(By.xpath("//input[@id='Price']"));

        actions.dragAndDrop(dragElementi1,dropAlani).perform();
        qaConcortPage.priceBolumuInCreateHotelRoom.clear();

        actions.dragAndDrop(dragElementi2,dropAlani).perform();
        qaConcortPage.priceBolumuInCreateHotelRoom.clear();

        actions.dragAndDrop(dragElementi3,dropAlani).perform();
        qaConcortPage.priceBolumuInCreateHotelRoom.clear();

        actions.dragAndDrop(dragElementi4,dropAlani).perform();
        qaConcortPage.priceBolumuInCreateHotelRoom.clear();

        actions.dragAndDrop(dragElementi5,dropAlani).perform();
        qaConcortPage.priceBolumuInCreateHotelRoom.clear();

        actions.dragAndDrop(dragElementi6,dropAlani).perform();
        Driver.closeDriver();
    }
}

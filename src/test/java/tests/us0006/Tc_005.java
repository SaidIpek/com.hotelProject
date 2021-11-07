package tests.us0006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_005 {

    //  "List of Hotel Rooms" sayfasindaki  "Search" butonunun tiklanabilir
    //  ve  bilgi girildiginde search edilebiliyor olmali

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys("Manager1!");
        qaConcortPage.loginButonu.click();
        Thread.sleep(2000);
        qaConcortPage.hotelManagementButonu.click();
        qaConcortPage.hotelRoomsButonu.click();
        WebElement dropDownMenuListOfHotelRooms = Driver.getDriver().findElement(By.xpath("//select[@id='lkpHotels']"));
        Select dropDownListIDHotel = new Select(dropDownMenuListOfHotelRooms);
        dropDownListIDHotel.selectByVisibleText("Austin Hotel");
        qaConcortPage.codeBolumuListOfHotelRooms.sendKeys(ConfigReader.getProperty("Code"));
        qaConcortPage.nameBolumuListOfHotelRooms.sendKeys(ConfigReader.getProperty("Name"));
        WebElement dropDownMenuIDGroupRoomType = Driver.getDriver().findElement(By.xpath("//select[@id='lkpGroupRoomTypes']"));
        Select dropDownListIDGroupRoomType = new Select(dropDownMenuIDGroupRoomType);
        dropDownListIDGroupRoomType.selectByVisibleText("Single");
        WebElement dropDownMenuIsAvailable = Driver.getDriver().findElement(By.xpath("//select[@name='IsAvailable']"));
        Select dropDownListIsAvailable = new Select(dropDownMenuIsAvailable);
        dropDownListIsAvailable.selectByVisibleText("True");
        qaConcortPage.searchButonuListOfHotelRooms.click();
        Driver.closeDriver();
    }
}

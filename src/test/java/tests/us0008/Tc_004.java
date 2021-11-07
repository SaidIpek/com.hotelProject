package tests.us0008;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_004 {
    /*
    1-"Id User" ve 2."Id User" dropdown seçenekleri görünmeli ve seçilmeli
    2- "Id User" dropdown kısmınına  verilen test data seçilmeli
    3-  2."Id User"  Select Hotel Room kısmına verilen test data seçilmeli
       Id User:manager  Id User(Select Hotel Room):Guzelbahce
     */

    @Test
    public void test() throws InterruptedException {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
        qaConcortPage.addRoomReservation.click();
        Assert.assertTrue(qaConcortPage.idUserDropdownu.isDisplayed(), "ID User dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.idUserDropdownu.isEnabled(), "ID User dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.idHotelRoomDropdownu.isDisplayed(), "ID HotelRoom dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.idHotelRoomDropdownu.isEnabled(), "ID HotelRoom dropdownu etkin degil!");
        Select select = new Select(qaConcortPage.idUserDropdownu);
        select.selectByVisibleText("manager");
        Select select1 = new Select(qaConcortPage.idHotelRoomDropdownu);
        select1.selectByVisibleText("OnurEnes");
        Driver.closeDriver();

    }
}

package tests.us0008;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_006 {
    /*
    1-"Save" butonu görünür olmalı ve tıklanabilmeli
    2-Save butonuna tıklandıktan sonra "RoomReservation was inserted successfully" yazısı görünmeli
     */
    @Test
    public void test () {
        QAConcortPage qaConcortPage = new QAConcortPage();  Actions actions = new Actions(Driver.getDriver());
        ReusableMethods rm = new ReusableMethods();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
        qaConcortPage.addRoomReservation.click();

        Select select = new Select(qaConcortPage.idUserDropdownu);
        select.selectByVisibleText("manager");
        Select select1 = new Select(qaConcortPage.idHotelRoomDropdownu);
        select1.selectByVisibleText("Guzelbahce");
        actions.sendKeys(qaConcortPage.pricetextBoxi, "1000").perform();
        actions.click(qaConcortPage.dateStartTakvimIkonu).perform();
        rm.waitForClickablility(qaConcortPage.dateStartTakvimi,10);
        actions.click(qaConcortPage.dateStartTakvimi).perform();
        rm.waitForClickablility(qaConcortPage.dateEndTakvimIkonu,5);
        actions.click(qaConcortPage.dateEndTakvimIkonu).perform();
        rm.waitForClickablility(qaConcortPage.dateEndTakvimi,10);
        actions.click(qaConcortPage.dateEndTakvimi).perform();
        rm.waitForClickablility(qaConcortPage.adultAmountTextBoxi,15);
        actions.sendKeys(qaConcortPage.adultAmountTextBoxi, "2").perform();
        rm.waitForClickablility(qaConcortPage.childrenAmountTextBoxi,15);
        actions.sendKeys(qaConcortPage.childrenAmountTextBoxi,"1").perform();
        rm.waitForClickablility(qaConcortPage.contactNameSurnameTextBoxi,5);
        actions.sendKeys(qaConcortPage.contactNameSurnameTextBoxi, "Seda Fehime").perform();
        actions.sendKeys(qaConcortPage.contactPhoneTextBoxi, "5551233423").perform();
        actions.sendKeys(qaConcortPage.contactEmailTextBoxi, "hotelteam5@gmail.com").perform();
        rm.scrollInToWiew(qaConcortPage.createHotelroomreservatıonSaveButonu);
        actions.sendKeys(qaConcortPage.notesTextBoxi, "Mutlu Günler").perform();
        actions.click(qaConcortPage.approvedCheckboxTiklamakIcin).perform();
        actions.click(qaConcortPage.isPaidCheckbox).perform();

        Assert.assertTrue(qaConcortPage.createHotelroomreservatıonSaveButonu.isDisplayed(),"Save butonu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.createHotelroomreservatıonSaveButonu.isEnabled(),"Save butonu etkin degil!");

        actions.click(qaConcortPage.createHotelroomreservatıonSaveButonu).perform();
        rm.waitForVisibility(qaConcortPage.roomReservationWasInsertedSuccesfullyYazisi,10);
        Assert.assertTrue(qaConcortPage.roomReservationWasInsertedSuccesfullyYazisi.isDisplayed());

        Driver.closeDriver();

    }
}

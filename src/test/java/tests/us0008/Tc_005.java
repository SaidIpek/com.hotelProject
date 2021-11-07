package tests.us0008;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_005 {
    /*
    1-"price" kısmı görünmeli ve tast datası girilebilmeli
    2-"Date Start" kısmı görünmeli ve tast datası girilebilmeli
    3-"Date End" kısmı görünmeli ve tast datası girilebilmeli
    4-"Adult Amount" kısmı görünmeli ve tast datası girilebilmeli
    5-"Children Amount" kısmı görünmeli ve tast datası girilebilmeli
    6-"Contact Namesurname" kısmı görünmeli ve tast datası girilebilmeli
    7-"Contact Phone" kısmı görünmeli ve tast datası girilebilmeli
    8-"Contact Email" kısmı görünmeli ve tast datası girilebilmeli
    9-"Notes" kısmı görünmeli ve tast datası girilebilmeli
    10- "Approved" kısmı görünmeli ve tıklanmalı
    ***Datalar
     Price:1000
     Date start:11/07/2021
     Date end:11/08/2021
     Adult Amount: 2
     Children Amount: 1
      Contact Namesurname:Seda Fehime
     Contact Phone:5551233423
     Contact Email:hotelteam5@gmail.com
     Notes:Mutlu Günler
     */

    @Test
    public void test() {
        QAConcortPage qaConcortPage = new QAConcortPage();
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods rm = new ReusableMethods();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
        qaConcortPage.addRoomReservation.click();

        Select select = new Select(qaConcortPage.idUserDropdownu);
        select.selectByVisibleText("manager");
        Select select1 = new Select(qaConcortPage.idHotelRoomDropdownu);
        select1.selectByVisibleText("OnurEnes");

        Assert.assertTrue(qaConcortPage.pricetextBoxi.isDisplayed(), "Price textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.pricetextBoxi.isEnabled(), "Price textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.pricetextBoxi, "1000").perform();

        Assert.assertTrue(qaConcortPage.dateStarttextBoxi.isDisplayed(), "Date Start textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.dateStarttextBoxi.isEnabled(), "Date Start textboxi etkin degil!");
        actions.click(qaConcortPage.dateStartTakvimIkonu).perform();
        rm.waitForClickablility(qaConcortPage.dateStartTakvimi,10);
        actions.click(qaConcortPage.dateStartTakvimi).perform();

       rm.waitForClickablility(qaConcortPage.dateEndTextBoxi,10);
        Assert.assertTrue(qaConcortPage.dateEndTextBoxi.isDisplayed(), "Date End textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.dateEndTextBoxi.isEnabled(), "Date End textboxi etkin degil!");
        actions.click(qaConcortPage.dateEndTakvimIkonu).perform();
        rm.waitForClickablility(qaConcortPage.dateEndTakvimi,10);
        actions.click(qaConcortPage.dateEndTakvimi).perform();

        Assert.assertTrue(qaConcortPage.adultAmountTextBoxi.isDisplayed(), "Adult Amount textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.adultAmountTextBoxi.isEnabled(), "Adult Amount textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.adultAmountTextBoxi, "2").perform();

        Assert.assertTrue(qaConcortPage.childrenAmountTextBoxi.isDisplayed(), "Children Amount textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.childrenAmountTextBoxi.isEnabled(), "Children Amount textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.childrenAmountTextBoxi, "1").perform();

        Assert.assertTrue(qaConcortPage.contactNameSurnameTextBoxi.isDisplayed(), "Contact name Surname textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.contactNameSurnameTextBoxi.isEnabled(), "Contact name Surname textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.contactNameSurnameTextBoxi, "Seda Fehime").perform();

        Assert.assertTrue(qaConcortPage.contactPhoneTextBoxi.isDisplayed(), "Contact Phone textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.contactPhoneTextBoxi.isEnabled(), "Contact Phone textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.contactPhoneTextBoxi, "5551233423").perform();

        Assert.assertTrue(qaConcortPage.contactEmailTextBoxi.isDisplayed(), "Contact Email textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.contactEmailTextBoxi.isEnabled(), "Contact Email textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.contactEmailTextBoxi, "hotelteam5@gmail.com").perform();

        rm.scrollInToWiew(qaConcortPage.createHotelroomreservatıonSaveButonu);

        Assert.assertTrue(qaConcortPage.notesTextBoxi.isDisplayed(), "Notes textboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.notesTextBoxi.isEnabled(), "Notes textboxi etkin degil!");
        actions.sendKeys(qaConcortPage.notesTextBoxi, "Mutlu Günler").perform();

        Assert.assertTrue(qaConcortPage.approvedCheckbox.isDisplayed(), "Approved checkboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.approvedCheckbox.isEnabled(), "Approved checkboxi etkin degil!");
        actions.click(qaConcortPage.approvedCheckboxTiklamakIcin).perform();

        rm.waitForClickablility(qaConcortPage.isPaidCheckbox,5);
        Assert.assertTrue(qaConcortPage.isPaidCheckbox.isDisplayed(), "Ispaid checkboxi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.isPaidCheckbox.isEnabled(), "Ispaid checkboxi etkin degil!");
        actions.click(qaConcortPage.isPaidCheckbox).perform();

       Driver.closeDriver();

    }

}

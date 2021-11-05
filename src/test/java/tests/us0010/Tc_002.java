package tests.us0010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_002 {

    //2) Advanced Search text boxlari, dropdownlari ve search butonu etkin olmali.

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        ReusableMethods rm = new ReusableMethods();
        qaConcortPage.ConcortHotelRoomsGiris();
        rm.waitForVisibility(qaConcortPage.advancedSearchBasligi,5);
        Assert.assertTrue(qaConcortPage.advancedSearchBasligi.isDisplayed(), "Advanced Search basligi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.advancedSearchBasligiCheckinDateBoxUs010.isEnabled(), "Advanced Search basligi altindaki check in date box'i etkin degil!");
        Assert.assertTrue(qaConcortPage.advancedSearchBasligiCheckoutDateBoxUs010.isEnabled(), "Advanced Search basligi altindaki check out date box'i etkin degil!");
        Assert.assertTrue(qaConcortPage.selectRoomTypeDropdownUs010.isDisplayed(), "Select Room Type dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.selectRoomTypeDropdownUs010.isEnabled(), "Select Room Type dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.selectAdultCountDropdownUs010.isDisplayed(), "Select Adult Count dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.selectAdultCountDropdownUs010.isEnabled(), "Select Adult Count dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.childrenDropdownUs010.isDisplayed(), "Children dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.childrenDropdownUs010.isEnabled(), "Children dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.locationTextBoxUs010.isEnabled(), "Location textbox'i etkin degil!");
        Assert.assertTrue(qaConcortPage.searchButtonUs010.isEnabled(), "Search butonu etkin degil!");
        Driver.closeDriver();
    }
}

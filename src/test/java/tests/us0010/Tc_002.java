package tests.us0010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;
public class Tc_002 {

    //2) Advanced Search text boxlari, dropdownlari ve search butonu etkin olmali.

    @Test
    public void test () throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        Assert.assertTrue(qaConcortPage.advancedSearchBasligi.isDisplayed(),"Advanced Search basligi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.advancedSearchBasligiCheckinDateBox.isEnabled(),"Advanced Search basligi altindaki check in date box'i etkin degil!");
        Assert.assertTrue(qaConcortPage.advancedSearchBasligiCheckoutDateBox.isEnabled(),"Advanced Search basligi altindaki check out date box'i etkin degil!");
        Assert.assertTrue(qaConcortPage.selectRoomTypeDropdown.isDisplayed(),"Select Room Type dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.selectRoomTypeDropdown.isEnabled(),"Select Room Type dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.selectAdultCountDropdown.isDisplayed(),"Select Adult Count dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.selectAdultCountDropdown.isEnabled(),"Select Adult Count dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.childrenDropdown.isDisplayed(),"Children dropdownu gorunmuyor!");
        Assert.assertTrue(qaConcortPage.childrenDropdown.isEnabled(),"Children dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.locationTextBox.isEnabled(),"Location textbox'i etkin degil!");
        Assert.assertTrue(qaConcortPage.searchButton.isEnabled(),"Search butonu etkin degil!");
        Driver.closeDriver();
    }
}

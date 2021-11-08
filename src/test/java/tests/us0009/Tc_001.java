package tests.us0009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_001 {
    @Test
    public void test() {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        Assert.assertTrue(qaConcortPage.roomReservationsSekmesi.isDisplayed());
        Assert.assertTrue(qaConcortPage.roomReservationsSekmesi.isEnabled());
        qaConcortPage.roomReservationsSekmesi.click();
        Assert.assertTrue(qaConcortPage.listOfReservationYazısı.isDisplayed());
        Driver.closeDriver();
    }


}

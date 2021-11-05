package tests.us0008;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class Tc_003 {

    /*
    1-"List of Reservation" sayfasındaki "Add Room Reservation" sekmesi görünüyor mu?
    2-"Add Room Reservation" butonu tıklanmalı
    3- "List Of Hotelroomreservatıons" yazısı görünmeli
     */

    @Test
    public void test () {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
        Assert.assertTrue(qaConcortPage.addRoomReservation.isDisplayed(),"Add Room Reservation yazisi gorunmuyor!");
        Assert.assertTrue(qaConcortPage.addRoomReservation.isEnabled(),"Add Room Reservation yazisi etkin degil!");
        qaConcortPage.addRoomReservation.click();
        Assert.assertTrue(qaConcortPage.listOfHotelroomreservartions.isDisplayed(),"List Of Hotelroomreservations yazisi gorunmuyor!");
        Driver.closeDriver();
    }
}

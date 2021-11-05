package tests.us0007;

import org.testng.annotations.Test;
import pages.QAConcortPage;


public class Tc_002 {

@Test
    public void editHotel() throws InterruptedException {
    QAConcortPage qaConcortPage = new QAConcortPage();

    qaConcortPage.ConcortHotelLogin();

    qaConcortPage.hotelRooms();

     qaConcortPage.details();
}

}

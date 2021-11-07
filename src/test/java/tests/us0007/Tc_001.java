package tests.us0007;


import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;


public class Tc_001 {

        // 1) Rooms sayfasina girilebilmeli.
        @Test
        public void hotelRooms (){
            QAConcortPage qaConcortPage = new QAConcortPage();

                qaConcortPage.ConcortHotelLogin();

            qaConcortPage.hotelRooms();

            Driver.closeDriver();
            }


        }



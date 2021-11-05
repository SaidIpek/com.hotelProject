package tests.us0007;


import org.testng.annotations.Test;
import pages.QAConcortPage;


public class Tc_001 {




        // 1) Rooms sayfasina girilebilmeli.
        @Test
        public void hotelRooms (){
            QAConcortPage qaConcortPage = new QAConcortPage();

                qaConcortPage.ConcortHotelLogin();

                System.out.println("====There is a problem with the login method====");
            qaConcortPage.hotelRooms();
            }


        }



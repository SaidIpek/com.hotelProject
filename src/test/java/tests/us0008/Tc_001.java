package tests.us0008;

import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {
    //1- "Room Reservation" seceneği seçilebilmeli
    //*Kullanici Concort Hotel (Admin) sayfasina gider.
    //*Sag ustte log in butonunu tiklar ardindan Username ve Sifre girilmeli
    //*Acilan sayfada sol menuden "System Management" menusunun altindaki "Hotel Management" sekmesine  tiklar
    //*Ardindan "Room reservation" secegine tiklar.
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
    }

}

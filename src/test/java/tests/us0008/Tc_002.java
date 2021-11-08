package tests.us0008;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_002 {

    //2- "List of Resevations" sayfası görünmeli ve listelenmeli
    //*"List of Reservations" yazısı görünmeli
    //*Sayfadaki "View" kısmındaki "All" seçeneği tıklanmalı
    //*Tüm rezervasyon listesi listelenmeli
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementSekmesi.click();
        qaConcortPage.roomReservationsSekmesi.click();
        qaConcortPage.listOfReservationYazısı.isDisplayed();
        Select select = new Select(qaConcortPage.viewSelectDropDown);
        select.selectByValue("-1");

        for (WebElement each : qaConcortPage.lisOfReservationListesi) {
            System.out.print(each.getText());
            Driver.closeDriver();
        }
    }

}

package tests.us0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_004 {

    //4-Seçilen room'un text box , dropdown ve "Book This Room" butonu etkin olmali.

    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciPassword"));
        wait.until(ExpectedConditions.elementToBeClickable(qaConcortPage.loginButonu));
        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateBox.isEnabled(), "Check in date boxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateBox.isEnabled(), "Check out date boxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiSelectAdultCountDropdown.isEnabled(), "Select Adult Count dropdowni etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiChildrenDropdown.isEnabled(), "Children dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi.isEnabled(), "Name-surname textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi.isEnabled(), "Email textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiPhoneNumberTextboxi.isEnabled(), "Phone number textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiNameOnCreditCardTextboxi.isEnabled(), "Name On Credit Card textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiCreditCardNumberTextboxi.isEnabled(), "Credit Card Number textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationYearForCreditCardDropdownu.isEnabled(), "Select Expiration Year For Credit Card Dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationMonthForCreditCardDropdownu.isEnabled(), "Select Expiration Month For Credit Card Dropdownu etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiCVVTextboxi.isEnabled(), "CVV textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiMessageTextboxi.isEnabled(), "Message textboxi etkin degil!");
        Assert.assertTrue(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu.isEnabled(), "Book This Room butonu etkin degil!");


        Driver.closeDriver();
    }

}

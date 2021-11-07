package tests.us0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Raporlama extends TestBaseRapor {
    @Test
    public void test1() throws IOException {

        extentTest = extentReports.createTest("Rezervasyon Testi", "Ilgili bilgiler girilince rezervasyon yapilabilabilmeli!");
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        extentTest.info("Concort Hotel/Rooms sayfasina gidildi");


        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        extentTest.info("Oda kriterleri girildi!");


        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciPassword"));
        qaConcortPage.loginButonu.click();
        extentTest.info("Kullanici adi ve sifresiyle kisisel bilgiler sayfasina gidildi.");


        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(qaConcortPage.advancedSearchBasligiCheckinDateBoxUs010).perform();
        ReusableMethods.waitForVisibility(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi, 5);
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi)
                .click(qaConcortPage.advancedSearchBasligiCheckoutDateBoxUs010).perform();
        ReusableMethods.waitForClickablility(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi, 10);
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi).perform();

        Select select = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectAdultCountDropdown);
        select.selectByVisibleText("1 Adult");

        Select select1 = new Select(qaConcortPage.TodBruenOdaSayfasindakiChildrenDropdown);
        select1.selectByVisibleText("0 Children");

        qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi.clear();
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi, faker.name().fullName()).perform();
        qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi.clear();
        ReusableMethods.scrollInToWiew(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu);
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi, "aralik@gmail.com")
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiPhoneNumberTextboxi, faker.phoneNumber().phoneNumber())
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiNameOnCreditCardTextboxi, faker.name().fullName())
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCreditCardNumberTextboxi, "5555555555555555").perform();
        Select select2 = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationYearForCreditCardDropdownu);
        select2.selectByVisibleText("2023");

        Select select3 = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationMonthForCreditCardDropdownu);
        select3.selectByVisibleText("January");
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCVVTextboxi, "123")
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiMessageTextboxi, "Odami sakin taraftan istiyorum. Sesli bir konumu varsa tarafima bilgi verilmesini rica ederim")
                .sendKeys(Keys.TAB).perform();
        ReusableMethods.waitForClickablility(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu,10);
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu).perform();

        extentTest.info("Kisisel bilgiler girildi ve rezervasyon tamamlandi.");

        if (qaConcortPage.reservationWasMadeSuccessfullyUs010.isDisplayed()==true) {
            extentTest.pass("Reservation was made successfully yazisi goruldu.");
        }else {
            ReusableMethods.getScreenshot("Reservation was made successfully yazisi goruldu.");
        }

        Driver.closeDriver();
    }
}

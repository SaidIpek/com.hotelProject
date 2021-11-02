package tests.us0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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

public class Tc_005 {

    //5-Room kriterleri girilip "Book This Room" butonu tiklandiktan sonra "Reservation was made
    //successfully Your Reservation Link is : here" yazisi gorunur olmali.

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

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(qaConcortPage.advancedSearchBasligiCheckinDateBox).perform();
        wait.until(ExpectedConditions.visibilityOf(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi));
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi)
                .click(qaConcortPage.advancedSearchBasligiCheckoutDateBox).perform();
        wait.until(ExpectedConditions.elementToBeClickable(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi));
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi).perform();

        Select select = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectAdultCountDropdown);
        select.selectByVisibleText("1 Adult");

        Select select1 = new Select(qaConcortPage.TodBruenOdaSayfasindakiChildrenDropdown);
        select1.selectByVisibleText("0 Children");

        qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi.clear();
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi, faker.name().fullName()).perform();
        qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi.clear();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
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
                .sendKeys(Keys.TAB)
                .click(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu).perform();

        Assert.assertTrue(qaConcortPage.reservationWasMadeSuccessfully.isDisplayed(), "Reservation was made successfully yazisi gorunmuyor!");
        Driver.closeDriver();
    }
}

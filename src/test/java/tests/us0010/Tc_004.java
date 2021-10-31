package tests.us0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_004 {
    //4-Seçilen room'un text box , dropdown ve "Book This Room" butonu etkin olmali.
    @Test
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        Thread.sleep(2000);
        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(1000);
        qaConcortPage.loginButonu.click();

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        qaConcortPage.TodBruenOdaSayfasindakiCheckinDateBox.clear();
        Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateBox, "15/12/2021").perform();
        qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateBox.clear();
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateBox, "20/12/2021").perform();
        Select select = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectAdultCountDropdown);
        select.selectByVisibleText("1 Adult");
        // Thread.sleep(1000);
        Select select1 = new Select(qaConcortPage.TodBruenOdaSayfasindakiChildrenDropdown);
        select1.selectByVisibleText("0 Children");
        //Thread.sleep(1000);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(1000);
        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi, faker.name().fullName())
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi,faker.internet().emailAddress())
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiNameOnCreditCardTextboxi, faker.name().fullName())
                .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCreditCardNumberTextboxi, "5555555555555555").perform();
        //Thread.sleep(5000);
        Select select2 = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationMonthForCreditCardDropdownu);
        select1.selectByValue("2");
        Select select3 = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectExpirationYearForCreditCardDropdownu);
        select1.selectByValue("2023");

        actions.sendKeys(qaConcortPage.TodBruenOdaSayfasindakiCVVTextboxi,"123")
                        .sendKeys(qaConcortPage.TodBruenOdaSayfasindakiMessageTextboxi ,"Odami sakin taraftan istiyorum. Sesli bir konumu varsa tarafima bilgi verilmesini istiyorum")
                        .click(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu).perform();


    }

}

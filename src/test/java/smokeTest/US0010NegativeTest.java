package smokeTest;

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
import utilities.ReusableMethods;

public class US0010NegativeTest {

    //Bir bilgi eksik girildiginde rezervasyon yapilamadigini test edelim

    @Test
    public void test () {

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ConcortHotelRoomsGiris();
        qaConcortPage.ConcortHotelRoomsBilgiGiris();
        ReusableMethods.waitForClickablility(qaConcortPage.TodBruenOdaSayfasindakiLogIn,10);
        qaConcortPage.TodBruenOdaSayfasindakiLogIn.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAKullaniciPassword"));
        ReusableMethods.waitForClickablility(qaConcortPage.loginButonu,10);
        qaConcortPage.loginButonu.click();

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(qaConcortPage.advancedSearchBasligiCheckinDateBoxUs010).perform();
        ReusableMethods.waitForClickablility(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi,10);
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckinDateTakvimi)
                .click(qaConcortPage.advancedSearchBasligiCheckoutDateBoxUs010).perform();
        ReusableMethods.waitForClickablility(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi,10);
        actions.click(qaConcortPage.TodBruenOdaSayfasindakiCheckoutDateTakvimi).perform();


        Select select = new Select(qaConcortPage.TodBruenOdaSayfasindakiSelectAdultCountDropdown);
        select.selectByVisibleText("1 Adult");

        Select select1 = new Select(qaConcortPage.TodBruenOdaSayfasindakiChildrenDropdown);
        select1.selectByVisibleText("0 Children");
        ReusableMethods.scrollInToWiew(qaConcortPage.TodBruenOdaSayfasindakiBookThisRoomButonu);
        qaConcortPage.TodBruenOdaSayfasindakiNameSurnameTextboxi.clear();

        qaConcortPage.TodBruenOdaSayfasindakiEmailTextboxi.clear();
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

        Assert.assertTrue(qaConcortPage.thisFieldIsRequiredYazisiUs010.isDisplayed(),"This field is required yazisi gorunmuyor!");
        Driver.closeDriver();
    }

}

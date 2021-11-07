package tests.us0009;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_003 {

    @Test
    public void test() throws InterruptedException {

        QAConcortPage qaConcortPage = new QAConcortPage();

        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        qaConcortPage.loginButonu.click();

        WebElement dropDown = qaConcortPage.systemManagementSekmesi;

        qaConcortPage.hotelManagementSekmesi.click();

        qaConcortPage.roomReservationsSekmesi.click();

        qaConcortPage.detailsButonu.click();

        Assert.assertTrue(qaConcortPage.generalDataBolumu.isDisplayed());

        Assert.assertTrue(qaConcortPage.propertiesBolumu.isDisplayed());

        Assert.assertTrue(qaConcortPage.hotelRoomReservationDataBasligi.isDisplayed());

        WebElement dropDown1 = qaConcortPage.idHotelRoomDropdownu;

        Select select = new Select(dropDown1);

        select.selectByIndex(1);

        WebElement userDropDown = qaConcortPage.idUserDropdownu;

        Select select1 = new Select(userDropDown);

        select.selectByIndex(1);

        actions.doubleClick(qaConcortPage.pricetextBoxi).perform();
        qaConcortPage.pricetextBoxi.sendKeys(Keys.DELETE + "5000");

        qaConcortPage.dateStartTakvimIkonu.click();
        qaConcortPage.dateStartTakvimi.click();

        qaConcortPage.dateEndTakvimIkonu.click();
        qaConcortPage.dateEndTakvimi.click();


        qaConcortPage.adultAmountTextBoxi.sendKeys(Keys.BACK_SPACE + "2");

        qaConcortPage.childrenAmountTextBoxi.sendKeys(Keys.BACK_SPACE + "3");

        actions.doubleClick(qaConcortPage.contactNameSurnameTextBoxi).perform();
        qaConcortPage.contactNameSurnameTextBoxi.sendKeys(Keys.DELETE + "mazhar fuat");

        actions.click(qaConcortPage.contactPhoneTextBoxi);
        actions.doubleClick(qaConcortPage.contactPhoneTextBoxi).perform();
        qaConcortPage.contactPhoneTextBoxi.sendKeys(Keys.DELETE + "(555) 123 45 67");

        actions.click(qaConcortPage.contactEmailTextBoxi);
        actions.doubleClick(qaConcortPage.contactEmailTextBoxi).perform();
        qaConcortPage.contactEmailTextBoxi.sendKeys(Keys.DELETE + "mazharfuat@gmail.com");
        qaConcortPage.contactEmailTextBoxi.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);

        actions.doubleClick(qaConcortPage.notesTextBoxi).perform();
        qaConcortPage.notesTextBoxi.sendKeys(Keys.DELETE + "mehmet hocaya selam olsun. :)");

        qaConcortPage.approvedCheckboxTiklamakIcin.click();
        qaConcortPage.isPaidCheckbox.click();

        qaConcortPage.approvedCheckboxTiklamakIcin.click();
        qaConcortPage.isPaidCheckbox.click();

        Driver.closeDriver();

    }
}

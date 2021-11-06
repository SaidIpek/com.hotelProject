package tests.us0004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_004 {

    @Test
    public void test() throws InterruptedException {

        //1- "Code" butonuna tiklar
        //2- "Name" butonuna tiklar
        //3- "Address" butonuna tiklar
        //4- "Phone" butonuna tiklar
        //5- "Email" butonuna tiklar
        //6- "IDGroup" butonuna tiklar ve dropdowndan hotel tipini secer
        //7- "Save" butonuna tiklar

        QAConcortPage qaConcortPage= new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.US04HotelManagementMenüsü.click();
        qaConcortPage.US04HotelList.click();
        qaConcortPage.US4AddHotelButonu.click();

        Actions actions=new Actions(Driver.getDriver());

        actions.
                click(qaConcortPage.US4CodeTextbox)
                .sendKeys(ConfigReader.getProperty("US04Code"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("US04Name"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("US04Adress"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("US04Phone"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("US04Email"))
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Select select=new Select(qaConcortPage.US4IDGroupDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("US04IDGroup"));

        Thread.sleep(1000);

        actions.click(qaConcortPage.US4SaveButonu).perform();

        Thread.sleep(2000);

        Assert.assertTrue(qaConcortPage.US4OtelBasariliEklendiYazisi.isDisplayed());


        Driver.closeDriver();
    }

}

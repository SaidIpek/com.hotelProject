package tests.us0004;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Tc_005 {

    @Test
    public void test() throws InterruptedException {

        // 1- "Hotel List" butonuna tiklar
        QAConcortPage qaConcortPage = new QAConcortPage();

        Thread.sleep(1000);
        qaConcortPage.ConcortHotelLogin();

//        qaConcortPage.US04HotelManagementMenüsü.click();
//        qaConcortPage.US04HotelList.click();
//
//        //2- "IDHotel" kismina tiklar,search eder
//
//        qaConcortPage.USO4SearchIDHotelKutusu.click();
//        qaConcortPage.USO4SearchIDHotelKutusu.sendKeys(ConfigReader.getProperty("US04IDHotel"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed(), "Found yazisi göruntulenmedi");
//
//        //3- "Code" kismina tiklar, search eder
//
//
//        Thread.sleep(1000);
//        qaConcortPage.USO4SearchCodeKutusu.click();
//        qaConcortPage.USO4SearchCodeKutusu.sendKeys(ConfigReader.getProperty("US04Code"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());
//
//
//        //4- "Name" kismina tiklar, search eder
//        ReusableMethods.waitForClickablility(qaConcortPage.USO4SearchNameKutusu,10);
//        qaConcortPage.USO4SearchNameKutusu.click();
//        qaConcortPage.USO4SearchNameKutusu.sendKeys(ConfigReader.getProperty("US04Name"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());
//
//        //5- "Address" kismina tiklar, search eder
//
//        Thread.sleep(1000);
//        qaConcortPage.USO4SearchAdressKutusu.click();
//        qaConcortPage.USO4SearchAdressKutusu.sendKeys(ConfigReader.getProperty("US04Adress"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());
//        ;
//
//        //6- "Phone" kismina tiklar, search eder
//
//        Thread.sleep(1000);
//        qaConcortPage.USO4SearchPhoneKutusu.click();
//        qaConcortPage.USO4SearchPhoneKutusu.sendKeys(ConfigReader.getProperty("US04Phone"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());
//
//        //7- "Email" kismina tiklar, search eder
//        Thread.sleep(1000);
//        qaConcortPage.USO4SearchEmailKutusu.click();
//        qaConcortPage.USO4SearchEmailKutusu.sendKeys(ConfigReader.getProperty("US04Email"));
//        qaConcortPage.US04SearchButonu.click();
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());
//
//        //8- "IdGroup" kismina tiklar, dropdowndan secer,search eder
//
//        Select select = new Select(qaConcortPage.US4SearchIDGroupDropdown);
//        select.selectByVisibleText(ConfigReader.getProperty("US04IDGroup"));
//
//        Assert.assertTrue(qaConcortPage.US04FoundYazisi.isDisplayed());


        Driver.closeDriver();


    }

}



package tests.us0005;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class Tc_003 {
    /*
     US-0003 "code", "name","adress","phone","email","group" secenekleri degistirilebilir
     ve "save" butonu tiklanabilir olmali
       TC-0003-
     6-"Code" textbox'i gorunmeli ve degistirilebilmeli.
     7-"Name" textbox'i gorunmeli ve degistirilebilmeli.
     8-"Adress" textbox'i gorunmeli ve degistirilebilmeli.
     9-"Phone" textbox'i gorunmeli ve degistirilebilmeli.
     10-"Email" textbox'i gorunmeli ve degistirilebilmeli.
     11-"Group" dropDown'i gorunmeli ve secilebilir olmali
     12-"Save" butonu gorunmeli ve tiklanilabilmeli.
     */
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        Thread.sleep(2000);
        qaConcortPage.ConcortHotelLogin();
//        Actions actions = new Actions(Driver.getDriver());
//        Thread.sleep(5000);
//        qaConcortPage.hotelManagementLinki.click();
//        Thread.sleep(5000);
//        qaConcortPage.hotelListLink.click();
//        Assert.assertTrue( qaConcortPage.ListOfHotelYAziElementi.isDisplayed(),"list hotel yazisi gorunmuyor");
//        Faker faker=new Faker();
//        String nameFaker =faker.name().name();
//        System.out.println(nameFaker);
//        String codeFaker =faker.code().asin();
//        System.out.println(codeFaker);
//        String addressFaker =faker.address().fullAddress();
//        System.out.println(addressFaker);
//        String phoneNumberFaker =faker.phoneNumber().phoneNumber();
//        System.out.println(phoneNumberFaker);
//        String emailFaker =faker.internet().emailAddress();
//        System.out.println(emailFaker);
//        Actions actions1 = new Actions(Driver.getDriver());
//        actions
//                .click(qaConcortPage.HotelDataListLinki).
//                sendKeys(faker.code().asin()).
//                sendKeys(faker.name().name()).
//                sendKeys(Keys.TAB).
//                sendKeys(faker.address().fullAddress()).
//                sendKeys(Keys.TAB).
//                sendKeys(faker.phoneNumber().phoneNumber()).
//                sendKeys(Keys.TAB).
//                sendKeys(faker.internet().emailAddress()).perform();
//        Select select=new Select(qaConcortPage.HotelDataListLinki);
//        select.selectByVisibleText(ConfigReader.getProperty("(//div[@class='caption'][2])"));
//        actions.sendKeys(qaConcortPage.codeListTexBox,"34")
//                .sendKeys(qaConcortPage.nameListTextBoxi,"OnurEnes")
//                .sendKeys(qaConcortPage.AdressListTextBoxi,"Istanbul")
//                .sendKeys(qaConcortPage.phoneListTextBoxi,"+12334 73321")
//                .sendKeys(qaConcortPage.EmailListTextBoxi,"34Istasnbul@hotmail.com")
//                .perform();
//      // Select select1=new Select(qaConcortPage.GroupDropDownListBoxi);
//       // select.selectByVisibleText("//*[@id='IDGroup']");
//        // Save butonunu
//        actions.sendKeys(Keys.PAGE_DOWN);
//        Thread.sleep(1000);
//        qaConcortPage.hotelDataListSaveButonu.click();
//        Assert.assertTrue(qaConcortPage.hotelDataListSaveButonu.isDisplayed(),"save butonu gorunmuyor");
        Driver.closeDriver();
    }
}


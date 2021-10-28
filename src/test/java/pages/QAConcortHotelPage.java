package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortHotelPage {

    WebDriver driver;

    public QAConcortHotelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   // @FindBy(linkText = "Log in")
    @FindBy (xpath = "(//a[@class='nav-link'])[7]")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement usernameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    public void ConcortHotelLogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortHotelPage qaConcortHotelPage = new QAConcortHotelPage();
        Thread.sleep(1000);
        qaConcortHotelPage.ilkLoginLinki.click();
        qaConcortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(2000);
        qaConcortHotelPage.loginButonu.click();
    }

}

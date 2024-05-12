package configuration;

import Data.GetData;
import Pages.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {

    public static AppiumDriver<WebElement> driver = null;
    public static WebDriverWait wait;
    public LoginPage loginPage;
    public AllCategoriesPage allCategoriesPage;
    public BasePage basePage;
    public HomePage homePage;
    public MenuPage menuPage;
    public MyAccountPage myAccountPage;
    public ProductPage productPage;
    public ProductDetailPage productDetailPage;
    public GetData getData;
    @BeforeAll
    public void setup() {
        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();
            cap.setCapability("platformName", "Android");
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(driver, 25);

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL exception.");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Hepsiburada").click();
        loginPage = new LoginPage((AndroidDriver<WebElement>) driver);
        allCategoriesPage = new AllCategoriesPage((AndroidDriver<WebElement>) driver);
        basePage = new BasePage((AndroidDriver<WebElement>) driver);
        homePage = new HomePage((AndroidDriver<WebElement>) driver);
        menuPage = new MenuPage((AndroidDriver<WebElement>) driver);
        myAccountPage = new MyAccountPage((AndroidDriver<WebElement>) driver);
        productDetailPage = new ProductDetailPage((AndroidDriver<WebElement>) driver);
        productPage = new ProductPage((AndroidDriver<WebElement>) driver);
        getData = new GetData((AndroidDriver<WebElement>) driver);
    }

}

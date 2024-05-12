package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final AndroidDriver<WebElement> driver;
    WebDriverWait wait;

    public ProductPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }

    private final By priceRangeFilterButton = By.xpath("//android.widget.TextView[@resource-id=\"com.pozitron.hepsiburada:id/tvTitle\" and @text=\"Fiyat Aralığı\"]");
    private final By minPriceField = By.id("com.pozitron.hepsiburada:id/editTextPriceMin");
    private final By maxPriceField = By.id("com.pozitron.hepsiburada:id/editTextPriceMax");
    private final By applyFilter = By.id("com.pozitron.hepsiburada:id/btnFiltersApply");

    public void filterPriceRange(String minPrice, String maxPrice) {
        wait.until(ExpectedConditions.elementToBeClickable(priceRangeFilterButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(minPriceField)).sendKeys(minPrice);
        wait.until(ExpectedConditions.elementToBeClickable(maxPriceField)).sendKeys(maxPrice);
        wait.until(ExpectedConditions.elementToBeClickable(applyFilter)).click();
    }

    public void selectListedProduct(int productNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@resource-id=\"com.pozitron.hepsiburada:id/ivProduct\"])[" + productNumber + "]"))).click();
    }

}

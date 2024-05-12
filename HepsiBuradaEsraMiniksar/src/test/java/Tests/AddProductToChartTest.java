package Tests;

import configuration.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddProductToChartTest extends BaseTest {

    @Test
    @Order(1)
    public void searchProductInAllCategories() {
        homePage.clickAllCategories();
        allCategoriesPage.searchProduct(getData.productName);
    }

    @Test
    @Order(2)
    public void selectProduct() {
        productPage.filterPriceRange(getData.minPrice, getData.maxPrice);
        productPage.selectListedProduct(3);
    }

    @Test
    @Order(3)
    public void validateAddChartButton() {
        productDetailPage.validateAddChartButton();
    }
}

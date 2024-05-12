package Tests;

import configuration.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    @Test
    @Order(1)
    public void permissionApproval() {
        basePage.disallowPermission();
    }

    @Test
    @Order(2)
    public void login() {
        menuPage.clickMyAccount();
        myAccountPage.clickLoginButton();
        loginPage.loginApplication(getData.email, getData.password);
    }

    @Test
    @Order(3)
    public void validateLogin() {
        myAccountPage.clickWelcomePopUpOkButton();
        myAccountPage.validateUserNameField();
    }
}


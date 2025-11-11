package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.components.NavigationBar;
import cz.datbp2025.veverkyukol.pages.BasePage;
import cz.datbp2025.veverkyukol.pages.LoginPage;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.PublicHomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static cz.datbp2025.veverkyukol.pages.BasePage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {


    @ParameterizedTest
    //TODO Switch CSVSource for MethodSource with secure loading of credentials
    @CsvSource({
            "'master admin', kutalkovad+ma@gmail.com, AppRoot123",
            "admin, kutalkovad+a@gmail.com, Czechitas123",
            "parent, kutalkovad+parentedit@gmail.com, Rodic8"
    })
    void userCanLogIn(String role, String email, String password) {
        driver.get(BASE_URL);

        new NavigationBar(driver)
                .goToLogin()
                .logInAsValid(email, password, role.equals("parent"));

        assertTrue(new NavigationBar(driver).isUserLoggedIn());
    }

    @Test
    void parentRedirectedAfterLogin() {
        driver.get(LoginPage.URL);

        new LoginPage(driver).logInAsValid(PARENT_EMAIL, PARENT_PASSWORD, true);

        assertEquals(ParentApplicationsPage.URL, driver.getCurrentUrl());
        assertTrue(new NavigationBar(driver).isUserLoggedIn());
    }

    @Test
    void userCannotLogInWithoutPassword() {
        driver.get(LoginPage.URL);

        new LoginPage(driver).logInWithoutPassword(PARENT_EMAIL);

        assertEquals(LoginPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());
    }

    @ParameterizedTest
    @CsvSource({
            "'master admin', kutalkovad+ma@gmail.com, AppRoot123",
            "admin, kutalkovad+a@gmail.com, Czechitas123",
            "parent, kutalkovad+parentedit@gmail.com, Rodic8"
    })
    void userCanLogOut(String role, String email, String password) {
        driver.get(LoginPage.URL);
        new LoginPage(driver).logInAsValid(email, password, role.equals("parent") );
        NavigationBar nav = new NavigationBar(driver);
        assertTrue(nav.isUserLoggedIn());

        nav.logOut();

        assertEquals(PublicHomePage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());
    }
}
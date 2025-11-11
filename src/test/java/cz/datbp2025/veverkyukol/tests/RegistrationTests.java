package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.components.NavigationBar;
import cz.datbp2025.veverkyukol.model.UserData;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static cz.datbp2025.veverkyukol.pages.BasePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests extends BaseTest {

    @Test
    void userCanRegister() throws InterruptedException {
        UserData userData = new UserData.Builder().defaultData().build();
        driver.get(BASE_URL);

        new NavigationBar(driver)
                .goToLogin()
                .goToRegistration()
                .register(userData, true);

        assertEquals(ParentApplicationsPage.URL, driver.getCurrentUrl());
        assertTrue(new NavigationBar(driver).isUserLoggedIn());
    }

    @Test
    void userCannotRegisterWithoutRequiredFields() {
        final UserData data1 = new UserData.Builder().build();
        final UserData data2 = new UserData.Builder().from(data1).withName("Automatická Veverka").build();
        final UserData data3 = new UserData.Builder().from(data2).withEmail("automaticka.veverka@danakut.cz").build();
        final UserData data4 = new UserData.Builder().from(data3).withPassword("Password1").build();
        driver.get(RegistrationPage.URL);

        new RegistrationPage(driver).register(data1, false);
        assertEquals(RegistrationPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());

        new RegistrationPage(driver).register(data2, false);
        assertEquals(RegistrationPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());

        new RegistrationPage(driver).register(data3, false);
        assertEquals(RegistrationPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());

        new RegistrationPage(driver).register(data4, false);
        assertEquals(RegistrationPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());
    }

    @Test
    void userCannotRegisterWithoutMatchingPasswords() {
        final UserData data = new UserData.Builder()
                .defaultData()
                .withPassword("another password")
                .build();
        assertNotEquals(data.password(), data.passwordConfirm());
        driver.get(RegistrationPage.URL);

        new RegistrationPage(driver).register(data, false);

        assertEquals(RegistrationPage.URL, driver.getCurrentUrl());
        assertFalse(new NavigationBar(driver).isUserLoggedIn());
    }
}
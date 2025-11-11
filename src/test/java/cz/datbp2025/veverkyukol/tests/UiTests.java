package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.components.NavigationBar;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static cz.datbp2025.veverkyukol.pages.BasePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiTests extends BaseTest {

    private static final int DESKTOP_WIDTH = 800;
    private static final int MOBILE_WIDTH = 700;

    private void setWindowWidthToDesktop() {
        Dimension original = driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, original.height));
    }

    private void setWindowWidthToMobile() {
        Dimension original = driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, original.height));
    }

    @Test
    void togglerButtonAppears() {
        driver.get(BASE_URL);
        NavigationBar navigationBar = new NavigationBar(driver);
        setWindowWidthToDesktop();
        assertFalse(navigationBar.navbarToggler().isDisplayed());

        setWindowWidthToMobile();

        assertTrue(navigationBar.navbarToggler().isDisplayed());
    }
}
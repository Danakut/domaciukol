package cz.datbp2025.veverkyukol.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    public static final String PARENT_EMAIL = "kutalkovad+parentedit@gmail.com";
    public static final String PARENT_PASSWORD = "Rodic8";
    public static final String ADMIN_EMAIL = "kutalkovad+a@gmail.com";
    public static final String ADMIN_PASSWORD = "Czechitas123";
    public static final String MASTER_ADMIN_EMAIL = "kutalkovad+ma@gmail.com";
    public static final String MASTER_ADMIN_PASSWORD = "AppRoot123";

    protected WebDriver driver;

    @BeforeEach
    protected void setup() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    protected void teardown() {
        driver.quit();
    }
}
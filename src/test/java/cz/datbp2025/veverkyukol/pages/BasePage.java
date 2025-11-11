package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public static final String BASE_URL = "https://veverkyexotky.datbp25.czechitas.online/";
    public static final int WAIT_DURATION = 10;

    //navbar change triggered by page width
    public static final int MEDIA_BREAKPOINT = 768;

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isMobileLayout() {
        return driver.manage().window().getSize().width < MEDIA_BREAKPOINT;
    }
}
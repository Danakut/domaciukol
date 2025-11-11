package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.WebDriver;

public class LoggedInHomePage extends BasePage {

    public static final String URL = BASE_URL;

    protected LoggedInHomePage(WebDriver driver) {
        super(driver);
        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("LoggedInHomePage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }
}
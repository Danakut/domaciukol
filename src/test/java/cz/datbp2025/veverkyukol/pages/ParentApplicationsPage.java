package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentApplicationsPage extends BasePage {

    public static final String URL = BASE_URL + "zaci";

    private final By createApplicationLinkLocator = By.linkText("Vytvořit novou přihlášku");

    public ParentApplicationsPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("ParentApplicationsPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    public WebElement createApplicationLink() {
        return driver.findElement(createApplicationLinkLocator);
    }

    public LoggedInHomePage navigateToCreateNewApplication() {
        driver.get(BASE_URL);
        return new LoggedInHomePage(driver);
    }
}
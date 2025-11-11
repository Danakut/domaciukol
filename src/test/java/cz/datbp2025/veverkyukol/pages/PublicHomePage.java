package cz.datbp2025.veverkyukol.pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicHomePage extends BasePage {

    public static final String URL = BASE_URL;

    private By logoLocator = By.xpath("//nav//a");



    public PublicHomePage(WebDriver driver) {
        super(driver);
        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("HomePage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    public void clickLogo() {
        driver.findElement(logoLocator).click();

    }
}
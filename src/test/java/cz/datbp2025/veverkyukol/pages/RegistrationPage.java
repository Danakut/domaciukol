package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.model.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public static final String URL = BASE_URL + "registrace";

    private final By nameInputLocator = By.id("name");
    private final By emailInputLocator = By.id("email");
    private final By passwordInputLocator = By.id("password");
    private final By passwordConfirmLocator = By.id("password-confirm");
    private final By registerButtonLocator = By.xpath("//button[@type='submit']");

    public RegistrationPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("RegistrationPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    public BasePage register(UserData userData, boolean valid) {
        driver.findElement(nameInputLocator).sendKeys(userData.name());
        driver.findElement(emailInputLocator).sendKeys(userData.email());
        driver.findElement(passwordInputLocator).sendKeys(userData.password());
        driver.findElement(passwordConfirmLocator).sendKeys(userData.password());
        driver.findElement(registerButtonLocator).click();

        if (valid) {
            return new ParentApplicationsPage(driver);
        } else {
            return this;
        }
    }

}
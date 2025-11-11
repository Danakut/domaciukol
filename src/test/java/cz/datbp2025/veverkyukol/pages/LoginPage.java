package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static final String URL = BASE_URL + "prihlaseni";

    private final By emailInputLocator = By.id("email");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.xpath("//button[@type='submit']");
    private final By registerLinkLocator = By.linkText("Zaregistrujte se");

    public LoginPage(WebDriver driver) {
        super(driver);
        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("LoginPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    public BasePage logInAsValid(String username, String password, boolean isParent) {
        if (username.equals("")) {
            throw new IllegalArgumentException("Valid username must not be blank.");
        }

        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }

        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();

        if (isParent) {
            return new ParentApplicationsPage(driver);
        } else {
            return new LoggedInHomePage(driver);
        }
    }

    public LoginPage logInWithoutPassword(String username) {
        if (username.equals("")) {
            throw new IllegalArgumentException("Valid username must not be blank.");
        }

        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(username);

        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();

        return new LoginPage(driver);
    }

    public RegistrationPage goToRegistration() {
        driver.findElement(registerLinkLocator).click();
        return new RegistrationPage(driver);
    }


}
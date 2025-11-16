package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.model.ApplicationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateApplicationPage extends BasePage {

    public static final String URL = BASE_URL + "zaci/pridat/";

    private By termButtonLocator = By.cssSelector("button[data-id='term_id']");
    private By parentNameLocator = By.id("parent_name");
    private By forenameLocator = By.id("forename");
    private By surnameLocator = By.id("surname");
    private By birthdayLocator = By.id("birthday");
    private By emailLocator = By.id("email");
    private By transferPaymentLocator = By.cssSelector("label[for='payment_transfer']");
    private By postalPaymentLocator = By.id("payment_postal_order");
    private By fkspPaymentLocator = By.id("payment_fksp");
    private By cashPaymentLocator = By.id("payment_cash");
    private By restrictionsCheckboxLocator = By.cssSelector("label[for='restrictions_yes']");
    private By restrictionsTextareaLocator = By.id("restrictions");
    private By noteLocator = By.id("note");
    private By tocCheckboxLocator = By.cssSelector("label[for='terms_conditions']");
    private By submitButtonLocator = By.cssSelector("[type = 'submit']");



    public CreateApplicationPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().matches(URL + "[0-9]+-[\\p{L}-]+$")) {
            throw new IllegalStateException("CreateApplicationPage: expected URL is " + URL + "[course code]. Actual URL is " + currentUrl() + ".");
        }
    }

    private By getTermLocator(String term) {
//        String locator = "//span[@class='text' and contains(text(), '15.11. - 16.11.2025')]";
        return By.xpath("//span[@class='text' and contains(text(), '" + term + "')]");
    }

    //TODO refactor to a more general method that throws a specific error when a piece of input data is invalid or missing
    public ParentApplicationDetailPage fillAndSubmitApplication(ApplicationData data) {
        if (data.payment() == null) {
            throw new IllegalArgumentException("Application data incomplete - payment method must be specified.");
        }

        driver.findElement(termButtonLocator).click();
        driver.findElement(getTermLocator(data.term())).click();

        WebElement parentNameInput = driver.findElement(parentNameLocator);
        parentNameInput.clear();
        parentNameInput.sendKeys(data.parentName());

        driver.findElement(forenameLocator);
        driver.findElement(forenameLocator).sendKeys(data.forename());
        driver.findElement(surnameLocator).sendKeys(data.surname());
        driver.findElement(birthdayLocator).sendKeys(data.dob());

        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.clear();
        emailInput.sendKeys(data.email());

        driver.findElement(
                switch (data.payment()) {
                    case TRANSFER -> transferPaymentLocator;
                    case POSTAL -> postalPaymentLocator;
                    case FKSP -> fkspPaymentLocator;
                    case CASH -> cashPaymentLocator;
                }
        ).click();

        if (data.isRestricted()) {
            driver.findElement(restrictionsCheckboxLocator).click();
            driver.findElement(restrictionsTextareaLocator).sendKeys(data.restrictionsText());
        }

        driver.findElement(noteLocator).sendKeys(data.note());
        if (data.agreedWithToc()) driver.findElement(tocCheckboxLocator).click();
        driver.findElement(submitButtonLocator).click();
        return new ParentApplicationDetailPage(driver);
    }
}
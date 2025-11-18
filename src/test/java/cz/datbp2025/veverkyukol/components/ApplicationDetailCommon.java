package cz.datbp2025.veverkyukol.components;

import cz.datbp2025.veverkyukol.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationDetailCommon extends BasePage {

    private final By paymentMethodLocator = By.xpath("//td[text()='Způsoby úhrady kurzu:']/following-sibling::*");
    private final By toPayLocator = By.xpath("//td[text()='Zbývá uhradit']/following-sibling::*");
    private final By parentNameLocator = By.xpath("//td[text()='Jméno a příjmení zákonného zástupce:']/following-sibling::*");
    private final By forenameLocator = By.xpath("//td[text()='Křestní jméno žáka:']/following-sibling::*");
    private final By surnameLocator = By.xpath("//td[text()='Příjmení žáka:']/following-sibling::*");
    private final By dobLocator = By.xpath("//td[text()='Datum narození žáka:']/following-sibling::*");
    private final By emailLocator = By.xpath("//td[text()='Email zák. zástupce:']/following-sibling::*");
    private final By restrictionsTextLocator = By.xpath("//td[text()='Zdravotní omezení:']/following-sibling::*");
    private final By noteLocator = By.xpath("//td[text()='Poznámka:']/following-sibling::*");
    private final By applicationConfirmationLocator = By.xpath("//td[text()='Potvrzení']/following::a[@title='Stáhnout potvrzení o přihlášení']");
    private final By paymentConfirmationLocator = By.xpath("//td[text()='Potvrzení']/following::a[@title='Stáhnout potvrzení o zaplacení']");
    private final By createdAtLocator = By.xpath("//td[text()='Vytvořen:']/following-sibling::*");


    public ApplicationDetailCommon(WebDriver driver) {
        super(driver);


    }

    public String getPaymentMethod() {
        return driver.findElement(paymentMethodLocator).getText();
    }

    public String getAmountToPay() {
        return driver.findElement(toPayLocator).getText();
    }

    public String getParentName() {
        return driver.findElement(parentNameLocator).getText();
    }

    public String getForename() {
        return driver.findElement(forenameLocator).getText();
    }

    public String getSurname() {
        return driver.findElement(surnameLocator).getText();
    }

    public String getDob() {
        return driver.findElement(dobLocator).getText();
    }

    public String getEmail() {
        return driver.findElement(emailLocator).getText();
    }

    public String getRestrictionsText() {
        return driver.findElement(restrictionsTextLocator).getText();
    }

    public String getNote() {
        return driver.findElement(noteLocator).getText();
    }

    public WebElement getApplicationConfirmation() {
        return driver.findElement(applicationConfirmationLocator);
    }

    public WebElement getPaymentConfirmation() {
        return driver.findElement(paymentConfirmationLocator);
    }

    public String getCreatedAt() {
        return driver.findElement(createdAtLocator).getText();
    }


}
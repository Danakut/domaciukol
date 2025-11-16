package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentApplicationDetailPage extends BasePage {

    public static final String URL = BASE_URL + "zaci/";

    private final By parentNameLocator = By.xpath("//td[text()='Jméno a příjmení zákonného zástupce:']/following-sibling::*");
    private final By forenameLocator = By.xpath("//td[text()='Křestní jméno žáka:']/following-sibling::*");
    private final By surnameLocator = By.xpath("//td[text()='Příjmení žáka:']/following-sibling::*");
    private final By dobLocator = By.xpath("//td[text()='Datum narození žáka:']/following-sibling::*");
    private final By emailLocator = By.xpath("//td[text()='Email zák. zástupce:']/following-sibling::*");
    private final By restrictionsTextLocator = By.xpath("//td[text()='Zdravotní omezení:']/following-sibling::*");
    private final By noteLocator = By.xpath("//td[text()='Poznámka:']/following-sibling::*");
    private final By applicationConfirmationLocator = By.xpath("//td[text()='Potvrzení']/following::a[@title='Stáhnout potvrzení o přihlášení']");
    private final By createdAtLocator = By.xpath("//td[text()='Vytvořen:']/following-sibling::*");


    public ParentApplicationDetailPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().matches(URL + "[0-9]+$")) {
            throw new IllegalStateException("ParentApplicationPage: expected URL is " + URL + "[application_id]. Actual URL is " + currentUrl() + ".");
        }
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

    public String getCreatedAt() {
        return driver.findElement(createdAtLocator).getText();
    }

}
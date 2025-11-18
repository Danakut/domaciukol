package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.components.ApplicationDetailCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParentApplicationDetailPage extends BasePage {

    public static final String URL = BASE_URL + "zaci/";

    private final By accountNumberLocator = By.xpath("//td[text()='Číslo účtu']/following-sibling::*");
    private final By accountAddressLocator = By.xpath("//td[text()='Adresa majitele účtu']/following-sibling::*");
    private final By vsLocator = By.xpath("//td[text()='Variabilní symbol']/following-sibling::*");
    private final By ksLocator = By.xpath("//td[text()='Konstantní symbol']/following-sibling::*");
    private final By messageForRecipientLocator = By.xpath("//td[text()='Zpráva pro příjemce']/following-sibling::*");
    private final By qrLocator = By.cssSelector("img[alt='QR Platba']");
    private final By invoiceMessageLocator = By.xpath("//td[text()='Vystavíme vám fakturu pro vašeho zaměstnavatele']");
    private final By cashMessageLocator = By.xpath("//td[text()='Prosíme o realizaci platby v kanceláři na základě osobní domluvy']");

    private ApplicationDetailCommon common;

    public ParentApplicationDetailPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().matches(URL + "[0-9]+$")) {
            throw new IllegalStateException("ParentApplicationPage: expected URL is " + URL + "[application_id]. Actual URL is " + currentUrl() + ".");
        }

        common = new ApplicationDetailCommon(driver);
    }

    public ApplicationDetailCommon common() {
        return common;
    }

    public String getAccountNumber() {
        return driver.findElement(accountNumberLocator).getText();
    }

    public String getAccountAddressNumber() {
        return driver.findElement(accountAddressLocator).getText();
    }

    public String getVs() {
        return driver.findElement(vsLocator).getText();
    }

    public String getKs() {
        return driver.findElement(ksLocator).getText();
    }

    public String getMessageForRecipient() {
        return driver.findElement(messageForRecipientLocator).getText();
    }

    public WebElement getQrCode() {
        return driver.findElement(qrLocator);
    }

    public WebElement getInvoiceMessage() {
        return driver.findElement(invoiceMessageLocator);
    }

    public WebElement getCashMessage() {
        return driver.findElement(cashMessageLocator);
    }

}
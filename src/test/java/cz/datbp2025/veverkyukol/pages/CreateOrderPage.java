package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.model.DayCampData;
import cz.datbp2025.veverkyukol.model.DayCampOrder;
import cz.datbp2025.veverkyukol.model.OrderData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage extends BasePage {

    public static final String URL = BASE_URL + "objednavka/pridat";

    private By icoLocator = By.id("ico");
    private By clientLocator = By.id("client");
    private By addressLocator = By.id("address");
    private By substituteLocator = By.id("substitute");
    private By contactNameLocator = By.id("contact_name");
    private By phoneLocator = By.id("contact_tel");
    private By emailLocator = By.id("contact_mail");
    private By start1Locator = By.id("start_date_1");
    private By end1Locator = By.id("end_date_1");
    private By start2Locator = By.id("start_date_2");
    private By end2Locator = By.id("end_date_2");
    private By start3Locator = By.id("start_date_3");
    private By end3Locator = By.id("end_date_3");
    private By dayCampLocator = By.id("nav-home-tab");
    private By natureCampLocator = By.id("nav-profile-tab");
    private By selectTimeLocator = By.id("camp-date_part");
    private By childCountLocator = By.id("camp-students");
    private By ageLocator = By.id("camp-age");
    private By teacherCountLocator = By.id("camp-adults");
    private By submitLocator = By.cssSelector("input[type=submit]");
    private By confirmationLocator = By.xpath("//h3[text()='Děkujeme za objednávku']");


    public CreateOrderPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("CreateOrderPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    private void fillData(OrderData data) {
        driver.findElement(icoLocator).sendKeys(data.ico());
        driver.findElement(clientLocator).sendKeys(data.client());
        driver.findElement(addressLocator).sendKeys(data.address());
        driver.findElement(substituteLocator).sendKeys(data.substitute());
        driver.findElement(contactNameLocator).sendKeys(data.contactName());
        driver.findElement(phoneLocator).sendKeys(data.phone());
        driver.findElement(emailLocator).sendKeys(data.email());
        driver.findElement(start1Locator).sendKeys(data.start1());
        driver.findElement(end1Locator).sendKeys(data.end1());

        if (!(data.start2().isBlank() || data.end2().isBlank())){
            driver.findElement(start2Locator).sendKeys(data.start2());
            driver.findElement(end2Locator).sendKeys(data.end2());
        }

        if (!(data.start3().isBlank() || data.end3().isBlank())){
            driver.findElement(start3Locator).sendKeys(data.start3());
            driver.findElement(end3Locator).sendKeys(data.end3());
        }
    }

    private void fillDayCamp(DayCampData data) {
        Select timeSelect = new Select(driver.findElement(selectTimeLocator));
        timeSelect.selectByValue(
                switch (data.courseTime()) {
                    case AM -> "forenoon";
                    case PM -> "afternoon";
                }
        );
        driver.findElement(childCountLocator).sendKeys(String.valueOf(data.childCount()));
        driver.findElement(ageLocator).sendKeys(data.age());
        driver.findElement(teacherCountLocator).sendKeys(String.valueOf(data.teacherCount()));

    }

    public CreateOrderPage fillDayCampOrder(DayCampOrder order) {
        fillData(order.common());
        driver.findElement(dayCampLocator).click();
        fillDayCamp(order.details());
        driver.findElement(submitLocator).click();
        return new CreateOrderPage(driver);
    }

    public boolean orderConfirmed() {
        try {
            driver.findElement(confirmationLocator);;
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
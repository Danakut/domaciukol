package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.components.Pagination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ParentApplicationsPage extends BasePage {

    public static final String URL = BASE_URL + "zaci";

    private final By createApplicationLinkLocator = By.linkText("Vytvořit novou přihlášku");
    private final By rowsLocator = By.cssSelector("tbody tr");

    public ParentApplicationsPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("ParentApplicationsPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }

    public Pagination paginator() {
        return new Pagination(driver);
    }

    public WebElement createApplicationLink() {
        return driver.findElement(createApplicationLinkLocator);
    }

    public LoggedInHomePage navigateToCreateNewApplication() {
        driver.get(BASE_URL);
        return new LoggedInHomePage(driver);
    }

    public List<WebElement> getApplications() {
        Pagination paginator = new Pagination(driver);
        paginator.firstPage();
        List<WebElement> rows = driver.findElements(rowsLocator);
        paginator = new Pagination(driver);
        while (paginator.hasNextPage()) {
            paginator.nextPage();
            rows.addAll(driver.findElements(rowsLocator));
            paginator = new Pagination(driver);
        }

        return rows;
    }
}
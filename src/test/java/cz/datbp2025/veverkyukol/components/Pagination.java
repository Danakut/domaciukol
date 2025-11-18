package cz.datbp2025.veverkyukol.components;

import cz.datbp2025.veverkyukol.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Pagination extends BasePage {

    private WebElement paginationRoot;

    private By paginationLocator = By.cssSelector("ul.pagination");
    private By previousLocator = By.cssSelector("a[data-dt-idx = 'previous']");
    private By nextLocator = By.cssSelector("a[data-dt-idx = 'next']");
    private By firstLocator = By.cssSelector("a[data-dt-idx = '1']");

    public Pagination(WebDriver driver) {
        super(driver);

        wait.until(ExpectedConditions.presenceOfElementLocated(paginationLocator));
        paginationRoot = driver.findElement(paginationLocator);
    }

    public void previousPage() {
        WebElement element = paginationRoot.findElement(previousLocator);
        if (element.getAttribute("aria-disabled") == null) {
            element.click();
        } else {
            throw new IllegalStateException("Pagination: Cannot go to the previous page, because there is none.");
        }
    }

    public void nextPage() {
        WebElement element = paginationRoot.findElement(nextLocator);
        if (element.getAttribute("aria-disabled") == null) {
            element.click();
        } else {
            throw new IllegalStateException("Pagination: Cannot go to the next page, because there is none.");
        }
    }

    public void firstPage() {
        paginationRoot.findElement(firstLocator).click();
    }

    public boolean hasPreviousPage() {
        WebElement element = paginationRoot.findElement(previousLocator);
        return element.getAttribute("aria-disabled") == null;
    }

    public boolean hasNextPage() {
        WebElement element = paginationRoot.findElement(nextLocator);
        return element.getAttribute("aria-disabled") == null;
    }
}
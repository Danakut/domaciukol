package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.WebDriver;

public class ParentApplicationsPage extends BasePage {

    public static final String URL = BASE_URL + "zaci";

    protected ParentApplicationsPage(WebDriver driver) {
        super(driver);

        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("ParentApplicationsPage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }
    }
}
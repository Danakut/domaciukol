package cz.datbp2025.veverkyukol.pages;

import org.openqa.selenium.WebDriver;

public class ParentApplicationDetailPage extends BasePage {

    public static final String URL = BASE_URL + "zaci/";


    public ParentApplicationDetailPage(WebDriver driver) {
        super(driver);

        System.out.println(this.getClass().toString());

        if (!currentUrl().matches(URL + "[0-9]+$")) {
            throw new IllegalStateException("ParentApplicationPage: expected URL is " + URL + "[application_id]. Actual URL is " + currentUrl() + ".");
        }
    }
}
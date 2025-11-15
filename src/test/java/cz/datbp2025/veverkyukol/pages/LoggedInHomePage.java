package cz.datbp2025.veverkyukol.pages;

import cz.datbp2025.veverkyukol.components.CoursePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage extends BasePage {

    public static final String URL = BASE_URL;

    private CoursePicker coursePicker;

    public LoggedInHomePage(WebDriver driver) {
        super(driver);
        if (!currentUrl().equals(URL)) {
            throw new IllegalStateException("LoggedInHomePage: expected URL is " + URL + ". Actual URL is " + currentUrl() + ".");
        }

        coursePicker = new CoursePicker(driver);
    }

    public CoursePicker getCoursePicker() {
        return coursePicker;
    }

}
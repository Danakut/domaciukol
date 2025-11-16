package cz.datbp2025.veverkyukol.components;

import cz.datbp2025.veverkyukol.pages.BasePage;
import cz.datbp2025.veverkyukol.pages.CreateApplicationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePicker extends BasePage {

    private WebElement levelRoot;

    private By levelRootLocator = By.cssSelector("div.row.intro_cards");

    private By programovaniHeaderLocator = By.xpath(".//img[@alt='Programování']/../following::a[text() = 'Více informací']");
    private By sebeobsluhaHeaderLocator = By.xpath(".//img[@alt='Sebeobsluha']/../following::a[text() = 'Více informací']");
    private By javaScriptHeaderLocator = By.xpath(".//img[@alt='JavaScript']/../following::a[text() = 'Vytvořit přihlášku']");



    public CoursePicker(WebDriver driver) {
        super(driver);

        //find elements from a root instead of the whole DOM
        levelRoot = driver.findElement(levelRootLocator);
    }

    public CoursePicker navigateToProgramovani() {
        levelRoot.findElement(programovaniHeaderLocator).click();
        return new CoursePicker(driver);
    }

    public CoursePicker navigateToSebeobsluha() {
        levelRoot.findElement(sebeobsluhaHeaderLocator).click();
        return new CoursePicker(driver);
    }

    public CreateApplicationPage navigateToJavaScript() {
        levelRoot.findElement(javaScriptHeaderLocator).click();
        return new CreateApplicationPage(driver);
    }

}
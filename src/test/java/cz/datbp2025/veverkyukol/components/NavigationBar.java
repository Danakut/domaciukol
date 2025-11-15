package cz.datbp2025.veverkyukol.components;

import cz.datbp2025.veverkyukol.pages.BasePage;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.PublicHomePage;
import cz.datbp2025.veverkyukol.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar extends BasePage {

    private WebElement navRoot;

    private By navLocator = By.tagName("nav");
    private By logoLocator = By.tagName("a");
    private By navbarTogglerLocator = By.tagName("button");

    private By homeLinkLocator = By.linkText("Domů");

    private By applicationsLinkLocator = By.linkText("Přihlášky");

    private By forParentsLink = By.linkText("Pro rodiče");
    private By parentManualsLinkLocator = By.xpath(".//a[contains(@href, '/pro-rodice') and text()='Návody a formuláře']");
    private By createApplicationLinkLocator = By.linkText("Vytvořit přihlášku");

    private By forTeachersLink = By.linkText("Pro učitelé");
    private By teacherManualsLinkLocator = By.xpath(".//a[contains(@href, '/pro-ucitele') and text()='Návody a formuláře']");
    private By schoolOrderLinkLocator = By.linkText("Objednávka pro MŠ/ZŠ");

    private By contactLinkLocator = By.linkText("Kontakt");

    private By loginLinkLocator = By.linkText("Přihlásit");
    private By loggedInIndicatorLocator = By.xpath(".//span[text()='Přihlášen']");
    private By userLinkLocator = By.xpath(".//span[text()='Přihlášen']/parent::div/a");


    public NavigationBar(WebDriver driver) {
        super(driver);

        //find elements from navRoot instead of the whole DOM
        navRoot = driver.findElement(navLocator);
    }

    public WebElement logo() {
        return navRoot.findElement(logoLocator);
    }

    public WebElement navbarToggler() {
        return navRoot.findElement(navbarTogglerLocator);
    }

    public WebElement homeLink() {
        return navRoot.findElement(homeLinkLocator);
    }

    public WebElement applicationsLink() {
        return navRoot.findElement(applicationsLinkLocator);
    }

    public WebElement parentManualsLink() {
        navRoot.findElement(forParentsLink).click();
        return navRoot.findElement(parentManualsLinkLocator);
    }

    public WebElement createApplicationLink() {
        navRoot.findElement(forParentsLink).click();
        return navRoot.findElement(createApplicationLinkLocator);
    }

    public WebElement teacherManualsLink() {
        navRoot.findElement(forTeachersLink).click();
        return navRoot.findElement(teacherManualsLinkLocator);
    }

    public WebElement schoolOrderLink() {
        navRoot.findElement(forTeachersLink).click();
        return navRoot.findElement(schoolOrderLinkLocator);
    }

    public WebElement contactLink() {
        return navRoot.findElement(contactLinkLocator);
    }

    public WebElement loginLink() {
        return navRoot.findElement(loginLinkLocator);
    }

    public LoginPage navigateToLogin() {
        loginLink().click();
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn() {
        try {
            navRoot.findElement(loggedInIndicatorLocator);
            return true;
        } catch (NoSuchElementException e) {
            navRoot.findElement(loginLinkLocator);
            return false;
        }
    }

    public PublicHomePage logOut() {
        WebElement userLink = navRoot.findElement(userLinkLocator);
        userLink.click();
        WebElement logoutLink = userLink.findElement(By.xpath("./following-sibling::div/a[contains(text(), 'Odhlásit')]"));
        logoutLink.click();
        return new PublicHomePage(driver);
    }

    public ParentApplicationsPage navigateToApplications() {
        applicationsLink().click();
        return new ParentApplicationsPage(driver);
    }

    public boolean isUserRoleParent() {
        try {
            navRoot.findElement(applicationsLinkLocator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
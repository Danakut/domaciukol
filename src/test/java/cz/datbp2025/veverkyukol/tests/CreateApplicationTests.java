package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.model.ApplicationData;
import cz.datbp2025.veverkyukol.pages.ParentApplicationDetailPage;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.PublicHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cz.datbp2025.veverkyukol.pages.BasePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateApplicationTests extends BaseTest {

    @Test
    @Tag("DATBP25V-27")
    @Tag(REGRESSION)
    void createValidApplicationAsParent() {
        driver.get(BASE_URL);

        ApplicationData data = new ApplicationData.Builder()
                .defaultData()
                .build();

        new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(data);

        //TODO check - find the application in the application list
//        assertTrue(driver.getCurrentUrl().startsWith(ParentApplicationDetailPage.URL));
    }
}
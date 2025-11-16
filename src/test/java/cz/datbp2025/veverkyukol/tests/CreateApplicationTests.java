package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.model.ApplicationData;
import cz.datbp2025.veverkyukol.pages.ParentApplicationDetailPage;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.PublicHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cz.datbp2025.veverkyukol.pages.BasePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateApplicationTests extends BaseTest {

    @Test
    @Tag("DATBP25V-27")
    @Tag(REGRESSION)
    void createValidApplicationAsParent() {
        driver.get(BASE_URL);

        //start
        ParentApplicationsPage parentApplicationsPage = new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD);

        //record the count of applications for an assertion done later
        int applicationCountBefore = parentApplicationsPage.getApplications().size();

        //continue
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .build();
        ParentApplicationDetailPage applicationDetailPage = parentApplicationsPage
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(testData);

        assertEquals(testData.parentName(), applicationDetailPage.getParentName());
        assertEquals(testData.forename(), applicationDetailPage.getForename());
        assertEquals(testData.surname(), applicationDetailPage.getSurname());
        assertEquals(testData.dob(), applicationDetailPage.getDob());
        assertEquals(testData.email(), applicationDetailPage.getEmail());
        assertEquals("Stáhnout potvrzení o přihlášení", applicationDetailPage.getApplicationConfirmation().getAttribute("title"));
        //potentially brittle, but interesting
//        assertEquals(testData.createdAt(), applicationDetailPage.getCreatedAt());

        //confirm the application count has increased by one
        driver.get(ParentApplicationsPage.URL);
        int applicationCountAfter = new ParentApplicationsPage(driver).getApplications().size();
        assertEquals(applicationCountBefore, applicationCountAfter-1);
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithRestrictions() {
        driver.get(BASE_URL);

        //start
        ParentApplicationsPage parentApplicationsPage = new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD);

        //record the count of applications for an assertion done later
        int applicationCountBefore = parentApplicationsPage.getApplications().size();

        //continue
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withRestricted(true)
                .withRestrictionsText("Je alergická na pyl.")
                .build();
        ParentApplicationDetailPage applicationDetailPage = parentApplicationsPage
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(testData);

        assertEquals(testData.parentName(), applicationDetailPage.getParentName());
        assertEquals(testData.forename(), applicationDetailPage.getForename());
        assertEquals(testData.surname(), applicationDetailPage.getSurname());
        assertEquals(testData.dob(), applicationDetailPage.getDob());
        assertEquals(testData.email(), applicationDetailPage.getEmail());
        assertEquals(testData.restrictionsText(), applicationDetailPage.getRestrictionsText());
        assertEquals("Stáhnout potvrzení o přihlášení", applicationDetailPage.getApplicationConfirmation().getAttribute("title"));

        //confirm the application count has increased by one
        driver.get(ParentApplicationsPage.URL);
        int applicationCountAfter = new ParentApplicationsPage(driver).getApplications().size();
        assertEquals(applicationCountBefore, applicationCountAfter-1);

    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithNote() {
        driver.get(BASE_URL);

        //start
        ParentApplicationsPage parentApplicationsPage = new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD);

        //record the count of applications for an assertion done later
        int applicationCountBefore = parentApplicationsPage.getApplications().size();

        //continue
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withNote("Toto je veverčí poznámka.")
                .build();
        ParentApplicationDetailPage applicationDetailPage = parentApplicationsPage
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(testData);

        assertEquals(testData.parentName(), applicationDetailPage.getParentName());
        assertEquals(testData.forename(), applicationDetailPage.getForename());
        assertEquals(testData.surname(), applicationDetailPage.getSurname());
        assertEquals(testData.dob(), applicationDetailPage.getDob());
        assertEquals(testData.email(), applicationDetailPage.getEmail());
        assertEquals(testData.note(), applicationDetailPage.getNote());
        assertEquals("Stáhnout potvrzení o přihlášení", applicationDetailPage.getApplicationConfirmation().getAttribute("title"));

        //confirm the application count has increased by one
        driver.get(ParentApplicationsPage.URL);
        int applicationCountAfter = new ParentApplicationsPage(driver).getApplications().size();
        assertEquals(applicationCountBefore, applicationCountAfter-1);

    }

}
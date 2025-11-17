package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.model.ApplicationData;
import cz.datbp2025.veverkyukol.model.PaymentMethod;
import cz.datbp2025.veverkyukol.pages.ParentApplicationDetailPage;
import cz.datbp2025.veverkyukol.pages.ParentApplicationsPage;
import cz.datbp2025.veverkyukol.pages.PublicHomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

import static cz.datbp2025.veverkyukol.pages.BasePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(NoSuchElementException.class, applicationDetailPage::getNote);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getRestrictionsText);
        //potentially brittle, but interesting:
        //assertEquals(testData.createdAt(), applicationDetailPage.getCreatedAt());

        //confirm the application count has increased by one
        driver.get(ParentApplicationsPage.URL);
        int applicationCountAfter = new ParentApplicationsPage(driver).getApplications().size();
        assertEquals(applicationCountBefore, applicationCountAfter-1);
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithRestrictions() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withRestricted(true)
                .withRestrictionsText("Je alergická na pyl.")
                .build();

        ParentApplicationDetailPage applicationDetailPage = new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(testData);

        assertEquals(testData.forename(), applicationDetailPage.getForename());
        assertEquals(testData.surname(), applicationDetailPage.getSurname());
        assertEquals(testData.restrictionsText(), applicationDetailPage.getRestrictionsText());
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithNote() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withNote("Toto je veverčí poznámka.")
                .build();

        ParentApplicationDetailPage applicationDetailPage =
                new PublicHomePage(driver)
                .getNavigationBar()
                .navigateToLogin()
                .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                .navigateToCreateNewApplication()
                .getCoursePicker()
                .navigateToProgramovani()
                .navigateToJavaScript()
                .fillAndSubmitApplication(testData);

        assertEquals(testData.forename(), applicationDetailPage.getForename());
        assertEquals(testData.surname(), applicationDetailPage.getSurname());
        assertEquals(testData.note(), applicationDetailPage.getNote());
    }


    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithBankTransfer() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withPayment(PaymentMethod.TRANSFER)
                .build();

        ParentApplicationDetailPage applicationDetailPage =
                new PublicHomePage(driver)
                        .getNavigationBar()
                        .navigateToLogin()
                        .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                        .navigateToCreateNewApplication()
                        .getCoursePicker()
                        .navigateToProgramovani()
                        .navigateToJavaScript()
                        .fillAndSubmitApplication(testData);

        assertEquals("Bankovní převod", applicationDetailPage.getPaymentMethod());
        assertThrows(NoSuchElementException.class, applicationDetailPage::getInvoiceMessage);
        assertDoesNotThrow(applicationDetailPage::getAccountNumber);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAccountAddressNumber);
        assertDoesNotThrow(applicationDetailPage::getAmountToPay);
        assertDoesNotThrow(applicationDetailPage::getVs);
        assertDoesNotThrow(applicationDetailPage::getKs);
        assertDoesNotThrow(applicationDetailPage::getMessageForRecipient);
        assertDoesNotThrow(applicationDetailPage::getQrCode);
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithPostalOrder() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withPayment(PaymentMethod.POSTAL)
                .build();

        ParentApplicationDetailPage applicationDetailPage =
                new PublicHomePage(driver)
                        .getNavigationBar()
                        .navigateToLogin()
                        .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                        .navigateToCreateNewApplication()
                        .getCoursePicker()
                        .navigateToProgramovani()
                        .navigateToJavaScript()
                        .fillAndSubmitApplication(testData);

        assertEquals("Složenka", applicationDetailPage.getPaymentMethod());
        assertThrows(NoSuchElementException.class, applicationDetailPage::getInvoiceMessage);
        assertDoesNotThrow(applicationDetailPage::getAccountNumber);
        assertDoesNotThrow(applicationDetailPage::getAccountAddressNumber);
        assertDoesNotThrow(applicationDetailPage::getAmountToPay);
        assertDoesNotThrow(applicationDetailPage::getVs);
        assertDoesNotThrow(applicationDetailPage::getKs);
        assertDoesNotThrow(applicationDetailPage::getMessageForRecipient);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getQrCode);
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithFkspPayment() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withPayment(PaymentMethod.FKSP)
                .build();

        ParentApplicationDetailPage applicationDetailPage =
                new PublicHomePage(driver)
                        .getNavigationBar()
                        .navigateToLogin()
                        .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                        .navigateToCreateNewApplication()
                        .getCoursePicker()
                        .navigateToProgramovani()
                        .navigateToJavaScript()
                        .fillAndSubmitApplication(testData);

        assertEquals("FKSP", applicationDetailPage.getPaymentMethod());
        assertDoesNotThrow(applicationDetailPage::getInvoiceMessage);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAccountNumber);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAccountAddressNumber);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAmountToPay);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getVs);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getKs);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getMessageForRecipient);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getQrCode);
    }

    @Test
    @Tag("DATBP25V-27")
    void createApplicationWithCashPayment() {
        driver.get(BASE_URL);
        ApplicationData testData = new ApplicationData.Builder()
                .defaultData()
                .withPayment(PaymentMethod.CASH)
                .build();

        ParentApplicationDetailPage applicationDetailPage =
                new PublicHomePage(driver)
                        .getNavigationBar()
                        .navigateToLogin()
                        .loginAsParent(PARENT_EMAIL, PARENT_PASSWORD)
                        .navigateToCreateNewApplication()
                        .getCoursePicker()
                        .navigateToProgramovani()
                        .navigateToJavaScript()
                        .fillAndSubmitApplication(testData);

        assertEquals("Hotově", applicationDetailPage.getPaymentMethod());
        assertDoesNotThrow(applicationDetailPage::getCashMessage);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getInvoiceMessage);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAccountNumber);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAccountAddressNumber);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getAmountToPay);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getVs);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getKs);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getMessageForRecipient);
        assertThrows(NoSuchElementException.class, applicationDetailPage::getQrCode);
    }

}
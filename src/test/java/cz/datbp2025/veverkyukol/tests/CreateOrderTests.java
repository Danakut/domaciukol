package cz.datbp2025.veverkyukol.tests;

import cz.datbp2025.veverkyukol.model.DayCampOrder;
import cz.datbp2025.veverkyukol.pages.CreateOrderPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateOrderTests extends BaseTest {

    @Test
    void test() {
        driver.get(CreateOrderPage.URL);

        CreateOrderPage page = new CreateOrderPage(driver)
                .fillDayCampOrder(new DayCampOrder());

        assertTrue(page.orderConfirmed());
    }
}
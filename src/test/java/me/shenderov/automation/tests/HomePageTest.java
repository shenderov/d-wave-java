package me.shenderov.automation.tests;

import me.shenderov.automation.test.pageobjects.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Test(groups = "critical")
public class HomePageTest extends BaseTest {

    private HomePage homePage;
    //User full name, account type and expiry date should be set by test data generation
    private static final String FULL_NAME = "Konstantin Shenderov";
    private static final String ACCOUNT_TYPE = "Trial Plan";
    private static final String EXPIRY_DATE = "February 17, 2023 (UTC)";

    @BeforeClass
    public void setVariables() {
        homePage = login();
    }

    @Test
    public void shouldDisplayDashboardHeader() {
        assertEquals(homePage.getDashboardHeader(), "Dashboard");
    }

    @Test
    public void shouldDisplayFullUserName() {
        assertEquals(homePage.getFullName(), FULL_NAME);
    }

    @Test
    public void shouldDisplayAccountType() {
        assertEquals(homePage.getAccountType(), ACCOUNT_TYPE);
    }

    @Test
    public void shouldDisplayExpiryDate() {
        assertEquals(homePage.getExpiryDate(), EXPIRY_DATE);
    }

    @Test
    public void shouldDisplayApiToken() {
        homePage.clickOnShowToken();
        assertFalse(homePage.getApiToken().isBlank());
    }
}

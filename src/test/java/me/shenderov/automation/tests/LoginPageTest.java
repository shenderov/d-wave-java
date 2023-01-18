package me.shenderov.automation.tests;

import me.shenderov.automation.test.pageobjects.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "critical")
public class LoginPageTest extends BaseTest {

    @Test
    public void shouldDisplayLoginPageTitle() {
        String loginPageTitle = loginPage.getTitle();
        assertEquals(loginPageTitle, "Leap In");
    }

    @Test(dependsOnMethods = "shouldDisplayLoginPageTitle")
    public void shouldDisplayErrorMessageWithWrongCredentials() {
        loginPage.setUsername("joe.doe@company.com");
        loginPage.setPassword("Pa$$w0rd");
        loginPage.clickOnLoginButtonNegative();
        String errorMessage = loginPage.getErrorMessage();
        assertFalse(errorMessage.isEmpty());
    }

    @Test(dependsOnMethods = "shouldDisplayErrorMessageWithWrongCredentials")
    public void shouldLoginWithCorrectCredentials() {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        HomePage homePage = loginPage.clickOnLoginButton();
        assertFalse(homePage.getDashboardHeader().isEmpty());
    }

}

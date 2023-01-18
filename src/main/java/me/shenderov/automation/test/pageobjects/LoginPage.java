package me.shenderov.automation.test.pageobjects;

import me.shenderov.automation.test.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    /**
     * atLocator to be used in the constructor
     */
    private static final By atLocator = By.id("loginFormSubmit");

    private static final String title = "h1.title";
    private static final String usernameInput = "//input[@name='username']";
    private static final String passwordInput = "//input[@name='password']";
    private static final String loginButton = "loginFormSubmit";
    private static final String loginPageErrorMessage = "login-error";

    public LoginPage(WebDriver driver) {
        super(driver, atLocator);
    }

    public String getTitle() {
        return byCss(title).getText();
    }

    public void setUsername(String username) {
        byXpath(usernameInput).sendKeys(username);
    }

    public void setPassword(String password) {
        byXpath(passwordInput).sendKeys(password);
    }

    /**
     * Don't expect redirect to dashboard
     */
    public void clickOnLoginButtonNegative() {
        byId(loginButton).click();
    }

    public HomePage clickOnLoginButton() {
        byId(loginButton).click();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        return byClassName(loginPageErrorMessage).getText();
    }

}

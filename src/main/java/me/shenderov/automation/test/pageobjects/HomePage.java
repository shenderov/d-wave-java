package me.shenderov.automation.test.pageobjects;

import me.shenderov.automation.test.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    /**
     * atLocator to be used in the constructor
     */
    private static final By atLocator = By.className("dashboard-page");

    private static final String header = "dashboard-header";
    private static final String fullName = "full-name";
    private static final String accountType = ".account-type-upgrade-btn-container .body-text";
    private static final String expiryDate = ".renewal-expiry-heading + .body-text";
    private static final String showTokenIcon = "//*[@data-testid='api-token-field-button']";
    private static final String tokenInput = "component--ApiTokenField";

    public HomePage(WebDriver driver) {
        super(driver, atLocator);
    }

    public String getDashboardHeader() {
        return byClassName(header).getText();
    }

    public String getFullName() {
        return byClassName(fullName).getText();
    }

    public String getAccountType() {
        return byCss(accountType).getText();
    }

    public String getExpiryDate() {
        return byCss(expiryDate).getText();
    }

    public void clickOnShowToken() {
        byXpath(showTokenIcon).click();
    }

    public String getApiToken() {
        return byClassName(tokenInput).getAttribute("value");
    }

}

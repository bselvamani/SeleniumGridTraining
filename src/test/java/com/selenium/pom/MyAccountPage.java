package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    @FindBy(linkText = "My account")
    private WebElement lnkMyAccount;

    @FindBy(className = "logout")
    private WebElement lnkSignOut;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(this.lnkMyAccount));
        return lnkMyAccount.isDisplayed();
    }

    public void onClickSignOut() {
        lnkSignOut.click();
    }
}

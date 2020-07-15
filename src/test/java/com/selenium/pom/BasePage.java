package com.selenium.pom;

import com.selenium.helper.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    public void openURL() {
        driver.get(Config.getInstance().url());
    }
}
package com.selenium.testcases;

import static org.testng.AssertJUnit.assertTrue;

import com.selenium.helper.Config;
import com.selenium.pom.HomePage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void test_HomePage() {

        homePage = new HomePage(driver);
        assertTrue(homePage.isInitialized());
    }

    @Test
    public void test_LoginPage() {

        homePage = new HomePage(driver);
        assertTrue(homePage.isInitialized());

        loginPage = homePage.onClicklogin();
        assertTrue(loginPage.isInitialized());
    }

    @Test
    public void test_MyAccountPage() {

        homePage = new HomePage(driver);
        assertTrue(homePage.isInitialized());

        loginPage = homePage.onClicklogin();
        assertTrue(loginPage.isInitialized());

        myAccountPage = loginPage.onClickSignIn(Config.getInstance().user(), Config.getInstance().password());
        assertTrue(myAccountPage.isInitialized());

        myAccountPage.onClickSignOut();
    }
}
package com.selenium.testcases;

import com.selenium.docker.Docker;
import com.selenium.driver.Driver;
import com.selenium.grid.Node;
import com.selenium.grid.Hub;

import com.selenium.pom.HomePage;
import com.selenium.pom.LoginPage;
import com.selenium.pom.MyAccountPage;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

public class BaseTest extends Driver {

    protected final Logger logger = Logger.getLogger(BaseTest.class);

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        if (grid.equalsIgnoreCase("remote")) {
            logger.info("Starting selenium hub ...");
            Hub.Instance().startSeleniumHub();

            logger.info("Starting selenium node ...");
            Node.Instance().startSeleniumNode();
        } else if (grid.equalsIgnoreCase("docker")) {
            logger.info("Starting up selenium Docker image ...");
            Docker.Instance().startSeleniumDocker();
        }
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        logger.info("Setting up selenium driver ...");
        setupRemoteDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        logger.info("Closing selenium driver ...");
        closeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        if (grid.equalsIgnoreCase("remote")) {
            logger.info("Closing selenium node ...");
            Node.Instance().stopSeleniumNode();

            logger.info("Closing selenium hub ...");
            Hub.Instance().stopSeleniumHub();
        } else if (grid.equalsIgnoreCase("docker")) {
            logger.info("Closing selenium Docker image ...");
            Docker.Instance().stopSeleniumDocker();
        }
    }
}

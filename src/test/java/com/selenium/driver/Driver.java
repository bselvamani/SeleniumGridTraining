package com.selenium.driver;

import com.selenium.helper.Project;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    public WebDriver driver;

    public String grid = "remote";
    public String browser = "chrome";
    public String headless = "false";

    public Driver() {
        if (System.getProperty("grid") != null)
            grid = System.getProperty("grid");

        if (System.getProperty("browser") != null)
            browser = System.getProperty("browser");

        if (System.getProperty("headless") != null)
            headless = System.getProperty("headless");
    }

    public void setupRemoteDriver() throws Exception {
        // get remote driver
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getDriverCapabilities());

        // setup driver manage options
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String getScreenshot(String name, WebDriver driver) throws IOException {
        String destinationFile = Project.ROOT + "/reports/" + name + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(destinationFile));

        return destinationFile;
    }

    private ChromeOptions setupChromeOption() {
        ChromeOptions options = new ChromeOptions();
        if (headless.equalsIgnoreCase("true"))
            options.setHeadless(true);
        else
            options.setHeadless(false);
        return options;
    }

    private FirefoxOptions setupFirefoxOption() {
        FirefoxOptions options = new FirefoxOptions();
        if (headless.equalsIgnoreCase("true"))
            options.setHeadless(true);
        else
            options.setHeadless(false);
        return options;
    }

    private DesiredCapabilities getDriverCapabilities() {
        DesiredCapabilities dc = null;

        if (browser.equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
            dc.setCapability("CAPABILITY", setupFirefoxOption());
            dc.setPlatform(Platform.ANY);
        } else if (browser.equalsIgnoreCase("chrome")) {
            dc = DesiredCapabilities.chrome();
            dc.setCapability(ChromeOptions.CAPABILITY, setupChromeOption());
            dc.setPlatform(Platform.ANY);
        }

        return dc;
    }
}

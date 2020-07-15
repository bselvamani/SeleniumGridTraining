package com.selenium.grid;

import com.selenium.helper.Project;

import java.util.concurrent.TimeUnit;

public class Hub {
    private static Hub instance = null;
    private Process hub;

    private Hub() {
    }

    // static method to create instance of Singleton class
    public static Hub Instance() {
        if (instance == null)
            instance = new Hub();

        return instance;
    }

    public void startSeleniumHub() throws Exception {
        stopSeleniumHub();

        String grid_path = Project.ROOT + "/src/test/resources/selenium/grid";
        hub = Runtime.getRuntime().exec(grid_path + "/hub/start-selenium-hub " + grid_path);
        hub.waitFor(2, TimeUnit.SECONDS);
    }

    public void stopSeleniumHub() throws Exception {
        hub = Runtime.getRuntime().exec("kill -9 $(lsof -i:4444)");
        hub.waitFor(2, TimeUnit.SECONDS);
    }
}

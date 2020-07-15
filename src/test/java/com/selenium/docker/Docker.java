package com.selenium.docker;

import com.selenium.helper.Project;

import java.util.concurrent.TimeUnit;

public class Docker {
    private static Docker instance = null;
    private Process docker;

    private Docker() {
    }

    // static method to create instance of Singleton class
    public static Docker Instance() {
        if (instance == null)
            instance = new Docker();
        return instance;
    }

    public void startSeleniumDocker() throws Exception {
        stopSeleniumDocker();

        String docker_path = Project.ROOT + "/src/test/resources/selenium/docker";
        docker = Runtime.getRuntime().exec(docker_path + "/start-selenium-docker " + docker_path);
        docker.waitFor(3, TimeUnit.SECONDS);
    }

    public void stopSeleniumDocker() throws Exception {
        String docker_path = Project.ROOT + "/src/test/resources/selenium/docker";
        docker = Runtime.getRuntime().exec(docker_path + "/stop-selenium-docker " + docker_path);
        docker.waitFor(3, TimeUnit.SECONDS);
    }
}

package com.selenium.grid;

import com.selenium.helper.Project;

import java.util.concurrent.TimeUnit;

public class Node {
    private static Node instance = null;
    private Process node;

    private Node() {
    }

    // static method to create instance of Singleton class
    public static Node Instance() {
        if (instance == null)
            instance = new Node();

        return instance;
    }

    public void startSeleniumNode() throws Exception {
        String grid_path = Project.ROOT + "/src/test/resources/selenium/grid";
        node = Runtime.getRuntime().exec(grid_path + "/node/start-selenium-node " + grid_path);
        node.waitFor(2, TimeUnit.SECONDS);
    }

    public void stopSeleniumNode() throws Exception {
        node = Runtime.getRuntime().exec("kill -9 $(lsof -i:5555)");
        node.waitFor(2, TimeUnit.SECONDS);
    }
}

package com.selenium.testcases;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.helper.Project;
import com.aventstack.extentreports.ExtentReports;

public class TestReport{

    private static ExtentReports extent;

    public static ExtentReports generateReport() {
        String html_path = Project.ROOT + "/reports/TestReports.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(html_path);
        reporter.config().setReportName("Selenium Reports");
        reporter.config().setDocumentTitle("UI Automation Reports");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
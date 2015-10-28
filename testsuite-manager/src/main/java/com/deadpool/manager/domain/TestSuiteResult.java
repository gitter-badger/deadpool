package com.deadpool.manager.domain;

/**
 * Created by roothema on 2015.10.05..
 * Project: rest-api-metrics
 */
public class TestSuiteResult {
    private String testSuiteID;
    private boolean success;

    public TestSuiteResult() {
    }

    public String getTestSuiteID() {
        return testSuiteID;
    }

    public void setTestSuiteID(String testSuiteID) {
        this.testSuiteID = testSuiteID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

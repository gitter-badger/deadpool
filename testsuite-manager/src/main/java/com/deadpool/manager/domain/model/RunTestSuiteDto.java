package com.deadpool.manager.domain.model;

/**
 * Created by daniel on 10/29/2015.
 */
public class RunTestSuiteDto {

    private String testSuiteName;
    private String executionStrategyName;

    public RunTestSuiteDto() {
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public String getExecutionStrategyName() {
        return executionStrategyName;
    }

    public void setExecutionStrategyName(String executionStrategyName) {
        this.executionStrategyName = executionStrategyName;
    }
}

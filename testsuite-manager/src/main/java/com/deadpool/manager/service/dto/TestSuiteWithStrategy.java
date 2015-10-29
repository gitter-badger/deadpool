package com.deadpool.manager.service.dto;

import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.domain.model.TestSuite;

/**
 * Created by daniel on 10/29/2015.
 */
public class TestSuiteWithStrategy {

    private TestSuite testSuite;
    private ExecutionStrategy executionStrategy;

    public TestSuiteWithStrategy() {
    }

    public ExecutionStrategy getExecutionStrategy() {
        return executionStrategy;
    }

    public void setExecutionStrategy(ExecutionStrategy executionStrategy) {
        this.executionStrategy = executionStrategy;
    }

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }
}

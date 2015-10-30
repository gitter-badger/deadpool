package com.deadpool.worker.domain.model;

/**
 * Created by daniel on 10/29/2015.
 */
public class TestExecutionDescriptor {

    private TestSuite testSuite;
    private ExecutionStrategy executionStrategy;
    private String executionProcessId;

    public String getExecutionProcessId() {
        return executionProcessId;
    }

    public void setExecutionProcessId(String executionProcessId) {
        this.executionProcessId = executionProcessId;
    }

    public TestExecutionDescriptor() {
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

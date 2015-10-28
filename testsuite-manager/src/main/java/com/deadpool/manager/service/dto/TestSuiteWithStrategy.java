package com.deadpool.manager.service.dto;

import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.domain.TestSuite;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public class TestSuiteWithStrategy {

    private final TestSuite testSuite;
    private final ExecutionStrategy executionStrategy;

    public TestSuiteWithStrategy(TestSuite testSuite, ExecutionStrategy executionStrategy) {
        this.testSuite = testSuite;
        this.executionStrategy = executionStrategy;
    }

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public ExecutionStrategy getExecutionStrategy() {
        return executionStrategy;
    }
}

package com.deadpool.manager.service.dto;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import com.deadpool.manager.domain.entity.TestSuiteEntity;

/**
 * Created by roothema on 2015.10.08..
 */
public class TestSuiteWithStrategy {

    private final TestSuiteEntity testSuiteEntity;
    private final ExecutionStrategyEntity executionStrategyEntity;

    public TestSuiteWithStrategy(TestSuiteEntity testSuiteEntity, ExecutionStrategyEntity executionStrategyEntity) {
        this.testSuiteEntity = testSuiteEntity;
        this.executionStrategyEntity = executionStrategyEntity;
    }

    public TestSuiteEntity getTestSuiteEntity() {
        return testSuiteEntity;
    }

    public ExecutionStrategyEntity getExecutionStrategyEntity() {
        return executionStrategyEntity;
    }
}

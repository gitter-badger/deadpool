package com.deadpool.manager.service;

import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.service.dto.TestSuiteWithStrategy;

/**
 * Created by roothema on 2015.10.08..
 */
public interface ExecutionStrategyService {

    TestSuiteWithStrategy createExecutionStrategy(String testSuiteName, ExecutionStrategy executionStrategy);

}

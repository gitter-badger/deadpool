package com.deadpool.manager.service.execution.strategy;

import com.deadpool.manager.domain.model.ExecutionStrategy;

/**
 * Created by roothema on 2015.10.08..
 */
public interface ExecutionStrategyService {

    ExecutionStrategy createExecutionStrategy(ExecutionStrategy executionStrategy);

    ExecutionStrategy getExecutionStrategy(String executionStrategyName);
}

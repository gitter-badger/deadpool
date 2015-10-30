package com.deadpool.manager.service.execution.strategy;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.repository.ExecutionStrategyRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import com.deadpool.manager.service.exception.ResourceNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 */
@Service
public class ExecutionStrategyServiceImpl implements ExecutionStrategyService {

    @Autowired
    private ExecutionStrategyRepository executionStrategyRepository;

    @Override
    public ExecutionStrategy createExecutionStrategy(ExecutionStrategy executionStrategy) {
        isResourceAlreadyExists(executionStrategy.getName());

        ExecutionStrategyEntity savedExecutionStrategyEntity = executionStrategyRepository.save(executionStrategy.toEntity());
        return savedExecutionStrategyEntity.toDTO();
    }

    @Override
    public ExecutionStrategy getExecutionStrategy(String executionStrategyName) {
        return retrieveExecutionStrategy(executionStrategyName).toDTO();
    }

    @Override
    public void deleteExecutionStrategy(String executionStrategyName) {
        executionStrategyRepository.removeByName(executionStrategyName);
    }

    private ExecutionStrategyEntity retrieveExecutionStrategy(String executionStrategyName) {
        Optional<ExecutionStrategyEntity> strategyEntity = executionStrategyRepository.findByName(executionStrategyName);
        if (!strategyEntity.isPresent()) {
            throw new ResourceNotExists("ExecutionStrategy doesn't exist.");
        }
        return strategyEntity.get();
    }

    private void isResourceAlreadyExists(String testSuiteName) {
        Optional<ExecutionStrategyEntity> strategyEntityOptional = executionStrategyRepository.findByName(testSuiteName);
        if (strategyEntityOptional.isPresent()) {
            throw new ResourceAlreadyExist("ExecutionStrategy with this name is already exist.");
        }
    }
}

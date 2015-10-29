package com.deadpool.manager.service;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.repository.ExecutionStrategyRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
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

    private void isResourceAlreadyExists(String testSuiteName) {
        Optional<ExecutionStrategyEntity> strategyEntityOptional = executionStrategyRepository.findByName(testSuiteName);
        if (strategyEntityOptional.isPresent()) {
            throw new ResourceAlreadyExist("ExecutionStrategy with this name is already exist.");
        }
    }
}

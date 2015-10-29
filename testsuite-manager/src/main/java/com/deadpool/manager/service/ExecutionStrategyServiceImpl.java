package com.deadpool.manager.service;

import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.repository.ExecutionStrategyRepository;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.deadpool.manager.service.dto.TestSuiteWithStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roothema on 2015.10.08..
 */
@Service
public class ExecutionStrategyServiceImpl implements ExecutionStrategyService {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Autowired
    private ExecutionStrategyRepository executionStrategyRepository;

    @Override
    public TestSuiteWithStrategy createExecutionStrategy(String testSuiteName, ExecutionStrategy executionStrategy) {
        TestSuite testSuite = testSuiteRepository.findByName(testSuiteName);

        ExecutionStrategy savedExecutionStrategy = executionStrategyRepository.save(executionStrategy);

        TestSuite updatedTestSuite = updateTestSuite(testSuite, savedExecutionStrategy);

        return new TestSuiteWithStrategy(updatedTestSuite, savedExecutionStrategy);
    }

    private TestSuite updateTestSuite(TestSuite testSuite, ExecutionStrategy savedExecutionStrategy) {
        List<ExecutionStrategy> executionStrategyList = new ArrayList<>();
        executionStrategyList.add(savedExecutionStrategy);

        return testSuiteRepository.save(testSuite);
    }

}

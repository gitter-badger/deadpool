package com.deadpool.manager.service.execution.process;

import com.deadpool.manager.domain.Status;
import com.deadpool.manager.domain.entity.ExecutionProcessEntity;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.domain.model.ProcessDescriptor;
import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.repository.ExecutionProcessRepository;
import com.deadpool.manager.service.dto.TestSuiteWithStrategy;
import com.deadpool.manager.service.execution.strategy.ExecutionStrategyService;
import com.deadpool.manager.service.testsuite.TestSuiteService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by daniel on 10/29/2015.
 */
@Service
public class RunTestSuiteServiceImpl implements RunTestSuiteService {
    @Autowired
    private TestSuiteService testSuiteService;

    @Autowired
    private ExecutionStrategyService executionStrategyService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private ExecutionProcessRepository executionProcessRepository;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Override
    public String runTestSuite(ProcessDescriptor processDescriptor) {
        TestSuite testSuite = testSuiteService.getTestSuite(processDescriptor.getTestSuiteName());
        ExecutionStrategy executionStrategy = executionStrategyService.getExecutionStrategy(processDescriptor.getExecutionStrategyName());

        ExecutionProcessEntity savedExecutionProcess = executionProcessRepository.save(new ExecutionProcessEntity(Status.RUNNING, testSuite.getName(), executionStrategy.getName()));

        TestSuiteWithStrategy testSuiteWithStrategy = new TestSuiteWithStrategy();
        testSuiteWithStrategy.setTestSuite(testSuite);
        testSuiteWithStrategy.setExecutionStrategy(executionStrategy);
        testSuiteWithStrategy.setExecutionProcessId(savedExecutionProcess.getId());

        rabbitTemplate.convertAndSend(queueName, testSuiteWithStrategy);

        return savedExecutionProcess.getId();
    }
}

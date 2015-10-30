package com.deadpool.manager.controller.execution.process;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.entity.ExecutionProcessEntity;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.domain.model.RunTestSuiteDto;
import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.repository.ExecutionProcessRepository;
import com.deadpool.manager.service.dto.TestSuiteWithStrategy;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by daniel on 10/29/2015.
 */
public class RunTestSuiteControllerTest extends BaseControllerTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private ExecutionProcessRepository executionProcessRepository;

    @Test
    public void testRunTestSuite() throws Exception {

        //given
        TestSuite testSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(testSuite);

        ExecutionStrategy executionStrategy = createExecutionStrategy();

        //when
        RunTestSuiteDto runTestSuiteDto = new RunTestSuiteDto();
        runTestSuiteDto.setTestSuiteName(testSuite.getName());
        runTestSuiteDto.setExecutionStrategyName(executionStrategy.getName());

        Response response = HttpRequestHelper.callRunTestSuiteEndpoint(runTestSuiteDto);

        //then
        Assert.assertEquals(HttpStatus.ACCEPTED.value(), response.getStatusCode());

        verify(rabbitTemplate, times(1)).convertAndSend(anyString(), any(TestSuiteWithStrategy.class));

        ExecutionProcessEntity executionProcessEntity = executionProcessRepository.findOne(response.getBody().asString());
        Assert.assertEquals(testSuite.getName(), executionProcessEntity.getTestSuiteName());
        Assert.assertEquals(executionStrategy.getName(), executionProcessEntity.getExecutionStrategyName());
    }

    @Test
    public void shouldNotFoundTestSuite() throws Exception {

        //given
        ExecutionStrategy executionStrategy = createExecutionStrategy();

        //when
        RunTestSuiteDto runTestSuiteDto = new RunTestSuiteDto();
        runTestSuiteDto.setTestSuiteName("testSuiteName");
        runTestSuiteDto.setExecutionStrategyName(executionStrategy.getName());

        Response response = HttpRequestHelper.callRunTestSuiteEndpoint(runTestSuiteDto);

        //then
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
        assertEquals("TestSuite doesn't exist.", response.getBody().asString());
    }

    @Test
    public void shouldNotFoundExecutionStrategy() throws Exception {

        //given
        TestSuite testSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(testSuite);

        //when
        RunTestSuiteDto runTestSuiteDto = new RunTestSuiteDto();
        runTestSuiteDto.setTestSuiteName(testSuite.getName());
        runTestSuiteDto.setExecutionStrategyName("executionStrategy");

        Response response = HttpRequestHelper.callRunTestSuiteEndpoint(runTestSuiteDto);

        //then
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
        assertEquals("ExecutionStrategy doesn't exist.", response.getBody().asString());
    }

    private ExecutionStrategy createExecutionStrategy() {
        ExecutionStrategy executionStrategy = new ExecutionStrategy();
        executionStrategy.setName("strategyName");
        executionStrategy.setExecution(ExecutionMode.SEQUENTIAL);
        executionStrategy.setDuration(100L);
        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategy);
        return executionStrategy;
    }
}

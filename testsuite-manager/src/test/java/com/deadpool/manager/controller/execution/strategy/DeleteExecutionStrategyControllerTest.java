package com.deadpool.manager.controller.execution.strategy;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class DeleteExecutionStrategyControllerTest extends BaseControllerTest {

    @Test
    public void testDeleteExecutionStrategy() {

        // given
        ExecutionStrategy executionStrategyA = new ExecutionStrategy("test-executionA", ExecutionMode.RANDOM, 30L);
        ExecutionStrategy executionStrategyB = new ExecutionStrategy("test-executionB", ExecutionMode.RANDOM, 30L);

        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategyA);
        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategyB);

        // when
        Response response = HttpRequestHelper.callDeleteExecutionStrategyEndpoint(executionStrategyA.getName());

        // then
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode());

        assertEquals(1, executionStrategyRepository.count());
        assertFalse(executionStrategyRepository.findByName(executionStrategyA.getName()).isPresent());
        assertTrue(executionStrategyRepository.findByName(executionStrategyB.getName()).isPresent());
    }

    @Test
    public void testDeleteNonExistingExecutionStrategy() {

        //given
        ExecutionStrategy executionStrategyA = new ExecutionStrategy("test-executionA", ExecutionMode.RANDOM, 30L);
        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategyA);

        // when
        Response response = HttpRequestHelper.callDeleteExecutionStrategyEndpoint("non-existing-execution");

        // then
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode());

        assertEquals(1, executionStrategyRepository.count());
        assertTrue(executionStrategyRepository.findByName(executionStrategyA.getName()).isPresent());
    }
}
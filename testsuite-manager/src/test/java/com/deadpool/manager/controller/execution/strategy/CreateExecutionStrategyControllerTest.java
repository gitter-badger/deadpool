package com.deadpool.manager.controller.execution.strategy;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class CreateExecutionStrategyControllerTest extends BaseControllerTest {

    @Test
    public void shouldCreateExecutionStrategy() throws Exception {

        //given
        ExecutionStrategy executionStrategy = new ExecutionStrategy("execution-stg-1", ExecutionMode.SEQUENTIAL, 10L);

        // when
        Response response = HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategy);

        // then
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertTrue(response.getHeader(HttpHeaders.LOCATION).matches("/execution-strategy/" + executionStrategy.getName()));

        Assert.assertEquals(1, executionStrategyRepository.count());
        ExecutionStrategyEntity savedExecutionStrategyEntity = executionStrategyRepository.findByName(executionStrategy.getName()).get();
        assertEquals(executionStrategy.getName(), savedExecutionStrategyEntity.getName());
        assertNotNull(savedExecutionStrategyEntity.getId());
        assertEquals(executionStrategy.getDuration(), savedExecutionStrategyEntity.getDuration());
        assertEquals(executionStrategy.getExecution().name(), savedExecutionStrategyEntity.getExecutionMode().name());
    }

    @Test
    public void testUniqueNamesForExecutionStrategies() throws Exception {

        // given
        ExecutionStrategy executionStrategy = new ExecutionStrategy("execution-stg-1", ExecutionMode.SEQUENTIAL, 10L);
        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategy);

        // when
        Response response = HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategy);

        // then
        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode());
        assertEquals("ExecutionStrategy with this name is already exist.", response.getBody().asString());
    }
}
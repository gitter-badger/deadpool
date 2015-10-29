package com.deadpool.manager.controller;

import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by roothema on 2015.10.29..
 */
public class GetExecutionStrategyControllerTest extends BaseControllerTest {

    @Test
    public void testGetExecutionStrategy() throws IOException {
        // given
        ExecutionStrategy executionStrategy = new ExecutionStrategy("execution-stg-1", ExecutionMode.SEQUENTIAL, 10L);
        HttpRequestHelper.callNewExecutionStrategyEndpoint(executionStrategy);

        // when
        Response response = HttpRequestHelper.callGetExecutionStrategyEndpoint(executionStrategy.getName());

        // then
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        ExecutionStrategy responseExecutionStrategy = new ObjectMapper().readValue(response.getBody().asString(), ExecutionStrategy.class);
        assertEquals(executionStrategy.getName(), responseExecutionStrategy.getName());
        assertEquals(executionStrategy.getExecution().name(), responseExecutionStrategy.getExecution().name());
        assertEquals(executionStrategy.getDuration(), responseExecutionStrategy.getDuration());
    }

    @Test
    public void shouldNotFoundExecutionStrategy() {
        // when
        Response response = HttpRequestHelper.callGetExecutionStrategyEndpoint("non-existing-execution-strategy-name");

        // then
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}

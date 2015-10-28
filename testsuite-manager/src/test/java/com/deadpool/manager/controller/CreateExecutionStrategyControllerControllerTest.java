package com.deadpool.manager.controller;

import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.domain.TestSuite;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateExecutionStrategyControllerControllerTest extends BaseControllerTest {

    @Test
    public void shouldCreateExecutionStrategy() throws Exception {

        //given
        TestSuite defaultTestSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(defaultTestSuite);

        ExecutionStrategy executionStrategy = new ExecutionStrategy("RANDOM");

        // when
        Response response = HttpRequestHelper.callNewExecutionStrategyEndpoint(defaultTestSuite, executionStrategy);

        // then
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertTrue(response.getHeader(HttpHeaders.LOCATION).matches("/test-suite/" + defaultTestSuite.getName() + "/execution-strategy/\\d"));
        Assert.assertEquals(1, executionStrategyRepository.count());

        ExecutionStrategy savedExecutionStrategy = executionStrategyRepository.findByName(executionStrategy.getName());
        assertEquals(executionStrategy.getName(), savedExecutionStrategy.getName());
        assertEquals(new Long(1), savedExecutionStrategy.getId());
    }

    @Test
    public void testUniqueNamesForExecutionStrategies() throws Exception {

        // given
        TestSuite defaultTestSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(defaultTestSuite);

        ExecutionStrategy executionStrategy = new ExecutionStrategy("RANDOM");
        HttpRequestHelper.callNewExecutionStrategyEndpoint(defaultTestSuite, executionStrategy);

        // when
        Response response = HttpRequestHelper.callNewExecutionStrategyEndpoint(defaultTestSuite, executionStrategy);

        // then
        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode());
        assertEquals("ExecutionStrategy with this name is already exist.", response.getBody().asString());
    }
}
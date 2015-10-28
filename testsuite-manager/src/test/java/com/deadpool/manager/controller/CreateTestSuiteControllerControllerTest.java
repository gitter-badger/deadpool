package com.deadpool.manager.controller;

import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.TestSuite;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateTestSuiteControllerControllerTest extends BaseControllerTest {

    @Test
    public void shouldCreateNewTestSuite() throws Exception {

        //given
        TestSuite newTestSuite = DtoHelper.createDefaultTestSuite();

        // when
        Response response = HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuite);

        // then
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertTrue(response.getHeader(HttpHeaders.LOCATION).matches("/test-suite/\\d"));
        Assert.assertEquals(1, testSuiteRepository.count());
        Assert.assertEquals(2, httpActionRepository.count());
    }

    @Test
    public void testUniqueNamesForTestSuites() throws Exception {
        //given
        TestSuite newTestSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuite);

        // when
        Response response = HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuite);

        // then
        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode());
        assertEquals("TestSuite with this name is already exist.", response.getBody().asString());
    }
}
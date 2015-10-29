package com.deadpool.manager.controller;

import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.model.HttpAction;
import com.deadpool.manager.domain.model.TestSuite;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetTestSuiteControllerTest extends BaseControllerTest {

    @Test
    public void testGetTestSuite() throws Exception {

        //given
        TestSuite defaultTestSuite = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(defaultTestSuite);

        //when
        Response response = HttpRequestHelper.callGetTestSuiteEndpoint(defaultTestSuite.getName());

        //then
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        TestSuite responseTestSuite = new ObjectMapper().readValue(response.getBody().asString(), TestSuite.class);
        assertEquals(defaultTestSuite.getName(), responseTestSuite.getName());
        assertEquals(2, responseTestSuite.getHttpActions().size());

        for (HttpAction httpAction : defaultTestSuite.getHttpActions()) {
            assertTrue(responseTestSuite.getHttpActions()
                    .stream()
                    .anyMatch(c -> httpAction.getMethod().equals(c.getMethod())
                            && httpAction.getName().equals(c.getName())
                            && httpAction.getPayload().equals(c.getPayload())
                            && httpAction.getHeaders().equals(c.getHeaders())
                            && httpAction.getUrl().equals(c.getUrl())));
        }
    }

    @Test
    public void shouldNotFoundTestSuite() {
        //when
        Response response = HttpRequestHelper.callGetTestSuiteEndpoint("non-existing-test-suite");

        //then
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}
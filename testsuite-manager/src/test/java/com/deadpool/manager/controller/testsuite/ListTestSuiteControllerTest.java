package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.model.TestSuite;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by roothema on 2015.10.30..
 */
public class ListTestSuiteControllerTest extends BaseControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testListingTestSuites() throws IOException {

        // given
        HttpRequestHelper.callNewTestSuiteEndpoint(DtoHelper.createTestSuiteWithName("testsuite-a"));
        HttpRequestHelper.callNewTestSuiteEndpoint(DtoHelper.createTestSuiteWithName("testsuite-b"));

        // when
        Response response = HttpRequestHelper.callListTestSuiteEndpoint();

        // then

        List<TestSuite> testSuites = castResponseJsonToTestSuiteList(response);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(2, testSuites.size());
    }

    @Test
    public void testEmptyTestSuiteResults() throws IOException {
        // when
        Response response = HttpRequestHelper.callListTestSuiteEndpoint();

        // then
        List<TestSuite> testSuites = castResponseJsonToTestSuiteList(response);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(0, testSuites.size());
    }

    private List<TestSuite> castResponseJsonToTestSuiteList(Response response) throws IOException {
        return mapper.readValue(response.getBody().asByteArray(), new TypeReference<List<TestSuite>>() {
        });
    }
}

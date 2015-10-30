package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.entity.TestSuiteEntity;
import com.deadpool.manager.domain.model.TestSuite;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class DeleteTestSuiteControllerTest extends BaseControllerTest {

    @Test
    public void shouldDeleteTestSuite() {

        // given
        TestSuite testSuite_A = DtoHelper.createTestSuiteWithName("testsuite-a");
        TestSuite testSuite_B = DtoHelper.createTestSuiteWithName("testsuite-b");
        TestSuite testSuite_C = DtoHelper.createTestSuiteWithName("testsuite-c");

        HttpRequestHelper.callNewTestSuiteEndpoint(testSuite_A);
        HttpRequestHelper.callNewTestSuiteEndpoint(testSuite_B);
        HttpRequestHelper.callNewTestSuiteEndpoint(testSuite_C);

        // when
        Response response = HttpRequestHelper.callDeleteTestSuiteEndpoint(testSuite_B.getName());

        // then
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode());
        assertEquals("", response.getBody().asString());

        assertEquals(2, testSuiteRepository.count());
        assertFalse(testSuiteRepository.findByName(testSuite_B.getName()).isPresent());
        assertTrue(testSuiteRepository.findByName(testSuite_A.getName()).isPresent());
        assertTrue(testSuiteRepository.findByName(testSuite_C.getName()).isPresent());

        assertEquals(4, httpActionRepository.count());

        TestSuiteEntity suiteEntityA = testSuiteRepository.findByName(testSuite_A.getName()).get();
        assertNotNull(httpActionRepository.findOne(suiteEntityA.getHttpActionEntities().get(0).getId()));
        assertNotNull(httpActionRepository.findOne(suiteEntityA.getHttpActionEntities().get(1).getId()));

        TestSuiteEntity suiteEntityC = testSuiteRepository.findByName(testSuite_C.getName()).get();
        assertNotNull(httpActionRepository.findOne(suiteEntityC.getHttpActionEntities().get(0).getId()));
        assertNotNull(httpActionRepository.findOne(suiteEntityC.getHttpActionEntities().get(1).getId()));
    }

    @Test
    public void shouldNotDeleteUnavailableTestSuite() {
        // when
        Response response = HttpRequestHelper.callDeleteTestSuiteEndpoint("non-existing-test-suite");

        // then
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}
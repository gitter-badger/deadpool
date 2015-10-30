package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.controller.BaseControllerTest;
import com.deadpool.manager.controller.helper.DtoHelper;
import com.deadpool.manager.controller.helper.HttpRequestHelper;
import com.deadpool.manager.domain.entity.TestSuiteEntity;
import com.deadpool.manager.domain.model.HttpAction;
import com.deadpool.manager.domain.model.TestSuite;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class CreateTestSuiteControllerTest extends BaseControllerTest {

    @Test
    public void shouldCreateNewTestSuite() throws Exception {

        //given
        TestSuite newTestSuite = DtoHelper.createDefaultTestSuite();

        // when
        Response response = HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuite);

        // then
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertTrue(response.getHeader(HttpHeaders.LOCATION).matches("/test-suite/" + newTestSuite.getName()));

        TestSuiteEntity suiteEntity = testSuiteRepository.findByName(newTestSuite.getName()).get();
        assertEquals(newTestSuite.getName(), suiteEntity.getName());
        assertNotNull(suiteEntity.getId());

        for (HttpAction httpAction : newTestSuite.getHttpActions()) {
            assertTrue(suiteEntity.getHttpActionEntities()
                    .stream()
                    .anyMatch(c -> httpAction.getMethod().equals(c.getMethod())
                            && httpAction.getName().equals(c.getName())
                            && httpAction.getPayload().equals(c.getPayload())
                            && httpAction.getHeaders().equals(c.getHeaders())
                            && httpAction.getUrl().equals(c.getUrl())));
        }
    }

    @Test
    public void testUniqueNamesForTestSuites() throws Exception {
        //given
        TestSuite newTestSuiteEntity = DtoHelper.createDefaultTestSuite();
        HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuiteEntity);

        // when
        Response response = HttpRequestHelper.callNewTestSuiteEndpoint(newTestSuiteEntity);

        // then
        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode());
        assertEquals("TestSuite with this name is already exist.", response.getBody().asString());
    }
}
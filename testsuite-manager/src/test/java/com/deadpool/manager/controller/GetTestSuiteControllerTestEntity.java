package com.deadpool.manager.controller;

import com.deadpool.manager.Application;
import com.deadpool.manager.domain.entity.HttpActionEntity;
import com.deadpool.manager.domain.entity.TestSuiteEntity;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class GetTestSuiteControllerTestEntity {

    private static final String SAMPLE_SUITE_NAME = "sample-SuiteName";

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testGetTestSuite() throws Exception {

        //given
//        HttpHeaderEntity httpHeaderEntity = new HttpHeaderEntity("key", "value");

        HttpActionEntity postAction = new HttpActionEntity();
        postAction.setName("create something on XY rest endpoint");
        postAction.setMethod("POST");
        postAction.setPayload("{'foo':'bar'}");
        postAction.setUrl("http://localhost:8081/sample-endpoint-post");

        HttpActionEntity getAction = new HttpActionEntity();
        getAction.setName("get object by XY rest endpoint");
        getAction.setMethod("GET");
        getAction.setUrl("http://localhost:8081/sample-endpoint-get");
        getAction.setHeaders("key:value");

        TestSuiteEntity savedTestSuiteEntity = new TestSuiteEntity(SAMPLE_SUITE_NAME, Stream.of(postAction, getAction).collect(Collectors.toList()));

        testSuiteRepository.save(savedTestSuiteEntity);

        //when
        Response response = get("/test-suite/" + SAMPLE_SUITE_NAME);

        //then
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        TestSuiteEntity responseTestSuiteEntity = new ObjectMapper().readValue(response.getBody().asString(), TestSuiteEntity.class);
        assertEquals(savedTestSuiteEntity.getName(), responseTestSuiteEntity.getName());
        assertEquals(savedTestSuiteEntity.getId(), responseTestSuiteEntity.getId());
        assertEquals(2, responseTestSuiteEntity.getHttpActionEntities().size());
        assertTrue(responseTestSuiteEntity.getHttpActionEntities()
                .stream()
                .anyMatch(c -> postAction.getMethod().equals(c.getMethod())
                        && postAction.getName().equals(c.getName())
                        && postAction.getPayload().equals(c.getPayload())
                        && postAction.getUrl().equals(c.getUrl())));
        assertTrue(responseTestSuiteEntity.getHttpActionEntities()
                .stream()
                .anyMatch(c -> getAction.getMethod().equals(c.getMethod())
                        && getAction.getName().equals(c.getName())
                        && getAction.getUrl().equals(c.getUrl())
                        && c.getHeaders().equals(getAction.getHeaders())));
    }
}
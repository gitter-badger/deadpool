package com.deadpool.manager.controller;

import com.deadpool.manager.Application;
import com.deadpool.manager.repository.ExecutionStrategyRepository;
import com.deadpool.manager.repository.HttpActionRepository;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class BaseControllerTest {

    @Autowired
    protected TestSuiteRepository testSuiteRepository;

    @Autowired
    protected HttpActionRepository httpActionRepository;

    @Autowired
    protected ExecutionStrategyRepository executionStrategyRepository;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
        testSuiteRepository.deleteAll();
        httpActionRepository.deleteAll();
        executionStrategyRepository.deleteAll();
    }

    @Test
    public void hackTest() throws Exception {
        assertTrue(true);
    }
}

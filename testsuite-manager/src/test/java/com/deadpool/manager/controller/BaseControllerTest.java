package com.deadpool.manager.controller;

import com.deadpool.manager.Application;
import com.deadpool.manager.repository.ExecutionProcessRepository;
import com.deadpool.manager.repository.ExecutionStrategyRepository;
import com.deadpool.manager.repository.HttpActionRepository;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roothema on 2015.10.08..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public abstract class BaseControllerTest {

    @Autowired
    protected TestSuiteRepository testSuiteRepository;

    @Autowired
    protected HttpActionRepository httpActionRepository;

    @Autowired
    protected ExecutionStrategyRepository executionStrategyRepository;

    @Autowired
    protected ExecutionProcessRepository executionProcessRepository;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
        testSuiteRepository.deleteAll();
        httpActionRepository.deleteAll();
        executionStrategyRepository.deleteAll();
        executionProcessRepository.deleteAll();
    }

}

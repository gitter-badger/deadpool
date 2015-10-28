package com.deadpool.manager.controller;

import com.deadpool.manager.domain.TestSuiteResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@RestController
public class GetTestResultController {

    @RequestMapping(value = "/test-suite/{test-suite-name}/results", method = RequestMethod.GET, produces = "application/json")
    public TestSuiteResult getTestSuiteResult(@PathParam("test-suite-id") String testSuiteName) {

        TestSuiteResult testSuiteResult = new TestSuiteResult();
        testSuiteResult.setTestSuiteID(testSuiteName);
        testSuiteResult.setSuccess(true);

        return testSuiteResult;
    }

}
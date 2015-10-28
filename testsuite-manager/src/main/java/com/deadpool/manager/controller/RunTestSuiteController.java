package com.deadpool.manager.controller;

import com.deadpool.manager.service.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@RestController
public class RunTestSuiteController {

    @Autowired
    private TestSuiteService testSuiteService;

    @RequestMapping(value = "/test-suite/{test-suite-name}/run", method = RequestMethod.POST)
    public ResponseEntity runTestSuite(@PathVariable("test-suite-name") String testSuiteName) {
        testSuiteService.runTestSuite(testSuiteName);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}

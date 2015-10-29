package com.deadpool.manager.controller;

import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.service.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roothema on 2015.10.05..
 */
@RestController
public class GetTestSuiteController {

    @Autowired
    private TestSuiteService testSuiteService;

    @RequestMapping(value = "/test-suite/{name}", method = RequestMethod.GET, produces = "application/json")
    public TestSuite getTestSuite(@PathVariable("name") String testSuiteName) {
        return testSuiteService.getTestSuite(testSuiteName);
    }

}

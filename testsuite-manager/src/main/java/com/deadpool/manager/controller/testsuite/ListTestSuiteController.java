package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.service.testsuite.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by roothema on 2015.10.30..
 */
@RestController
public class ListTestSuiteController {

    @Autowired
    private TestSuiteService testSuiteService;

    @RequestMapping(value = "/test-suite", method = RequestMethod.GET, produces = "application/json")
    public List<TestSuite> listTestSuite() {
        return testSuiteService.listTestSuites();
    }
}

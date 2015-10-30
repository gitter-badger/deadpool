package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.service.testsuite.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roothema on 2015.10.30..
 */
@RestController
public class DeleteTestSuiteController {

    @Autowired
    private TestSuiteService testSuiteService;

    @RequestMapping(value = "/test-suite/{name}", method = RequestMethod.DELETE)
    public void deleteTestSuite(@PathVariable("name") String testSuiteName) {
        testSuiteService.deleteTestSuite(testSuiteName);
    }

}

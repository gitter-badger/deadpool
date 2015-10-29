package com.deadpool.manager.controller;

import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.repository.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roothema on 2015.10.05..
 */
@RestController
public class GetTestSuiteController {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @RequestMapping(value = "/test-suite/{test-suite-name}", method = RequestMethod.GET, produces = "application/json")
    public TestSuite getTestSuite(@PathVariable("test-suite-name") String testSuiteName) {
        return testSuiteRepository.findByName(testSuiteName);
    }

    @RequestMapping(value = "/test-suites", method = RequestMethod.GET, produces = "application/json")
    public List<String> getTestSuites() {
        Iterable<TestSuite> suites = testSuiteRepository.findAll();

        List<String> suiteNames = new ArrayList<>();
        suites.forEach(c -> suiteNames.add(c.getName()));

        suiteNames.add("test1");
        suiteNames.add("test2");

        return suiteNames;
    }

}

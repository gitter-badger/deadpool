package com.deadpool.manager.service.testsuite;

import com.deadpool.manager.domain.model.TestSuite;

import java.util.List;

/**
 * Created by roothema on 2015.10.08..
 */
public interface TestSuiteService {
    TestSuite createTestSuite(TestSuite testSuite);

    TestSuite getTestSuite(String testSuiteName);

    List<TestSuite> listTestSuites();
}

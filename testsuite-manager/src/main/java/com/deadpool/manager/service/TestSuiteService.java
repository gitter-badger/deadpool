package com.deadpool.manager.service;

import com.deadpool.manager.domain.TestSuite;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public interface TestSuiteService {
    TestSuite createTestSuite(TestSuite testSuite);

    void runTestSuite(String testSuiteName);
}

package com.deadpool.manager.service;

import com.deadpool.manager.domain.model.TestSuite;

/**
 * Created by roothema on 2015.10.08..
 */
public interface TestSuiteService {
    TestSuite createTestSuite(TestSuite testSuite);

    TestSuite getTestSuite(String testSuiteName);
}

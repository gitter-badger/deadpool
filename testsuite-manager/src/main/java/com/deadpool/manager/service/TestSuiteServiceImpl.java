package com.deadpool.manager.service;

import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@Service
public class TestSuiteServiceImpl implements TestSuiteService {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Override
    public TestSuite createTestSuite(TestSuite testSuite) {
        Optional<TestSuite> testSuiteOptional = Optional.ofNullable(testSuiteRepository.findByName(testSuite.getName()));
        isResourceAlreadyExists(testSuiteOptional);
        return testSuiteRepository.save(testSuite);
    }

    private void isResourceAlreadyExists(Optional<TestSuite> testSuiteOptional) {
        if (testSuiteOptional.isPresent()) {
            throw new ResourceAlreadyExist("TestSuite with this name is already exist.");
        }
    }

    @Override
    public void runTestSuite(String testSuiteName) {
        TestSuite testSuite = testSuiteRepository.findByName(testSuiteName);
    }
}

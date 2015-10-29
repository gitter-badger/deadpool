package com.deadpool.manager.service;

import com.deadpool.manager.domain.entity.TestSuiteEntity;
import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 */
@Service
public class TestSuiteServiceImpl implements TestSuiteService {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Override
    public TestSuite createTestSuite(TestSuite testSuite) {
        isResourceAlreadyExists(testSuite.getName());
        TestSuiteEntity suiteEntity = testSuiteRepository.save(testSuite.toEntity());
        return suiteEntity.toDTO();
    }

    private void isResourceAlreadyExists(String testSuiteName) {
        Optional<TestSuiteEntity> testSuiteOptional = testSuiteRepository.findByName(testSuiteName);
        if (testSuiteOptional.isPresent()) {
            throw new ResourceAlreadyExist("TestSuite with this name is already exist.");
        }
    }

    @Override
    public void runTestSuite(String testSuiteName) {
        Optional<TestSuiteEntity> testSuiteEntity = testSuiteRepository.findByName(testSuiteName);
    }
}

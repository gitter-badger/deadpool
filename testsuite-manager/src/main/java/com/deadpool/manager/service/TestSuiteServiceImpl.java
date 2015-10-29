package com.deadpool.manager.service;

import com.deadpool.manager.domain.entity.TestSuiteEntity;
import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import com.deadpool.manager.service.exception.ResourceNotExists;
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
        validateTestSuiteIsMissing(testSuite.getName());
        TestSuiteEntity suiteEntity = testSuiteRepository.save(testSuite.toEntity());
        return suiteEntity.toDTO();
    }

    @Override
    public TestSuite getTestSuite(String testSuiteName) {
        return retrieveTestSuite(testSuiteName).toDTO();
    }

    private TestSuiteEntity retrieveTestSuite(String testSuiteName) {
        Optional<TestSuiteEntity> suiteEntity = testSuiteRepository.findByName(testSuiteName);
        if (!suiteEntity.isPresent()) {
            throw new ResourceNotExists("TestSuite doesn't exist.");
        }
        return suiteEntity.get();
    }

    private void validateTestSuiteIsMissing(String testSuiteName) {
        Optional<TestSuiteEntity> testSuiteOptional = testSuiteRepository.findByName(testSuiteName);
        if (testSuiteOptional.isPresent()) {
            throw new ResourceAlreadyExist("TestSuite with this name is already exist.");
        }
    }
}

package com.deadpool.manager.service;

import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.repository.TestSuiteRepository;
import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@Service
public class TestSuiteServiceImpl implements TestSuiteService {

    public static final String REDIS_CHANNEL_BENCHMARK_TEST = "benchmark-test";

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public TestSuite createTestSuite(TestSuite testSuite) {
        Optional<TestSuite> testSuiteOptional = Optional.ofNullable(testSuiteRepository.findByName(testSuite.getName()));
        isResourceAlreadyExists(testSuiteOptional);
        setTestSuiteReferenceForCorrespondingHttpActions(testSuite);
        return testSuiteRepository.save(testSuite);
    }

    private void setTestSuiteReferenceForCorrespondingHttpActions(TestSuite testSuite) {
        testSuite.getHttpActions().stream().forEach(a -> a.setTestSuite(testSuite));
    }

    private void isResourceAlreadyExists(Optional<TestSuite> testSuiteOptional) {
        if (testSuiteOptional.isPresent()) {
            throw new ResourceAlreadyExist("TestSuite with this name is already exist.");
        }
    }

    @Override
    public void runTestSuite(String testSuiteName) {
        TestSuite testSuite = testSuiteRepository.findByName(testSuiteName);
        redisTemplate.convertAndSend(REDIS_CHANNEL_BENCHMARK_TEST, testSuite);
    }
}

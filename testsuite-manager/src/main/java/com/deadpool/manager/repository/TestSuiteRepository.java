package com.deadpool.manager.repository;

import com.deadpool.manager.domain.TestSuite;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by roothema on 2015.10.06..
 * Project: rest-api-metrics
 */
public interface TestSuiteRepository extends CrudRepository<TestSuite, Long> {
    TestSuite findByName(String testSuiteName);
}

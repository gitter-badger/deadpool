package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.TestSuiteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by roothema on 2015.10.06..
 */
public interface TestSuiteRepository extends CrudRepository<TestSuiteEntity, Long> {
    Optional<TestSuiteEntity> findByName(String testSuiteName);

    List<TestSuiteEntity> findAll();
}

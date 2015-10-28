package com.deadpool.manager.repository;

import com.deadpool.manager.domain.ExecutionStrategy;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public interface ExecutionStrategyRepository extends CrudRepository<ExecutionStrategy, Long> {

    ExecutionStrategy findByName(String name);

}

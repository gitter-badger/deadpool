package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by roothema on 2015.10.29..
 */
public interface ExecutionProcessRepository extends CrudRepository<ExecutionStrategyEntity, Long> {
}

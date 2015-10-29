package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 */
public interface ExecutionStrategyRepository extends CrudRepository<ExecutionStrategyEntity, Long> {

    Optional<ExecutionStrategyEntity> findByName(String name);

}

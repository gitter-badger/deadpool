package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 */
public interface ExecutionStrategyRepository extends CrudRepository<ExecutionStrategyEntity, Long> {

    Optional<ExecutionStrategyEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM ExecutionStrategyEntity e WHERE e.name = ?1")
    void removeByName(String name);
}

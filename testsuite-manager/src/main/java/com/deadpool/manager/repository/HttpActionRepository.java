package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.HttpActionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by roothema on 2015.10.08..
 */
public interface HttpActionRepository extends CrudRepository<HttpActionEntity, Long> {
    Optional<HttpActionEntity> findByName(String name);
}

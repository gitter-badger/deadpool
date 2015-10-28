package com.deadpool.manager.repository;

import com.deadpool.manager.domain.HttpAction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public interface HttpActionRepository extends CrudRepository<HttpAction, Long> {
}

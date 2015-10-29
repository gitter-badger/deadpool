package com.deadpool.manager.repository;

import com.deadpool.manager.domain.entity.HttpHeaderEntity;
import org.springframework.data.repository.CrudRepository;

public interface HttpHeaderRepository extends CrudRepository<HttpHeaderEntity, Long> {
}

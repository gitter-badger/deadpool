package com.deadpool.manager.repository;

import com.deadpool.manager.domain.HttpHeader;
import org.springframework.data.repository.CrudRepository;

public interface HttpHeaderRepository extends CrudRepository<HttpHeader, Long> {
}

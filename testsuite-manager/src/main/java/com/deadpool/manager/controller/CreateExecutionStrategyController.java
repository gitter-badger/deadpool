package com.deadpool.manager.controller;

import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.service.ExecutionStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roothema on 2015.10.08..
 */
@RestController
public class CreateExecutionStrategyController {

    @Autowired
    private ExecutionStrategyService executionStrategyService;

    @RequestMapping(value = "/execution-strategy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createExecutionStrategy(@RequestBody() ExecutionStrategy executionStrategy) {

        ExecutionStrategy savedExecutionStrategy = executionStrategyService.createExecutionStrategy(executionStrategy);

        MultiValueMap httpHeaders = createHttpHeaders(savedExecutionStrategy.getName());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    private MultiValueMap createHttpHeaders(String executionStrategyName) {
        String entityURI = "/execution-strategy/" + executionStrategyName;

        MultiValueMap headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, entityURI);
        return headers;
    }

}

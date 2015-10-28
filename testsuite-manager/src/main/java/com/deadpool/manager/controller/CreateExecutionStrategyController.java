package com.deadpool.manager.controller;

import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.service.ExecutionStrategyService;
import com.deadpool.manager.service.dto.TestSuiteWithStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
@RestController
public class CreateExecutionStrategyController {

    @Autowired
    private ExecutionStrategyService executionStrategyService;

    @RequestMapping(value = "/test-suite/{test-suite-name}/execution-strategy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createExecutionStrategy(@PathVariable("test-suite-name") String testSuiteName, @RequestBody ExecutionStrategy executionStrategy) {

        TestSuiteWithStrategy suiteWithStrategy = executionStrategyService.createExecutionStrategy(testSuiteName, executionStrategy);

        MultiValueMap httpHeaders = createHttpHeaders(suiteWithStrategy.getTestSuite(), suiteWithStrategy.getExecutionStrategy());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    private MultiValueMap createHttpHeaders(TestSuite testSuite, ExecutionStrategy executionStrategy) {
        String entityURI = "/test-suite/" + testSuite.getName() + "/execution-strategy/" + executionStrategy.getId();

        MultiValueMap headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, entityURI);
        return headers;
    }

}

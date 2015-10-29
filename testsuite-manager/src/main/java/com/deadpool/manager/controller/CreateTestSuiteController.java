package com.deadpool.manager.controller;

import com.deadpool.manager.domain.TestSuite;
import com.deadpool.manager.service.TestSuiteService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class CreateTestSuiteController {

    @Autowired
    private TestSuiteService testSuiteService;

    @RequestMapping(value = "/test-suite", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createTestSuite(@RequestBody() TestSuite testSuite) throws JsonProcessingException {
        TestSuite savedTestSuite = testSuiteService.createTestSuite(testSuite);

        MultiValueMap headers = createHttpHeaders(savedTestSuite);

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    private MultiValueMap createHttpHeaders(TestSuite suite) {
        String entityURI = "/test-suite/" + suite.getId();

        MultiValueMap headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, entityURI);
        return headers;
    }

}

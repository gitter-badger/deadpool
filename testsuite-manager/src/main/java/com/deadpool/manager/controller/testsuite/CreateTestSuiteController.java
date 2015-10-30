package com.deadpool.manager.controller.testsuite;

import com.deadpool.manager.domain.model.TestSuite;
import com.deadpool.manager.service.testsuite.TestSuiteService;
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
    public ResponseEntity createTestSuite(@RequestBody() TestSuite testSuite) {
        TestSuite savedTestSuiteEntity = testSuiteService.createTestSuite(testSuite);

        MultiValueMap headers = createHttpHeaders(savedTestSuiteEntity.getName());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    private MultiValueMap createHttpHeaders(String testSuiteName) {
        String entityURI = "/test-suite/" + testSuiteName;

        MultiValueMap headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, entityURI);
        return headers;
    }

}

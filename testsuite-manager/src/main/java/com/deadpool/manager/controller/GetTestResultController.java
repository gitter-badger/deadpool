package com.deadpool.manager.controller;

import com.deadpool.manager.domain.Status;
import com.deadpool.manager.domain.entity.ExecutionProcessEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by roothema on 2015.10.08..
 */
@RestController
public class GetTestResultController {

    @RequestMapping(value = "/test-suite/{test-suite-name}/results", method = RequestMethod.GET, produces = "application/json")
    public ExecutionProcessEntity getTestSuiteResult(@PathParam("test-suite-id") String testSuiteName) {
        return new ExecutionProcessEntity(Status.RUNNING, testSuiteName, "fjdska");
    }

}

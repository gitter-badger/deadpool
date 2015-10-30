package com.deadpool.manager.controller.execution.process;

import com.deadpool.manager.domain.model.ProcessDescriptor;
import com.deadpool.manager.service.execution.process.RunTestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by roothema on 2015.10.08..
 */
@RestController
public class RunTestSuiteController {

    @Autowired
    private RunTestSuiteService runTestSuiteService;

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity runTestSuite(@RequestBody ProcessDescriptor runTestDto) {
        String uuid = runTestSuiteService.runTestSuite(runTestDto);
        return new ResponseEntity(Stream.of(uuid).collect(Collectors.toMap((k) -> "executionId", (v) -> v)), HttpStatus.ACCEPTED);
    }

}

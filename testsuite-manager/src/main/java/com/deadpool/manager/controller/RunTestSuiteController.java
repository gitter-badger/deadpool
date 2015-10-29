package com.deadpool.manager.controller;

import com.deadpool.manager.domain.model.RunTestSuiteDto;
import com.deadpool.manager.service.RunTestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by roothema on 2015.10.08..
 */
@RestController
public class RunTestSuiteController {

    @Autowired
    private RunTestSuiteService runTestSuiteService;

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity runTestSuite(@RequestBody RunTestSuiteDto runTestDto) {
        String uuid = runTestSuiteService.runTestSuite(runTestDto);
        return new ResponseEntity(uuid, HttpStatus.ACCEPTED);
    }

}

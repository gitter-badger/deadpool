package com.deadpool.manager.controller.execution.strategy;

import com.deadpool.manager.service.execution.strategy.ExecutionStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by roothema on 2015.10.29..
 */
@RestController
public class DeleteExecutionStrategyController {

    @Autowired
    private ExecutionStrategyService executionStrategyService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/execution-strategy/{name}", method = RequestMethod.DELETE)
    public void deleteExecutionStrategy(@PathVariable("name") String executionStrategyName) {
        executionStrategyService.deleteExecutionStrategy(executionStrategyName);
    }

}

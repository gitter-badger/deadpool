package com.deadpool.manager.controller.execution.strategy;

import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.service.execution.strategy.ExecutionStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roothema on 2015.10.29..
 */
@RestController
public class GetExecutionStrategyController {

    @Autowired
    private ExecutionStrategyService executionStrategyService;

    @RequestMapping(value = "/execution-strategy/{name}", method = RequestMethod.GET, produces = "application/json")
    public ExecutionStrategy getExecutionStrategy(@PathVariable("name") String executionStrategyName) {
        return executionStrategyService.getExecutionStrategy(executionStrategyName);
    }

}

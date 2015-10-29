package com.deadpool.manager.domain.model;

import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.entity.ExecutionStrategyEntity;

/**
 * Created by roothema on 2015.10.29..
 */
public class ExecutionStrategy {

    private String name;
    private ExecutionMode executionMode;
    private long duration;

    public ExecutionStrategy() {
    }

    public ExecutionStrategy(String name, ExecutionMode executionMode, long duration) {
        this.name = name;
        this.executionMode = executionMode;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExecutionMode getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(ExecutionMode executionMode) {
        this.executionMode = executionMode;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public ExecutionStrategyEntity toEntity() {

        ExecutionStrategyEntity executionStrategyEntity = new ExecutionStrategyEntity();
        executionStrategyEntity.setName(name);
        executionStrategyEntity.setExecutionMode(executionMode);
        executionStrategyEntity.setDuration(duration);

        return executionStrategyEntity;
    }
}

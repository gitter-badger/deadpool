package com.deadpool.worker.domain.model;

/**
 * Created by roothema on 2015.10.29..
 */
public class ExecutionStrategy {

    private String name;
    private ExecutionMode execution;
    private long duration;

    public ExecutionStrategy() {
    }

    public ExecutionStrategy(String name, ExecutionMode execution, long duration) {
        this.name = name;
        this.execution = execution;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExecutionMode getExecution() {
        return execution;
    }

    public void setExecution(ExecutionMode execution) {
        this.execution = execution;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

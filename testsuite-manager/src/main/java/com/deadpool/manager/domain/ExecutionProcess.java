package com.deadpool.manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by roothema on 2015.10.05..
 * Project: rest-api-metrics
 */
@Entity
public class ExecutionProcess {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String testSuiteName;

    @Column(nullable = false)
    private String executionStrategyName;

    public ExecutionProcess(Status status, String testSuiteName, String executionStrategyName) {
        id = UUID.randomUUID();
        this.status = status;
        this.testSuiteName = testSuiteName;
        this.executionStrategyName = executionStrategyName;
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public String getExecutionStrategyName() {
        return executionStrategyName;
    }
}

package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by roothema on 2015.10.05..
 */
@Entity
public class ExecutionProcessEntity {

    @Id
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String testSuiteName;

    @Column(nullable = false)
    private String executionStrategyName;

    protected ExecutionProcessEntity() {
    }

    public ExecutionProcessEntity(Status status, String testSuiteName, String executionStrategyName) {
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

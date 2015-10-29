package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.Status;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by roothema on 2015.10.05..
 */
@Entity
public class ExecutionProcessEntity {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String testSuiteName;

    @Column(nullable = false)
    private String executionStrategyName;

    protected ExecutionProcessEntity() {
    }

    public ExecutionProcessEntity(Status status, String testSuiteName, String executionStrategyName) {
        id = UUID.randomUUID().toString();
        this.status = status;
        this.testSuiteName = testSuiteName;
        this.executionStrategyName = executionStrategyName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public void setExecutionStrategyName(String executionStrategyName) {
        this.executionStrategyName = executionStrategyName;
    }

    public String getId() {
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

package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.ExecutionMode;
import com.deadpool.manager.domain.model.ExecutionStrategy;

import javax.persistence.*;

/**
 * Created by roothema on 2015.10.06..
 */
@Entity
public class ExecutionStrategyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExecutionMode executionMode;

    @Column(nullable = false)
    private long duration;

    @Version
    private Integer version;

    public ExecutionStrategyEntity() {
    }

    public ExecutionStrategyEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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

    public ExecutionStrategy toDTO() {
        return new ExecutionStrategy(name, executionMode, duration);
    }
}

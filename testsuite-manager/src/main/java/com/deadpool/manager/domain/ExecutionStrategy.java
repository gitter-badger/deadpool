package com.deadpool.manager.domain;

import javax.persistence.*;

/**
 * Created by roothema on 2015.10.06..
 * Project: rest-api-metrics
 */
@Entity
public class ExecutionStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    // TODO: create foreign key constraint for TestSuite entity, bidirectional and eager fetch
    @Version
    private Integer version;

    protected ExecutionStrategy() {
    }

    public ExecutionStrategy(String name) {
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

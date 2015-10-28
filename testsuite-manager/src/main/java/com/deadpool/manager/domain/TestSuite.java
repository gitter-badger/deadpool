package com.deadpool.manager.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by roothema on 2015.10.05..
 * Project: rest-api-metrics
 */
@Entity
public class TestSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "testSuite", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<HttpAction> httpActions;

    @OneToMany
    @JoinTable(name = "TESTSUITE_TO_STRATEGY",
            joinColumns = @JoinColumn(name = "testSuite_id"),
            inverseJoinColumns = @JoinColumn(name = "executionStrategy_id"))
    @Column(nullable = false)
    private List<ExecutionStrategy> executionStrategies;

    @Version
    private Integer version;

    protected TestSuite() {
    }

    public TestSuite(String name, List<HttpAction> httpActions) {
        this.name = name;
        this.httpActions = httpActions;
    }

    public TestSuite(String name, List<HttpAction> httpActions, List<ExecutionStrategy> executionStrategies) {
        this.name = name;
        this.httpActions = httpActions;
        this.executionStrategies = executionStrategies;
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

    public List<HttpAction> getHttpActions() {
        return httpActions;
    }

    public void setHttpActions(List<HttpAction> httpActions) {
        this.httpActions = httpActions;
    }

    public List<ExecutionStrategy> getExecutionStrategies() {
        return executionStrategies;
    }

    public void setExecutionStrategies(List<ExecutionStrategy> executionStrategies) {
        this.executionStrategies = executionStrategies;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", httpActions=" + httpActions +
                ", executionStrategies=" + executionStrategies +
                ", version=" + version +
                '}';
    }
}

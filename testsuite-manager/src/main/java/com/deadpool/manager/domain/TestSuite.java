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

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TESTSUITE_TO_ACTION",
            joinColumns = @JoinColumn(name = "testSuite_id"),
            inverseJoinColumns = @JoinColumn(name = "httpAction_id"))
    private List<HttpAction> httpActions;

    @Version
    private Integer version;

    protected TestSuite() {
    }

    public TestSuite(String name, List<HttpAction> httpActions) {
        this.name = name;
        this.httpActions = httpActions;
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

    @Override
    public String toString() {
        return "TestSuite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", httpActions=" + httpActions +
                ", version=" + version +
                '}';
    }
}

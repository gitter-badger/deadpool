package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.model.TestSuite;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by roothema on 2015.10.05..
 */
@Entity
public class TestSuiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TESTSUITE_TO_ACTION",
            joinColumns = @JoinColumn(name = "testSuite_id"),
            inverseJoinColumns = @JoinColumn(name = "httpAction_id"))
    private List<HttpActionEntity> httpActionEntities;

    @Version
    private Integer version;

    public TestSuiteEntity() {
    }

    public TestSuiteEntity(String name, List<HttpActionEntity> httpActionEntities) {
        this.name = name;
        this.httpActionEntities = httpActionEntities;
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

    public List<HttpActionEntity> getHttpActionEntities() {
        return httpActionEntities;
    }

    public void setHttpActionEntities(List<HttpActionEntity> httpActionEntities) {
        this.httpActionEntities = httpActionEntities;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", httpActions=" + httpActionEntities +
                ", version=" + version +
                '}';
    }

    public TestSuite toDTO() {
        TestSuite testSuite = new TestSuite();
        testSuite.setName(name);
        testSuite.setHttpActions(httpActionEntities.stream().map(HttpActionEntity::toDTO).collect(Collectors.toList()));
        return testSuite;
    }
}

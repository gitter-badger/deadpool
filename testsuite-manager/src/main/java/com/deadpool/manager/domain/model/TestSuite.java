package com.deadpool.manager.domain.model;

import com.deadpool.manager.domain.entity.TestSuiteEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by roothema on 2015.10.29..
 */
public class TestSuite {

    private String name;
    private List<HttpAction> httpActions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HttpAction> getHttpActions() {
        return httpActions;
    }

    public void setHttpActions(List<HttpAction> httpActionEntities) {
        this.httpActions = httpActionEntities;
    }

    public TestSuiteEntity toEntity() {
        TestSuiteEntity testSuiteEntity = new TestSuiteEntity();
        testSuiteEntity.setName(name);
        testSuiteEntity.setHttpActionEntities(httpActions.stream().map(HttpAction::toEntity).collect(Collectors.toList()));
        return testSuiteEntity;
    }
}
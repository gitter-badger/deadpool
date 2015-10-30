package com.deadpool.worker.domain.model;


import java.util.List;

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
}
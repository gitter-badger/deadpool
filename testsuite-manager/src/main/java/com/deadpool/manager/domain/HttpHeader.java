package com.deadpool.manager.domain;

import javax.persistence.*;

/**
 * Created by roothema on 2015.10.06..
 */
@Entity
public class HttpHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String key;

    @Column(nullable = false, length = 50)
    private String value;

    @Version
    private Integer version;

    protected HttpHeader() {
    }

    public HttpHeader(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}

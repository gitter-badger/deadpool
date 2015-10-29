package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.model.HttpHeader;

import javax.persistence.*;

/**
 * Created by roothema on 2015.10.06..
 */
@Entity
public class HttpHeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String key;

    @Column(nullable = false, length = 50)
    private String value;

    @Version
    private Integer version;

    protected HttpHeaderEntity() {
    }

    public HttpHeaderEntity(String key, String value) {
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


    public HttpHeader toDTO() {
        HttpHeader httpHeader = new HttpHeader();
        httpHeader.setKey(key);
        httpHeader.setValue(value);
        return httpHeader;
    }
}

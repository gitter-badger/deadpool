package com.deadpool.manager.domain.model;

import com.deadpool.manager.domain.entity.HttpHeaderEntity;

/**
 * Created by roothema on 2015.10.29..
 */
public class HttpHeader {

    private String key;
    private String value;

    public HttpHeader() {
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

    public HttpHeaderEntity toEntity() {
        return new HttpHeaderEntity(key, value);
    }
}

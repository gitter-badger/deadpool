package com.deadpool.manager.domain.model;

import com.deadpool.manager.domain.entity.HttpActionEntity;

/**
 * Created by roothema on 2015.10.29..
 */
public class HttpAction {

    private String name;
    private String headers;
    private String url;
    private String method;
    private String payload;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public HttpActionEntity toEntity() {
        HttpActionEntity httpActionEntity = new HttpActionEntity();
        httpActionEntity.setName(name);
        httpActionEntity.setHeaders(headers);
        httpActionEntity.setMethod(method);
        httpActionEntity.setPayload(payload);
        httpActionEntity.setUrl(url);

        return httpActionEntity;
    }
}

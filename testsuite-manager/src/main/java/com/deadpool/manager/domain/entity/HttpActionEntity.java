package com.deadpool.manager.domain.entity;

import com.deadpool.manager.domain.model.HttpAction;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by roothema on 2015.10.05..
 */
@Entity
public class HttpActionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ACTION_TO_HEADER",
            joinColumns = @JoinColumn(name = "httpAction_id"),
            inverseJoinColumns = @JoinColumn(name = "httpHeader_id"))
    @Column(nullable = true)
    private Set<HttpHeaderEntity> headers;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String method;

    @Column(nullable = true)
    private String payload;

    @Version
    private Integer version;

    public HttpActionEntity() {
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

    public Set<HttpHeaderEntity> getHeaders() {
        return headers;
    }

    public void setHeaders(Set<HttpHeaderEntity> headers) {
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

    @Override
    public String toString() {
        return "HttpAction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headers=" + headers +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", payload='" + payload + '\'' +
                ", version=" + version +
                '}';
    }

    public HttpAction toDTO() {
        HttpAction httpAction = new HttpAction();
        httpAction.setName(name);
        httpAction.setUrl(url);
        httpAction.setMethod(method);
        httpAction.setPayload(payload);
        httpAction.setHeaders(headers.stream().map(HttpHeaderEntity::toDTO).collect(Collectors.toSet()));
        return httpAction;
    }
}

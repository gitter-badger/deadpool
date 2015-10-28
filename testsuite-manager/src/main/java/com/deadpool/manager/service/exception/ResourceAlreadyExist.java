package com.deadpool.manager.service.exception;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public class ResourceAlreadyExist extends RuntimeException {

    public ResourceAlreadyExist(String message) {
        super(message);
    }

}

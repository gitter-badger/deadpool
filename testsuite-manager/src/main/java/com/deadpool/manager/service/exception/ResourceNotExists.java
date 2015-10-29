package com.deadpool.manager.service.exception;

/**
 * Created by roothema on 2015.10.29..
 */
public class ResourceNotExists extends RuntimeException {
    public ResourceNotExists(String message) {
        super(message);
    }
}

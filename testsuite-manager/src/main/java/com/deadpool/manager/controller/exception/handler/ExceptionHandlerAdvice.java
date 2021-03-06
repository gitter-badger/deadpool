package com.deadpool.manager.controller.exception.handler;

import com.deadpool.manager.service.exception.ResourceAlreadyExist;
import com.deadpool.manager.service.exception.ResourceNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by roothema on 2015.10.08..
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ResourceAlreadyExist.class)
    public ResponseEntity exception(ResourceAlreadyExist exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ResourceNotExists.class)
    public ResponseEntity exception(ResourceNotExists exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}

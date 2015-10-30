package com.deadpool.worker;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by roothema on 2015.10.05..
 * Project: rest-api-metrics
 */
@SpringBootApplication
@EnableBatchProcessing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

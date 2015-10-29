package com.deadpool.manager.controller;

import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * Created by daniel on 10/29/2015.
 */
@Configuration
public class RunTestSuiteControllerTestConfiguration {

    @Bean
    @Primary
    public AmqpTemplate getAmqpTemplate() {
        return Mockito.mock(RabbitTemplate.class);
    }
}

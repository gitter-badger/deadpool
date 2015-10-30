package com.deadpool.manager.controller.configuration;

import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

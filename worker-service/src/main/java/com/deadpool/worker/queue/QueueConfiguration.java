package com.deadpool.worker.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class QueueConfiguration {

    @Value("${rabbit.queue.name}")
    private String queueName;

    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    @Bean
    public Queue getQueue() {
        return new Queue(queueName);
    }

    @Bean
    public RabbitTemplate getRabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        rabbitTemplate.setQueue(queueName);
        return rabbitTemplate;
    }
}

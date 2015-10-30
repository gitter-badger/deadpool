package com.deadpool.worker.reader;

import com.deadpool.worker.domain.model.TestExecutionDescriptor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.amqp.AmqpItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class ReaderConfiguration {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Bean
    public ItemReader<TestExecutionDescriptor> reader() {
        ItemReader<TestExecutionDescriptor> reader = new AmqpItemReader<>(rabbitTemplate);
        return reader;
    }
}

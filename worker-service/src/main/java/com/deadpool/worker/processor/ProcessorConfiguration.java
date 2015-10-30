package com.deadpool.worker.processor;

import com.deadpool.worker.domain.entity.TestResult;
import com.deadpool.worker.domain.model.TestExecutionDescriptor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class ProcessorConfiguration {

    @Bean
    public ItemProcessor<TestExecutionDescriptor, TestResult> processor() {
        return new TestExecutionDescriptorProcessor();
    }
}

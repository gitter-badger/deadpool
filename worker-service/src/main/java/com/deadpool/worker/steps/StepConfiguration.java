package com.deadpool.worker.steps;

import com.deadpool.worker.domain.entity.TestResult;
import com.deadpool.worker.domain.model.TestExecutionDescriptor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class StepConfiguration {

    @Bean
    public Step runTestStep(StepBuilderFactory stepBuilderFactory, ItemReader<TestExecutionDescriptor> reader,
                            ItemWriter<TestResult> writer, ItemProcessor<TestExecutionDescriptor, TestResult> processor) {
        return stepBuilderFactory.get("runTestStep")
                .<TestExecutionDescriptor, TestResult> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}

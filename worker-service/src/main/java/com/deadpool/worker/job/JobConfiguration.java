package com.deadpool.worker.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class JobConfiguration {

    @Bean
    public Job runTestJob(JobBuilderFactory jobs, Step step) {
        return jobs.get("runTestJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }
}

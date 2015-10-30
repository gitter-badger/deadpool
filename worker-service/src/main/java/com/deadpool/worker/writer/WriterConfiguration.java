package com.deadpool.worker.writer;

import com.deadpool.worker.domain.entity.TestResult;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by daniel on 2015.10.30..
 */
@Configuration
public class WriterConfiguration {

    private static final String INSERT_TEST_RESULT_SQL = "INSERT INTO test_results (minimumResponseTime, maximumResponseTime, averageResponseTime, throughput)" +
            "VALUES (:minimumResponseTime, :maximumResponseTime, :averageResponseTime, :throughput)";

    @Bean
    public ItemWriter<TestResult> writer(DataSource dataSource) {
        JdbcBatchItemWriter<TestResult> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TestResult>());
        writer.setSql(INSERT_TEST_RESULT_SQL);
        writer.setDataSource(dataSource);
        return writer;
    }
}

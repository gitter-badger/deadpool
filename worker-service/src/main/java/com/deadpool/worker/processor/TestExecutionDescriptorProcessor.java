package com.deadpool.worker.processor;

import com.deadpool.worker.domain.entity.TestResult;
import com.deadpool.worker.domain.model.TestExecutionDescriptor;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by daniel on 2015.10.30..
 */
public class TestExecutionDescriptorProcessor implements ItemProcessor<TestExecutionDescriptor, TestResult> {

    @Override
    public TestResult process(TestExecutionDescriptor testExecutionDescriptor) throws Exception {
        return new TestResult();
    }

}

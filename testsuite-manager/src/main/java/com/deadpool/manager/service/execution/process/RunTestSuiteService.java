package com.deadpool.manager.service.execution.process;

import com.deadpool.manager.domain.model.ProcessDescriptor;

/**
 * Created by daniel on 10/29/2015.
 */
public interface RunTestSuiteService {
    String runTestSuite(ProcessDescriptor processDescriptor);
}

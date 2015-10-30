package com.deadpool.manager.controller.helper;

import com.deadpool.manager.domain.model.ExecutionStrategy;
import com.deadpool.manager.domain.model.ProcessDescriptor;
import com.deadpool.manager.domain.model.TestSuite;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

/**
 * Created by roothema on 2015.10.08..
 */
public class HttpRequestHelper {

    public static Response callNewTestSuiteEndpoint(TestSuite testSuite) {
        return given().contentType(ContentType.JSON).body(testSuite).when().post("/test-suite");
    }

    public static Response callNewExecutionStrategyEndpoint(ExecutionStrategy executionStrategy) {
        return given().contentType(ContentType.JSON).body(executionStrategy).when().post("/execution-strategy");
    }

    public static Response callGetTestSuiteEndpoint(String testSuiteName) {
        return get("/test-suite/" + testSuiteName);
    }

    public static Response callGetExecutionStrategyEndpoint(String executionStrategyName) {
        return get("/execution-strategy/" + executionStrategyName);
    }

    public static Response callListTestSuiteEndpoint() {
        return get("/test-suite");
    }

    public static Response callRunTestSuiteEndpoint(ProcessDescriptor processDescriptor) {
        return given().contentType(ContentType.JSON).body(processDescriptor).when().post("/run/");
    }
}

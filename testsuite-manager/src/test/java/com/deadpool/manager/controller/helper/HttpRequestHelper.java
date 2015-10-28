package com.deadpool.manager.controller.helper;

import com.deadpool.manager.domain.ExecutionStrategy;
import com.deadpool.manager.domain.TestSuite;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by roothema on 2015.10.08..
 * Project: rest-api-metrics
 */
public class HttpRequestHelper {

    public static Response callNewTestSuiteEndpoint(TestSuite newTestSuite) {
        return given().contentType(ContentType.JSON).body(newTestSuite).when().post("/test-suite");
    }

    public static Response callNewExecutionStrategyEndpoint(TestSuite defaultTestSuite, ExecutionStrategy executionStrategy) {
        return given().contentType(ContentType.JSON).body(executionStrategy).when().post("/test-suite/" + defaultTestSuite.getName() + "/execution-strategy");
    }
}

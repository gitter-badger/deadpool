package com.deadpool.manager.controller.helper;

import com.deadpool.manager.domain.HttpAction;
import com.deadpool.manager.domain.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roothema on 2015.10.08..
 */
public class DtoHelper {

    public static TestSuite createDefaultTestSuite() {
        HttpAction httpActionPostXYEndpoint = new HttpAction();
        httpActionPostXYEndpoint.setName("create something on XY rest endpoint");
        httpActionPostXYEndpoint.setMethod("POST");
        httpActionPostXYEndpoint.setPayload("{'foo':'bar'}");
        httpActionPostXYEndpoint.setUrl("http://localhost:8081/sample-endpoint-post");

        HttpAction httpActionGETXYEndpoint = new HttpAction();
        httpActionGETXYEndpoint.setName("get object by XY rest endpoint");
        httpActionGETXYEndpoint.setMethod("GET");
        httpActionGETXYEndpoint.setUrl("http://localhost:8081/sample-endpoint-get");

        List<HttpAction> httpActions = new ArrayList<>();
        httpActions.add(httpActionPostXYEndpoint);
        httpActions.add(httpActionGETXYEndpoint);

        return new TestSuite("sample-SuiteName", httpActions);
    }

}

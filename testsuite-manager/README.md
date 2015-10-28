# rest-api-metrics
The project focuses on Rest API performance testing.

# Redis CLI

Install redis-server

    sudo apt-get install redis-server
    
Connect with redis-cli

    redis-cli -h 127.0.0.1 -p 6379

Subscribe for channel:

    SUBSCRIBE benchmark-test

# Rest API manual
 
## create new TestSuite
    
    curl -X POST -H 'Content-Type:application/json' --data-binary @sample-SuiteName-payload.json http://localhost:8080/test-suite

    PAYLOAD:
    {
        "id":null,
        "name":"sample-SuiteName",
        "httpActions":[
            {
                "id":null,
                "name":"create something on XY rest endpoint",
                "headers":null,
                "url":"http://localhost:8081/sample-endpoint-post",
                "method":"POST",
                "payload":"{'foo':'bar'}"
            },
            {
                "id":null,
                "name":"get object by XY rest endpoint",
                "headers":null,
                "url":"http://localhost:8081/sample-endpoint-get",
                "method":"GET",
                "payload":null
            }
        ],
        "executionStrategies":null
    }

## get TestSuite
    curl -X GET http://localhost:8080/test-suite/sample-SuiteName | python -m json.tool
    
    OUTPUT:
    {
        "executionStrategies": [],
        "httpActions": [
            {
                "headers": [],
                "id": 1,
                "method": "POST",
                "name": "create something on XY rest endpoint",
                "payload": "{'foo':'bar'}",
                "url": "http://localhost:8081/sample-endpoint-post"
            },
            {
                "headers": [],
                "id": 2,
                "method": "GET",
                "name": "get object by XY rest endpoint",
                "payload": null,
                "url": "http://localhost:8081/sample-endpoint-get"
            }
        ],
        "id": 1,
        "name": "sample-SuiteName"
    }

## run TestSuite

    curl -X POST http://localhost:8080/test-suite/sample-SuiteName/run
    
## get TestSuiteResult

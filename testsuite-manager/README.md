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
        "name":"sample-SuiteName",
        "httpActions":[
            {
                "name":"create something on XY rest endpoint",
                "headers":[ {"Accept","something"}, {"foo":"bar"} ],
                "url":"http://localhost:8081/sample-endpoint-post",
                "method":"POST",
                "payload":"{'foo':'bar'}"
            },
            {
                "name":"get object by XY rest endpoint",
                "url":"http://localhost:8081/sample-endpoint-get",
                "method":"GET"
            }
        ]
    }

###Constraints
    Validate the HttpActions
        - allowed methods are PUT,POST,GET,HEAD,PATCH,DELETE
        - null headers value is allowed
        - check the URL with regexp
        - name could be anything, for e.g. UUID is allowed too
    Validate the TestSuite
        - name should be unique, accepted characters [a-zA-Z0-9._]* with length 100
        - has to contain at least one HttpAction


## get TestSuite
    curl -X GET http://localhost:8080/test-suite/sample-SuiteName | python -m json.tool
    
    OUTPUT:
    {
        "name": "sample-SuiteName",
        "httpActions": [
            {
                "name": "create something on XY rest endpoint",
                "headers": [],
                "method": "POST",
                "payload": "{'foo':'bar'}",
                "url": "http://localhost:8081/sample-endpoint-post"
            },
            {
                "name": "get object by XY rest endpoint",
                "headers": [],
                "method": "GET",
                "payload": null,
                "url": "http://localhost:8081/sample-endpoint-get"
            }
        ]
    }

## create new ExecutionStrategy
    curl -X POST -H 'Content-Type:application/json' --data-binary @sample-SuiteName-payload.json http://localhost:8080/execution-strategy

    PAYLOAD:
    {
        "name":"sample-ExecutionStrategy",
        "strategy":"sequential",
        "duration":"3600"
    }

### Constraints
    - name should be unique
    - strategy values: SEQUENTIAL, PARALLEL, RANDOM
    - Duration is in seconds.

## get ExecutionStrategy
    curl -X GET http://localhost:8080/execution-strategy/sample-ExecutionStrategy | python -m json.tool

    OUTPUT:
    {
       "name":"sample-ExecutionStrategy",
       "strategy":"sequential",
       "duration":"3600"
    }

## run TestSuite

    curl -X POST http://localhost:8080/run

    PAYLOAD:
    {
        "testsuite-name":"sample-SuiteName",
        "strategy-name":"sample-ExecutionStrategy"
    }

    RESPONSE:
    {
        "execution-id": "<uuid>"
    }

## get TestSuiteResult

    curl -X GET http://localhost:8080/test-result/<uuid of the execution> | python -m json.tool

    RESPONSE:
    {
        TBD...
    }

#Queue contract DTO

    {
        "name":"sample-SuiteName",
        "httpActions":[
            {
                "name":"create something on XY rest endpoint",
                "headers":[ {"Accept","something"}, {"foo":"bar"} ],
                "url":"http://localhost:8081/sample-endpoint-post",
                "method":"POST",
                "payload":"{'foo':'bar'}"
            },
            {
                "name":"get object by XY rest endpoint",
                "url":"http://localhost:8081/sample-endpoint-get",
                "method":"GET"
            }
        ],
        "execution-strategy": {
               "name":"sample-ExecutionStrategy",
               "strategy":"sequential",
               "duration":"3600"
        }
    }

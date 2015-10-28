#!/usr/bin/env bash

curl -X POST -H 'Content-Type:application/json' --data-binary @sample-SuiteName-payload.json http://localhost:8080/test-suite

curl -X POST http://localhost:8080/test-suite/sample-SuiteName/run

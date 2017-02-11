#!/usr/bin/env bash
lein clean &&  lein cucumber  --plugin json:target/cucumber/json/report.json --plugin html:target/cucumber/html --plugin junit:target/cucumber/junit/report.xml

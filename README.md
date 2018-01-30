# Spring Batch + MongoDB + Elasticsearch

This is example of Spring Boot application with Spring Batch, MongoDB and Elasticsearch.

In docker folder you can find Docker compose configuration for Elasticsearch, Kibana and MongoDB

## Data

1. Air pollution: https://www.kaggle.com/epa/hazardous-air-pollutants
2. Transactions: https://support.spatialkey.com/spatialkey-sample-csv-data/

## Run

1. Run Docker (cd docker/):
    * docker-compose -f elk.yml up
    * docker-compose -f mongodb.yml up
2. Run ElkBigdataApplication application

## REST API

* Swagger: http://localhost:8080/swagger-ui.html

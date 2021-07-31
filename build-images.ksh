#!/usr/bin/env bash

cd /Users/jasvinder.saggu/projects/temp/micro-services/eshop-services

mvn clean install

cd api-gateway
docker build -t eshop/api-gateway:0.0.1 .

cd ../customer 
docker build -t eshop/customers:0.0.1 .

cd ../order 
docker build -t eshop/orders:0.0.1 .

cd ../product 
docker build -t eshop/products:0.0.1 .

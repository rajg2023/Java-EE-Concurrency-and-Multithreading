#!/bin/sh
mvn clean package && docker build -t com.rajivgiri/JavaEEConcurrency3 .
docker rm -f JavaEEConcurrency3 || true && docker run -d -p 8080:8080 -p 4848:4848 --name JavaEEConcurrency3 com.rajivgiri/JavaEEConcurrency3 

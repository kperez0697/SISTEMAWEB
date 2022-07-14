#!/bin/sh
mvn clean package && docker build -t com.nabenik/SistamaVentasWeb .
docker rm -f SistamaVentasWeb || true && docker run -d -p 9080:9080 -p 9443:9443 --name SistamaVentasWeb com.nabenik/SistamaVentasWeb
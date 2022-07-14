@echo off
call mvn clean package
call docker build -t com.nabenik/SistamaVentasWeb .
call docker rm -f SistamaVentasWeb
call docker run -d -p 9080:9080 -p 9443:9443 --name SistamaVentasWeb com.nabenik/SistamaVentasWeb
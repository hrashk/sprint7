FROM maven:3.9.9-amazoncorretto-11

COPY src /sprint7/src
COPY pom.xml /sprint7/pom.xml

WORKDIR /sprint7

ENTRYPOINT mvn clean test

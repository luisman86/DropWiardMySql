FROM openjdk:8-jre

COPY DropWiardMySql-1.0.jar /tmp/

COPY configuration.yml /tmp/

WORKDIR /tmp






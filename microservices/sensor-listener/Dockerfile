FROM openjdk:17-alpine
WORKDIR /app
COPY target/sensor-listener-0.0.1-SNAPSHOT.jar /sensor-listener-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sensor-listener-0.0.1-SNAPSHOT.jar"]
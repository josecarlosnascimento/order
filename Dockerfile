FROM openjdk:17-jdk-alpine
MAINTAINER Jose Carlos
COPY target/order-0.0.1-SNAPSHOT.jar order.jar
ENTRYPOINT ["java","-jar","/order.jar"]
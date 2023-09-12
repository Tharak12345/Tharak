FROM openjdk:17-jdk-alpine
WORKDIR /opt
ENV PORT 8082
EXPOSE 8082
COPY target/*.jar /opt/user-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar user-service.jar

FROM openjdk:11
MAINTAINER PAULO MEDEIROS
COPY build/libs/restapi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
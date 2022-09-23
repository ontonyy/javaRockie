FROM openjdk:17-alpine
ADD build/libs/spring-postgres-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
COPY initial.sql initial.sql
ENTRYPOINT ["java", "-jar", "app.jar"]


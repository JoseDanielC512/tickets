FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/tickets-0.0.1-SNAPSHOT.jar /app/tickets-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tickets-0.0.1-SNAPSHOT.jar"]


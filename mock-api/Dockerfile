FROM openjdk:17-alpine

COPY build/libs/mock-api-0.0.1-SNAPSHOT.jar /app/mock-app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "mock-app.jar"]
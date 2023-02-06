# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 as builder
COPY . /app
WORKDIR /app
RUN mvn clean install -Dmaven.test.skip=true

# Stage 2: Package the application in a minimal image
FROM openjdk:17-jdk-alpine
COPY --from=builder /app/target/recipe-api-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app.jar"]
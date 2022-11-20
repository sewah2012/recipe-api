FROM openjdk:17-alpine as builder
RUN mkdir -p /app/source
COPY . ./app/source
WORKDIR /app/source
RUN dos2unix mvnw
RUN ./mvnw clean package -DskipTests

FROM builder
COPY --from=builder /app/source/target/*.jar /app/app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]

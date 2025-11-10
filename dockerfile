# Stage 1: Build
FROM gradle:8.10-jdk17 AS builder
WORKDIR /app

COPY build.gradle settings.gradle ./
COPY gradle ./gradle
RUN gradle build -x test || return 0

COPY . .
RUN gradle clean bootJar -x test

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

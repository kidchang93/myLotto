FROM openjdk:17-jdk-slim AS builder

WORKDIR /app

# Gradle Wrapper와 필요한 파일 복사
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle ./
COPY settings.gradle ./
COPY src ./src

# Build the application
RUN ./gradlew build -x test

# Create a new image for the final deployment
FROM openjdk:17-jdk-slim
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
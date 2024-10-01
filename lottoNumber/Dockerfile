# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the gradlew script and set execute permission
COPY gradlew ./
COPY gradle/wrapper/ ./gradle/wrapper/
COPY build.gradle ./
COPY settings.gradle ./
COPY src ./src/

# Give execute permission to gradlew
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build -x test

# Create a new image for the final deployment
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
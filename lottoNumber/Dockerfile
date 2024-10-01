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
RUN ./gradlew build -x test --info

# Check the contents of the build/libs directory
RUN ls -al /app/build/libs/

# Create a new image for the final deployment
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file to the container
COPY --from=builder /app/build/libs/*.jar app.jar

# Check if the JAR file exists
RUN if [ -f app.jar ]; then echo "JAR file found"; else echo "No JAR file found"; fi

ENTRYPOINT ["java", "-jar", "app.jar"]
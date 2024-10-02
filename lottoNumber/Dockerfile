FROM gradle:8.8-jdk-alpine as build
WORKDIR /app
COPY . .
#1-1. Gradle Wrapper 스크립트에 실행 권한을 부여
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev", "/app.jar"]
# stage 1: build the springboot application
FROM gradle:8.10.2-jdk-alpine as build
WORKDIR /app
COPY lottoNumber .
#1-1. Gradle Wrapper 스크립트에 실행 권한을 부여
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

#stage 2: build the Vue3.js
FROM node:20-alpine as frontend-build
WORKDIR /app/lottofront

COPY lottofront/package*.json ./
RUN npm install

COPY lottofront ./
RUN npm run build -- --emptyOutDir

# stage 3. create final springboot image
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

ENV PORT 8080
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev", "app.jar"]
#ENTRYPOINT ["java","-jar", "app.jar"]

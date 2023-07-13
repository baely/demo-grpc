#FROM gradle:8.2.0-jdk17 AS builder
#
#WORKDIR /app
#
#COPY ./src /app/src
#COPY ./build.gradle.kts /app/build.gradle.kts
#COPY ./settings.gradle.kts /app/settings.gradle.kts
#
#RUN gradle build --no-daemon
#
#FROM openjdk:17.0.1-jdk-slim
#
#RUN mkdir /app
#
#COPY --from=builder /app/build/libs/*.jar /app/app.jar
#
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]

#Build stage

FROM openjdk:17.0.1-jdk-slim AS builder
WORKDIR /app
COPY . .
RUN ./gradlew run

# Package stage

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=builder /app .
ENTRYPOINT exec java -jar /app/build/libs/java-1.0-SNAPSHOT.jar

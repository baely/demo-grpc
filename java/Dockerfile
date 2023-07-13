FROM gradle:8.2.0-jdk17-alpine AS builder

WORKDIR /app

COPY ./src /app/src
COPY ./build.gradle.kts /app/build.gradle.kts
COPY ./settings.gradle.kts /app/settings.gradle.kts

RUN gradle build --no-daemon

FROM openjdk:17.0.1-jdk-slim

RUN mkdir /app

#COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]

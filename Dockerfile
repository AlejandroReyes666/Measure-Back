# Etapa 1: Construcción del .jar usando Gradle
FROM gradle:8.7.0-jdk17 AS builder
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
# Etapa 1: construir el JAR
FROM gradle:8.4-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon

# Etapa 2: imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]


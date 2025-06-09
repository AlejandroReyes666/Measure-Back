# Etapa 1: Construcción del .jar usando Gradle
FROM gradle:8.7.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon -x test

# Etapa 2: imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080

# Usar perfil de producción por defecto
ENV SPRING_PROFILES_ACTIVE=prod
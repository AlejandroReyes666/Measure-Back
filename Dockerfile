# Etapa 1: Construcción del .jar usando Gradle
FROM gradle:8.7.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon -x test

# Etapa 2: imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
COPY jvm.options /app/jvm.options

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

# Ejecutar con archivo de opciones JVM
CMD ["java", "@jvm.options", "-jar", "app.jar"]
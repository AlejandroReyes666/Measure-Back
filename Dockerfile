# Imagen base con Java 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Gradle o Maven
COPY build/libs/mediciones-api-0.0.1.jar app.jar

# Habilitar perfil de producción
ENV SPRING_PROFILES_ACTIVE=prod

# Expone el puerto que Spring Boot usará internamente
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

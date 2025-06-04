# Etapa 1: Construcción de la aplicación
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copiar los archivos necesarios
COPY . .

# Dar permisos al script de Gradle si no los tiene
RUN chmod +x gradlew

# Compilar el proyecto, omitiendo los tests
RUN ./gradlew clean build -x test

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Puerto expuesto (Railway detecta automáticamente, pero puedes incluirlo)
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]

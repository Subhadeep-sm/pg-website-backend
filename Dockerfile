# === Stage 1: Build the JAR ===
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy all source files
COPY . .

# Build the JAR (skip tests if desired)
RUN mvn clean package -DskipTests

# === Stage 2: Create runtime image ===
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

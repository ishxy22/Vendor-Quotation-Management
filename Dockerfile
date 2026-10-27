# Stage 1: Build the application using Maven and OpenJDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application with optimized memory for Render free tier
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render free tier provides 512MB RAM; capping heap prevents Out-of-Memory crashes
ENV JAVA_OPTS="-Xmx384m -Xms128m"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
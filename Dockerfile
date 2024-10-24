FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim AS prod
WORKDIR /app
COPY --from=build /app/target/k19.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM maven:3.9.11-eclipse-temurin-17-alpine AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src src
RUN mvn -q clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
RUN addgroup -S deployhub && adduser -S deployhub -G deployhub
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
USER deployhub
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


# syntax=docker/dockerfile:1.6

FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /workspace
COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -B -DskipTests package && \
    mkdir -p /workspace/build && \
    cp target/*.jar /workspace/build/app.jar

FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd --system --uid 1001 atm && mkdir -p /app/data && chown atm:atm /app /app/data
COPY --from=builder /workspace/build/app.jar /app/app.jar
USER atm
ENV SERVER_PORT=8080
ENV USERS_FILE=/app/data/users.csv
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app
COPY pom.xml .
# This layer caches the dependencies
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
# Make sure this matches your actual JAR file name (check target directory)
COPY --from=builder /app/target/work-done-server-*.jar app.jar

RUN mkdir -p /var/data/logs

EXPOSE 19062
ENTRYPOINT ["java", "-jar", "app.jar"]

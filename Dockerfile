FROM maven:3.9-eclipse-temurin-23 AS builder

WORKDIR /app
COPY pom.xml .
# This layer caches the dependencies
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk
WORKDIR /app
# Make sure this matches your actual JAR file name (check target directory)
COPY --from=builder /app/target/work-done-server-*.jar app.jar

EXPOSE 19062
ENTRYPOINT ["java", "-jar", "app.jar"]

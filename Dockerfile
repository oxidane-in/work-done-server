FROM amazoncorretto:23 AS builder
RUN yum install -y maven
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:23
WORKDIR /app
COPY --from=builder /app/target/work-done-server-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /var/data/logs
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

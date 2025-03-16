FROM amazoncorretto:23 AS builder
WORKDIR /app
RUN yum install -y maven
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:23
WORKDIR /app
RUN yum install -y shadow-utils && \
    groupadd --system --gid 1001 appuser && \
    useradd --system --uid 1001 --gid 1001 appuser && \
    yum remove -y shadow-utils && \
    yum clean all
COPY --from=builder /app/target/*.jar app.jar
RUN chown appuser:appuser /app/app.jar
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
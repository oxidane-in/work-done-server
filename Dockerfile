# Use Amazon Corretto JDK 23
FROM amazoncorretto:23

# Set working directory
WORKDIR /app

# Copy the JAR file to the container
COPY target/your-app.jar app.jar

# Create logs directory if it doesn't exist
RUN mkdir -p /var/data/logs

# Set correct permissions (optional)
RUN chmod -R 777 /var/data/logs

# Set environment variables (if needed)
ENV SPRING_PROFILES_ACTIVE=staging
ENV LOG_DIR=/var/data/logs

# Start the application
CMD ["java", "-jar", "app.jar"]

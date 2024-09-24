

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application's JAR file to the container
COPY target/demo-1.0.0.jar /app/myapp.jar

# Expose the port on which the application will run
EXPOSE 4200

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
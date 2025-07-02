FROM openjdk:21-jdk-slim
WORKDIR /app
# Update system packages to reduce vulnerabilities
RUN apt-get update && apt-get upgrade -y && apt-get clean && rm -rf /var/lib/apt/lists/*

COPY target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app//app.jar"]

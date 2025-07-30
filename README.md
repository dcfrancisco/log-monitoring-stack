# 🚀 Spring Boot ELK Stack - Production-Ready Log Monitoring

> **A complete, production-ready log aggregation and visualization stack with custom Docker images built from official ELK installers**

[![Docker](https://img.shields.io/badge/Docker-Compose-blue?logo=docker)](https://docs.docker.com/compose/)
[![ELK Stack](https://img.shields.io/badge/ELK-7.17.9-orange?logo=elastic)](https://www.elastic.co/elastic-stack/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=springboot)](https://spring.io/projects/spring-boot)
[![Ubuntu](https://img.shields.io/badge/Ubuntu-22.04-purple?logo=ubuntu)](https://ubuntu.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## ✨ **What Makes This Special?**

🎯 **Production-Ready**: Custom Docker images with dedicated users, health checks, and optimized configurations  
⚡ **Offline-Capable**: Local installers mean faster, more reliable builds without internet dependency  
🐧 **Ubuntu-Based**: Familiar Linux environment that's easy to customize and extend  
📊 **Complete Pipeline**: End-to-end logging from Spring Boot → Logstash → Elasticsearch → Kibana  
🛡️ **Security-First**: Non-root containers, proper permissions, and clean .dockerignore files  

## 🏗️ **Architecture Overview**

This project demonstrates a complete **centralized logging solution** using the ELK Stack:

- 🟡 **Spring Boot** – Generates structured JSON logs via Logback
- 🔷 **Logstash** – Collects logs via TCP and processes them
- 🔶 **Elasticsearch** – Stores and indexes log data for fast searching
- 🔵 **Kibana** – Provides rich visualization and log analysis dashboard

## 🌟 **Two Versions Available:**

- **🚀 Main Branch** (Current): Advanced setup with custom Dockerfiles built from official installers
- **📝 [Simple Version](https://github.com/dcfrancisco/log-monitoring-stack/tree/simple-version)**: Basic setup using official Docker images - perfect for quick starts

## 🎯 **Why Choose This Project?**

### **🏢 For DevOps Teams:**
- **Enterprise-Ready**: Custom images you can audit, modify, and control
- **Offline Deployments**: No external dependencies during container builds
- **Scalable Foundation**: Easy to extend with monitoring, alerting, and additional services

### **📚 For Learning:**
- **Complete Tutorial**: From basic logging to advanced ELK stack deployment
- **Best Practices**: Security, Docker optimization, and configuration management
- **Two Approaches**: Compare simple vs. production-ready implementations

### **🚀 For Production Use:**
- **Customizable Base**: Ubuntu foundation for easy package additions
- **Health Monitoring**: Built-in health checks and proper startup ordering
- **Security Focused**: Non-root users, minimal attack surface, clean configurations

## 📦 Project Structure

```
log-monitoring-stack/
├── docker-compose.yml
├── logstash/
│   └── pipeline/
│       └── logstash.conf
├── spring-log-app/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/…
│           └── resources/
│               └── logback-spring.xml
```

---

## 🚀 Getting Started

### 1. Clone this project

```bash
git clone https://github.com/dcfrancisco/log-monitoring-stack.git
cd log-monitoring-stack

2. Build and start all services

docker-compose up --build

This launches:
	•	Elasticsearch on http://localhost:9200
	•	Logstash on port 5000
	•	Kibana on http://localhost:5601
	•	Spring Boot app sending JSON logs

⸻

🧪 Verify the Logs in Kibana
	1.	Visit http://localhost:5601
	2.	Go to Stack Management → Index Patterns
	3.	Click “Create index pattern”
	4.	Enter:

app-logs-*


	5.	Select @timestamp as the time filter field
	6.	Click “Create index pattern”

Now go to the Discover tab and you should see log entries from the Spring Boot app.

⸻

📤 Spring Boot Logging Details
	•	The app uses logback-spring.xml with Logstash TCP JSON encoder
	•	Logs are sent to Logstash at logstash:5000
	•	Log fields include @timestamp, level, logger_name, message, and more

You can simulate logs in code:

logger.info("Sample info log");
logger.error("Sample error log");


⸻

🧹 Cleaning Up

To stop everything:

docker-compose down

To delete persistent Elasticsearch volume:

docker volume rm log-monitoring-stack_esdata


```

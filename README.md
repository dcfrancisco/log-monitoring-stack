# Spring Boot Logging Stack (ELK) - Custom Build

This project sets up a complete **log aggregation and visualization stack** using custom Docker images built from official installers:

- 🟡 **Spring Boot** – emits structured JSON logs
- 🔷 **Logstash** – receives logs via TCP and pushes to Elasticsearch
- 🔶 **Elasticsearch** – stores and indexes logs (custom Docker image)
- 🔵 **Kibana** – visualizes and searches logs (custom Docker image)

## 🌟 **Two Versions Available:**

- **🚀 Main Branch** (Current): Advanced setup with custom Dockerfiles built from official installers
- **📝 [Simple Version](https://github.com/dcfrancisco/log-monitoring-stack/tree/simple-version)**: Basic setup using official Docker images - perfect for quick starts

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

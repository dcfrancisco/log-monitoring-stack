# 🚀 Spring Boot ELK Stack - Production-Ready Log Monitoring

> \*\*A complete, production-ready log aggregation and visualization stack with custom Do## 🧪 Verify the Logs in Kibana

1. Visit http://localhost:5601
2. Go to **Stack Management** → **Index Patterns**
3. Click "**Create index pattern**"
4. Enter: `app-logs-*`
5. Select `@timestamp` as the time filter field
6. Click "**Create index pattern**"

Now go to the **Discover** tab and you should see log entries from the Spring Boot app.uilt from official ELK installers\*\*

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
├── elasticsearch/
│   ├── Dockerfile
│   ├── elasticsearch.yml
│   ├── elasticsearch-7.17.9-linux-x86_64.tar.gz
│   └── .dockerignore
├── kibana/
│   ├── Dockerfile
│   ├── kibana.yml
│   ├── kibana-7.17.9-linux-x86_64.tar.gz
│   └── .dockerignore
├── logstash/
│   ├── Dockerfile
│   ├── logstash-7.17.9-linux-x86_64.tar.gz
│   ├── .dockerignore
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
└── elastalert/
    ├── config.yaml
    ├── smtp_auth.yaml
    └── rules/
        └── error-email-rule.yaml
```

---

## 🚀 Getting Started

### 1. Clone this project

```bash
git clone https://github.com/dcfrancisco/log-monitoring-stack.git
cd log-monitoring-stack
```

### 2. Download ELK Stack Installers

Download the official installers and place them in their respective folders:

**Elasticsearch** (`elasticsearch/`):

```bash
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.17.9-linux-x86_64.tar.gz -P elasticsearch/
```

**Kibana** (`kibana/`):

```bash
wget https://artifacts.elastic.co/downloads/kibana/kibana-7.17.9-linux-x86_64.tar.gz -P kibana/
```

**Logstash** (`logstash/`):

```bash
wget https://artifacts.elastic.co/downloads/logstash/logstash-7.17.9-linux-x86_64.tar.gz -P logstash/
```

### 3. Build and start all services

```bash
docker-compose up --build
```

This launches:

- **Elasticsearch** on http://localhost:9200 (custom Ubuntu-based image)
- **Logstash** on port 5000 (custom Ubuntu-based image)
- **Kibana** on http://localhost:5601 (custom Ubuntu-based image)
- **Spring Boot app** sending JSON logs

## ⚙️ Custom Docker Images

This project uses **custom Docker images** built from official ELK installers with Ubuntu 22.04 as the base:

### Key Features:

- 🐧 **Ubuntu 22.04** base image for better compatibility
- 📦 **Local installers** for faster, offline-capable builds
- 🔒 **Dedicated users** for each service (elasticsearch, kibana, logstash)
- ⚡ **Optimized** with .dockerignore files
- 🏥 **Health checks** for proper startup ordering

### Benefits:

- **Faster builds** - No internet downloads during build
- **Customizable** - Easy to modify base image or add packages
- **Reliable** - Consistent builds without network dependencies
- **Secure** - Services run as non-root users

---

🧪 Verify the Logs in Kibana 1. Visit http://localhost:5601 2. Go to Stack Management → Index Patterns 3. Click “Create index pattern” 4. Enter:

app-logs-\*

    5.	Select @timestamp as the time filter field
    6.	Click “Create index pattern”

Now go to the Discover tab and you should see log entries from the Spring Boot app.

---

## 📤 Spring Boot Logging Details

- The app uses `logback-spring.xml` with Logstash TCP JSON encoder
- Logs are sent to Logstash at `logstash:5000`
- Log fields include `@timestamp`, `level`, `logger_name`, `message`, and more

You can simulate logs in code:

```java
logger.info("Sample info log");
logger.error("Sample error log");
```

---

## 🛠️ Configuration Files

### Elasticsearch (`elasticsearch/elasticsearch.yml`):

- Single-node discovery
- Security disabled for development
- Memory lock enabled

### Kibana (`kibana/kibana.yml`):

- Connects to Elasticsearch via Docker network
- Encryption key configured
- Security disabled for development

### Logstash (`logstash/pipeline/logstash.conf`):

- TCP input on port 5000
- JSON parsing
- Output to Elasticsearch

---

## 🔧 Troubleshooting

### Common Issues:

**Kibana can't connect to Elasticsearch:**

- Check if Elasticsearch is healthy: `curl http://localhost:9200/_cluster/health`
- Verify Docker network connectivity

**Build fails:**

- Ensure all installer files are downloaded to correct directories
- Check .dockerignore files aren't excluding necessary files

**Memory issues:**

- Increase Docker memory allocation (recommended: 4GB+)
- Adjust `ES_JAVA_OPTS` in docker-compose.yml

---

## 🧹 Cleaning Up

To stop everything:

```bash
docker-compose down
```

To delete persistent Elasticsearch volume:

```bash
docker volume rm log-monitoring-stack_esdata
```

---

## ☕ Support

If this project helped you, consider buying me a coffee! ☕

[![Buy Me A Coffee](https://img.buymeacoffee.com/button-api/?text=Buy%20me%20a%20coffee&emoji=☕&slug=dcfrancisco&button_colour=FFDD00&font_colour=000000&font_family=Cookie&outline_colour=000000&coffee_colour=ffffff)](https://www.buymeacoffee.com/dcfrancisco)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

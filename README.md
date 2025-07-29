# Spring Boot Logging Stack (ELK) - Custom Build

This project sets up a complete \*\*log aggregation and vi## 🧪 Verify the Logs in Kibana

1. Visit http://localhost:5601
2. Go to **Stack Management** → **Index Patterns**
3. Click "**Create index pattern**"
4. Enter: `app-logs-*`
5. Select `@timestamp` as the time filter field
6. Click "**Create index pattern**"

Now go to the **Discover** tab and you should see log entries from the Spring Boot app.tack\*\* using custom Docker images built from official installers:

- 🟡 **Spring Boot** – emits structured JSON logs
- 🔷 **Logstash** – receives logs via TCP and pushes to Elasticsearch
- 🔶 **Elasticsearch** – stores and indexes logs (custom Docker image)
- 🔵 **Kibana** – visualizes and searches logs (custom Docker image)

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

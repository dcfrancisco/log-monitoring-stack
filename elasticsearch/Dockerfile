FROM ubuntu:22.04

# Set environment variables
ENV ELASTIC_VERSION=7.17.9
ENV ELASTIC_HOME=/usr/share/elasticsearch
ENV PATH=$ELASTIC_HOME/bin:$PATH

# Install necessary packages
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create elasticsearch user
RUN groupadd -g 1000 elasticsearch && \
    useradd -u 1000 -g 1000 -d $ELASTIC_HOME elasticsearch

# Copy and install Elasticsearch from local installer
COPY elasticsearch-${ELASTIC_VERSION}-linux-x86_64.tar.gz /tmp/
RUN tar -xzf /tmp/elasticsearch-${ELASTIC_VERSION}-linux-x86_64.tar.gz -C /tmp && \
    mv /tmp/elasticsearch-${ELASTIC_VERSION} $ELASTIC_HOME && \
    rm /tmp/elasticsearch-${ELASTIC_VERSION}-linux-x86_64.tar.gz

# Set ownership and permissions
RUN chown -R elasticsearch:elasticsearch $ELASTIC_HOME && \
    mkdir -p /usr/share/elasticsearch/data /usr/share/elasticsearch/logs && \
    chown -R elasticsearch:elasticsearch /usr/share/elasticsearch/data /usr/share/elasticsearch/logs

# Copy configuration
COPY --chown=elasticsearch:elasticsearch elasticsearch.yml $ELASTIC_HOME/config/

# Switch to elasticsearch user
USER elasticsearch

# Expose port
EXPOSE 9200 9300

# Set working directory
WORKDIR $ELASTIC_HOME

# Start Elasticsearch
CMD ["elasticsearch"]
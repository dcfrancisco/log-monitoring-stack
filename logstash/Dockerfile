FROM ubuntu:22.04

# Set environment variables
ENV LOGSTASH_VERSION=7.17.9
ENV LOGSTASH_HOME=/usr/share/logstash
ENV PATH=$LOGSTASH_HOME/bin:$PATH

# Install necessary packages
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create logstash user
RUN groupadd -g 1000 logstash && \
    useradd -u 1000 -g 1000 -d $LOGSTASH_HOME logstash

# Copy and install Logstash from local installer
COPY logstash-${LOGSTASH_VERSION}-linux-x86_64.tar.gz /tmp/
RUN tar -xzf /tmp/logstash-${LOGSTASH_VERSION}-linux-x86_64.tar.gz -C /tmp && \
    mv /tmp/logstash-${LOGSTASH_VERSION} $LOGSTASH_HOME && \
    rm /tmp/logstash-${LOGSTASH_VERSION}-linux-x86_64.tar.gz

# Set ownership and permissions
RUN chown -R logstash:logstash $LOGSTASH_HOME && \
    mkdir -p /usr/share/logstash/data /usr/share/logstash/logs && \
    chown -R logstash:logstash /usr/share/logstash/data /usr/share/logstash/logs

# Copy pipeline configuration
COPY --chown=logstash:logstash pipeline/ $LOGSTASH_HOME/pipeline/

# Copy configuration if needed
# COPY --chown=logstash:logstash logstash.yml $LOGSTASH_HOME/config/

# Switch to logstash user
USER logstash

# Expose ports
EXPOSE 5000 5044 9600

# Set working directory
WORKDIR $LOGSTASH_HOME

# Start Logstash
CMD ["logstash", "-f", "/usr/share/logstash/pipeline/logstash.conf"]
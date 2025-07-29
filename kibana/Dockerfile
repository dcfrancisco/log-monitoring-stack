FROM ubuntu:22.04

# Set environment variables
ENV KIBANA_VERSION=7.17.9
ENV KIBANA_HOME=/usr/share/kibana
ENV PATH=$KIBANA_HOME/bin:$PATH

# Install necessary packages
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create kibana user
RUN groupadd -g 1000 kibana && \
    useradd -u 1000 -g 1000 -d $KIBANA_HOME kibana

# Copy and install Kibana from local installer
COPY kibana-${KIBANA_VERSION}-linux-x86_64.tar.gz /tmp/
RUN tar -xzf /tmp/kibana-${KIBANA_VERSION}-linux-x86_64.tar.gz -C /tmp && \
    mv /tmp/kibana-${KIBANA_VERSION}-linux-x86_64 $KIBANA_HOME && \
    rm /tmp/kibana-${KIBANA_VERSION}-linux-x86_64.tar.gz

# Set ownership and permissions
RUN chown -R kibana:kibana $KIBANA_HOME && \
    mkdir -p /usr/share/kibana/data && \
    chown -R kibana:kibana /usr/share/kibana/data

# Copy configuration
COPY --chown=kibana:kibana kibana.yml $KIBANA_HOME/config/

# Switch to kibana user
USER kibana

# Expose port
EXPOSE 5601

# Set working directory
WORKDIR $KIBANA_HOME

# Start Kibana
CMD ["kibana"]
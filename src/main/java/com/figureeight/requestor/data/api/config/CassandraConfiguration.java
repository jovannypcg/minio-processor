package com.figureeight.requestor.data.api.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfiguration {
    @Value("${cassandra.keyspace-name}")
    private String keyspace;

    @Value("${cassandra.host}")
    private String host;

    protected Session getRequiredSession() {
        Cluster cluster = Cluster.builder().addContactPoint(host).build();
        return cluster.connect();
    }
}

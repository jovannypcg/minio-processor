package com.figureeight.requestor.data.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class })
public class RequestorDataApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RequestorDataApiApplication.class, args);
    }
}

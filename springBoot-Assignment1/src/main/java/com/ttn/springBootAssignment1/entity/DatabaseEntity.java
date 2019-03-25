package com.ttn.springBootAssignment1.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseEntity {

    @Value("${app.name}")
    String name;

    @Value("${app.port}")
    String port;

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }
}
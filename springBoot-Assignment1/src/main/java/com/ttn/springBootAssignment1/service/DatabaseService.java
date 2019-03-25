package com.ttn.springBootAssignment1.service;


import com.ttn.springBootAssignment1.Question4.Database;
import com.ttn.springBootAssignment1.entity.DatabaseEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DatabaseService {

    @Autowired
    DatabaseEntity database;

   // private final Logger LOG = (Logger) LoggerFactory.getLogger(DatabaseService.class);

    public String getData() {
        //LOG.info("getting database name and port from DatabaseService");
        return "Name- " + database.getName()+ " Port- " + database.getPort();
    }
}
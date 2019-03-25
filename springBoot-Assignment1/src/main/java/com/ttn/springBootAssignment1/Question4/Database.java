package com.ttn.springBootAssignment1.Question4;

import com.ttn.springBootAssignment1.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Database {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("/database")
    public String getData(){
        return databaseService.getData();

    }
}
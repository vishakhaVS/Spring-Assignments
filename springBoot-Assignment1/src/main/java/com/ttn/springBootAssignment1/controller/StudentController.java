package com.ttn.springBootAssignment1.controller;

import com.ttn.springBootAssignment1.entity.Student;
import com.ttn.springBootAssignment1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;

    @GetMapping("/details")
    public List<Student> getBooks() {
        return studentservice.getDetails();
    }
}




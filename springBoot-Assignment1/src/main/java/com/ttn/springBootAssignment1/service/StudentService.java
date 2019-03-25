package com.ttn.springBootAssignment1.service;

import com.ttn.springBootAssignment1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class StudentService {

    public List<Student> getDetails() {
        return Arrays.asList(new Student("vishakha", 20),
                new Student( "yatin", 46));
    }
}

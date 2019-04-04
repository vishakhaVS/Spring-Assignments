package com.ttn.springrest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ttn.springrest.entity.Student2;
import com.ttn.springrest.repository.Student2Repository;

import java.util.List;
import java.util.Optional;

@Service
public class Student2Service {

    @Autowired
    Student2Repository student2Repository;

    public List<Student2> getAllStudent2s() {
        return (List<Student2>) student2Repository.findAll();
    }

    public Student2 getStudent2ById(Long id) {
        Optional<Student2> optional = student2Repository.findById(id);
        return optional.orElse(null);
    }

    public void saveStudent2(Student2 student) {
        student2Repository.save(student);
    }

    public void deleteStudent2(Long id) {
        student2Repository.deleteById(id);
    }
}
package com.ttn.springBootAssignment1.bootstrap;



import com.ttn.springBootAssignment1.entity.Student;
import com.ttn.springBootAssignment1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class StudentBootstrap {


    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Iterator<Student> studentIterable = studentRepository.findAll().iterator();
        if (!studentIterable.hasNext()) {
            for (int i = 1; i <= 10; i++) {
                Student student = new Student("Name " + i,  i);
                studentRepository.save(student);
                System.out.println("Student " + i + " created");
            }
        }
        System.out.println("Your Application is up and running");
    }
}

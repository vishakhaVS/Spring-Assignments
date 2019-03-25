package com.ttn.springBootAssignment1.repository;

import com.ttn.springBootAssignment1.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}

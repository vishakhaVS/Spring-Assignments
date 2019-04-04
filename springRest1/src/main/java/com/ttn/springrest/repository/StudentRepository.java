package com.ttn.springrest.repository;

import org.springframework.data.repository.CrudRepository;
import com.ttn.springrest.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
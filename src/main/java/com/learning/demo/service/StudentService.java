package com.learning.demo.service;

import com.learning.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends MongoRepository<Student, String> {
    public Student findByStudentId(String studentId);
}

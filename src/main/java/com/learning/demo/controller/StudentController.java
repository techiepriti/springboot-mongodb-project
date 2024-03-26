package com.learning.demo.controller;

import com.learning.demo.model.AdmissionUpdate;
import com.learning.demo.model.Student;
import com.learning.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student res = this.studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> result = this.studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/api/students/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") String studentId){
        Student result = this.studentService.findByStudentId(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/api/students/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("studentId") String studentId){
        this.studentService.deleteById(studentId);
        String message = "Student record has been deleted successfully with id: " + studentId;
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PatchMapping("/api/students")
    public ResponseEntity<?> updatedStudentAdmissionYear(@RequestBody AdmissionUpdate admissionUpdate){
        String studentId = admissionUpdate.getStudentId();
        String admissionYear = admissionUpdate.getAdmissionYear();

        Student student = this.studentService.findByStudentId(studentId);
        if(null != student){
            student.setAdmissionYear(admissionYear);
            this.studentService.save(student);
        }else{
            String message = "No student with the Student id: "+ studentId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}

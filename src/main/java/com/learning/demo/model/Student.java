package com.learning.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    private String studentId;
    private String name;
    private String course;
    private String admissionYear;

    public Student() {
    }

    public Student(String studentId, String name, String course, String admissionYear) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.admissionYear = admissionYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", admissionYear='" + admissionYear + '\'' +
                '}';
    }
}

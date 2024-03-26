package com.learning.demo.model;

public class AdmissionUpdate {
    private String studentId;
    private String admissionYear;

    public AdmissionUpdate() {
    }

    public AdmissionUpdate(String studentId, String admissionYear) {
        this.studentId = studentId;
        this.admissionYear = admissionYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    @Override
    public String toString() {
        return "AdmissionUpdate{" +
                "studentId='" + studentId + '\'' +
                ", admissionYear='" + admissionYear + '\'' +
                '}';
    }
}

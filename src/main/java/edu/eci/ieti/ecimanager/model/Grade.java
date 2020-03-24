package edu.eci.ieti.ecimanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grades")
public class Grade {

    @Id
    private String id;
    private String subject;
    private Integer semester;
    private Integer term;
    private Double grade;
    private Long studentId;

    public Grade() {
    }

    public Grade(String id, int semester, String subject, Integer term, Double grade, Long studentId) {
        this.id = id;
        this.semester = semester;
        this.subject = subject;
        this.term = term;
        this.grade = grade;
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public Integer getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getTerm() {
        return term;
    }

    public Double getGrade() {
        return grade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
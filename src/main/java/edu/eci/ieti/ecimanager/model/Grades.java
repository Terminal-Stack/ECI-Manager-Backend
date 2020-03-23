package edu.eci.ieti.ecimanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Grades {

    @Id
    private String id;
    private String subject;
    private Integer semester;
    private Integer term;
    private Double grade;
    private Student student;

    public Grades() {
    }

    public Grades(String id, int semester, String subject, Integer term, Double grade) {
        this.id = id;
        this.semester = semester;
        this.subject = subject;
        this.term = term;
        this.grade = grade;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
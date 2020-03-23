package edu.eci.ieti.ecimanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Student {
    @Id
    private String id;
    private Long collegeId;
    private String email;
    private String name;
    private String password;
    private Long personalId;
    private String faculty;
    private ArrayList<Grades> grades = new ArrayList<Grades>();

    public Student(String id, Long collegeId, String email, String name, String password, Long personalId, String faculty, ArrayList<Grades> grades) {
        this.id = id;
        this.collegeId = collegeId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.personalId = personalId;
        this.faculty = faculty;
        this.grades = grades;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public String getFaculty() {
        return faculty;
    }

    public ArrayList<Grades> getGrades() {
        return grades;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGrades(ArrayList<Grades> grades) {
        this.grades = grades;
    }
}
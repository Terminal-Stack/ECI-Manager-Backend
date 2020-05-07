package edu.eci.ieti.ecimanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student implements User {
    @Id
    private Long collegeId;
    private Long personalId;
    private String email;
    private String password;
    private String name;
    private String faculty;
    private Role role;
    private Integer penalty;

    public Student(Long collegeId, String email, String name, String password, Long personalId, String faculty, Role role, Integer penalty) {
        this.collegeId = collegeId;
        this.personalId = personalId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.faculty = faculty;
        this.role = role;
        this.penalty = penalty;
    }

    public Student() {
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

}
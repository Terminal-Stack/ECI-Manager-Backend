package edu.eci.ieti.ecimanager.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Invoice {
    @Id
    private String id;
    private Integer value;
    private String description;
    private Date date;
    private Student student;

    public Invoice(String id, Integer value, String description, Date date, Student student) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
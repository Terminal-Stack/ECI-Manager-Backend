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
    private Long studentId;

    public Invoice(String id, Integer value, String description, Date date, Long studentId) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
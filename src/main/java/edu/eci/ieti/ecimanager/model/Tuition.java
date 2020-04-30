package edu.eci.ieti.ecimanager.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tuitions")
public class Tuition {

    private Integer value;
    private Long studentCollegeId;
    private Boolean paid;

    public Tuition(Integer value, Long studentCollegeId, Boolean paid) {
        this.value = value;
        this.studentCollegeId = studentCollegeId;
        this.paid = paid;
    }

    public Tuition() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getStudentCollegeId() {
        return studentCollegeId;
    }

    public void setStudentCollegeId(Long studentCollegeId) {
        this.studentCollegeId = studentCollegeId;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}

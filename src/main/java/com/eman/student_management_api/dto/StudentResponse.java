package com.eman.student_management_api.dto;

public class StudentResponse {

    private Long id;
    private String name;
    private Double cgpa;

    public StudentResponse(Long id, String name, Double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getCgpa() {
        return cgpa;
    }
}

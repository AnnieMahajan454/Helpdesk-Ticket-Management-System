package com.eman.student_management_api.dto;

public class CreateStudentRequest {
    private String name;
    private Double cgpa;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
}

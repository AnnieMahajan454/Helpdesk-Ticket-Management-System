package com.eman.student_management_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Student {

    //using wrapper classes so that it can hold null , if nothing assigned yet
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cgpa;



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id= id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public Double getCgpa(){
        return cgpa;
    }

    public void setCgpa(Double cgpa){
        this.cgpa= cgpa;
    }
}

package com.example.springbootsample.dto;

import jakarta.validation.constraints.NotNull;

public class Person {

    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String gender;
    @NotNull
    private String occupation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
 }



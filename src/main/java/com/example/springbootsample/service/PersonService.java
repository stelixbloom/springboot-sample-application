package com.example.springbootsample.service;

import com.example.springbootsample.dto.Person;

import java.util.List;

public interface PersonService {

    List<Person> retrieve();

    Person retrieve(int id);

    Person register(Person person);

    Person update(Person person);

    int delete(int id);

}

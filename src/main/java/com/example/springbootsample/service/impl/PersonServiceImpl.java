package com.example.springbootsample.service.impl;

import com.example.springbootsample.dto.Person;
import com.example.springbootsample.repository.PersonMapper;
import com.example.springbootsample.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper mapper;

    public PersonServiceImpl(PersonMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Person register(Person person) {
        mapper.insert(person);
        return person;
    }

    @Override
    public List<Person> retrieve() {
        return mapper.selectAll();
    }

    @Override
    public Person retrieve(int id) {
        return mapper.select(id);
    }

    @Override
    public Person update(Person person) {
        mapper.update(person);
        return person;
    }

    @Override
    public int delete(int id) {
        mapper.delete(id);
        return id;
    }
}

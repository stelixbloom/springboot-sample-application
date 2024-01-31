package com.example.springbootsample.repository;

import com.example.springbootsample.dto.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    int insert(Person person);

    List<Person> selectAll();

    Person select(int id);

    int update(Person person);

    int delete(int id);
}

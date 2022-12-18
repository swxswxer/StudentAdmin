package com.swx.service;

import com.swx.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

    void add (Student student);

    void deleteById(int id);

    void update(Student student);
}

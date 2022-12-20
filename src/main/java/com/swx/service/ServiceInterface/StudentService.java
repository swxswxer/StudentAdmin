package com.swx.service.ServiceInterface;

import com.swx.pojo.Clazz;
import com.swx.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

    void add (Student student);

    void deleteById(int id);

    void update(Student student);

    Student selectById(int studentid);

    List<Student> selectByName(String name);
    List<Student> selectByMajor(String major);
}

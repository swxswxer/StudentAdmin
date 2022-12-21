package com.swx.service.ServiceInterface;

import com.swx.pojo.Clazz;
import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

    void add (Student student);

    void deleteById(int id);

    void update(Student student);

    Student selectById(int studentid);

    List<Student> selectByName(String name);
    List<Student> selectByMajor(String major);


    List<Integer> getStudentCurriculumList(int studentid);

//    List<Curriculum> getCurriculumById(List<Integer> classIdList );


    List<Curriculum> getCurriculumByIds(List<Integer> ids);

    void addStudentCurriculumMapping(int studentid, int curriculumid);
}

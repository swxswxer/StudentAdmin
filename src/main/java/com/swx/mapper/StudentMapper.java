package com.swx.mapper;

import com.swx.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();


    @Insert("insert into student values(#{studentid},#{name},#{age},#{sex},#{major})")
    void add(Student student);


    @Delete("delete from student where studentid=#{id}")
    void deleteById(int id);

    void update(Student student);
}

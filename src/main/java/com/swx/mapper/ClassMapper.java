package com.swx.mapper;

import com.swx.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {
    @Select("select * from class")
    List<Student> selectAll();


    @Insert("insert into class values(#{classname},#{department})")
    void add(Class class1);


    @Delete("delete from class where class=#{id}")
    void deleteById(int id);

    void update(Student student);
}

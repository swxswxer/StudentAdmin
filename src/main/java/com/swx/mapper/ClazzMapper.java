package com.swx.mapper;

import com.swx.pojo.Clazz;
import com.swx.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzMapper {
    @Select("select * from class")
    List<Clazz> selectAll();


    @Insert("insert into class values(#{id},#{classname},#{department})")
    void add(Clazz clazz);


    @Delete("delete from class where id=#{id}")
    void deleteById(int id);

    void update(Clazz clazz);

    @Select("select * from class where classname like #{classname}")
    List<Clazz> selectLikeName(String classname);

    @Select("select * from class where classname = #{classname}")
    Clazz selectByName(String classname);

}

package com.swx.mapper;

import com.swx.pojo.Clazz;
import com.swx.pojo.Curriculum;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CurriculumMapper {
    @Select("select * from curriculum")
    List<Curriculum> selectAll();

    @Insert("insert into curriculum values(#{id},#{name},#{credit},#{numberOfPeople},#{major)")
    void add (Curriculum curriculum);

    void update(Curriculum curriculum);

    @Delete("delete from curriculum where id=#{id}")
    void deleteById(int id);

}

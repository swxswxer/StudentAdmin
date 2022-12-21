package com.swx.mapper;

import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from student where studentid = #{studentid}")
    Student selectById(int studentid);

    @Select("select * from student where name = #{name}")
    List<Student> selectByName(String name);

    @Select("select * from student where major = #{major}")
    List<Student> selectByMajor(String Major);

    // 添加学生专业映射表ß
    @Insert("insert ignore into studentCurriculumidMapping(studentid,curriculumid) values(#{studentid},#{curriculumid}) ")
    void addStudentCurriculumMapping(@Param("studentid")int studentid,@Param("curriculumid")int curriculumid);

    //
    @Select("SELECT curriculumid FROM studentCurriculumidMapping WHERE studentCurriculumidMapping.studentid = #{studentid}")
    List<Integer> getStudentCurriculumList(int studentid);

//    @Select("SELECT * FROM curriculum WHERE curriculum.id IN (#{classIdList})")
//    List<Curriculum> getCurriculumByIds(List<Integer> ids );

    @Select({"<script>" +
            "select * from curriculum where curriculum.id in " +
            "<foreach item='ids' index='index' collection='list' open='(' separator=',' close=')'>" +
            "#{ids}",
            "</foreach>",
            "</script>"})
    List<Curriculum> getCurriculumByIds(List<Integer> ids);

    @Delete("DELETE FROM studentCurriculumidMapping\n" +
            "WHERE studentid = #{studentid} AND curriculumid = #{curriculumid}")
    void deleteStudentCurriculum(@Param("studentid")int studentid,@Param("curriculumid")int curriculumid);
}

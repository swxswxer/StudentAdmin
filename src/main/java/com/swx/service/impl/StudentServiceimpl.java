package com.swx.service.impl;

import com.swx.mapper.StudentMapper;
import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import com.swx.service.ServiceInterface.StudentService;
import com.swx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StudentServiceimpl implements StudentService {
    //1 创建SqlSessionFactory工厂
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Student> selectAll() {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        List<Student> students = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return students;
    }

    public void add(Student student) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法

        mapper.add(student);
        sqlSession.commit();
        sqlSession.close();
    }


    public void deleteById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Student student) {

        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        mapper.update(student);
        sqlSession.commit();
        sqlSession.close();
    }

    public Student selectById(int studentid) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        Student student = mapper.selectById(studentid);
        sqlSession.commit();
        sqlSession.close();
        return student;
    }

    public List<Student> selectByName(String name) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        List<Student> students = mapper.selectByName(name);
        //释放资源
        sqlSession.close();

        return students;
    }

    public List<Student> selectByMajor(String major) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        List<Student> students = mapper.selectByMajor(major);
        //释放资源
        sqlSession.close();

        return students;
    }

    @Override
    public void addStudentCurriculumMapping(int studentid, int curriculumid) {
        //获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取brand mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        mapper.addStudentCurriculumMapping(studentid,curriculumid);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Integer> getStudentCurriculumList(int studentid) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        List<Integer> classs = mapper.getStudentCurriculumList(studentid);
        //释放资源
        sqlSession.close();

        return classs;
    }

    @Override
    public List<Curriculum> getCurriculumByIds(List<Integer> classIdList) {
        SqlSession sqlSession = factory.openSession();
        //获取student mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //执行方法
        List<Curriculum> curriculumList = mapper.getCurriculumByIds(classIdList);
        //释放资源
        sqlSession.close();
        return curriculumList;
    }

}

package com.swx;

import com.swx.pojo.Curriculum;
import com.swx.pojo.Student;
import com.swx.service.ServiceInterface.StudentService;
import com.swx.service.impl.ClazzServiceImpl;
import com.swx.service.impl.CurriculumServiceImpl;
import com.swx.service.impl.StudentServiceimpl;
import org.apache.ibatis.annotations.Insert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDao {

    @Test
    public void userServiceTest(){
        ClazzServiceImpl clazzService = new ClazzServiceImpl();
        System.out.println(clazzService.selectAll());
    }

    @Test
    public void studentServiceTest(){
        List<String> strings = new ArrayList<String>();

        strings.add("123");
        strings.add("1231");
        strings.add("1232");
        StudentService studentService = new StudentServiceimpl();

//        Student student = new Student(999,"testlist",111,"nan","test",strings);
//        studentService.add(student);
    }

    @Test
    public void studentSelectTest(){
        StudentService studentService = new StudentServiceimpl();

        List<Student> students = studentService.selectAll();
        System.out.println(students);
    }
    @Test
    public void curriculum(){
        CurriculumServiceImpl curriculumService = new CurriculumServiceImpl();

//        curriculumService.add(new Curriculum(1,"javaweb",4));
    }

    @Test
    public void testAddClass(){
        int studentid = 5 ;
        int curriculumid = 4 ;
        StudentService studentService = new StudentServiceimpl();
//        studentService.addClass(studentid,curriculumid);
    }

    @Test
    public void test1(){
        StudentService studentService = new StudentServiceimpl();
studentService.addStudentCurriculumMapping(8,1);
    }

    @Test
    public void test2(){
        StudentService studentService = new StudentServiceimpl();
        List<Integer> studentCurriculumList = studentService.getStudentCurriculumList(7);
        System.out.println("studentCurriculumList = " + studentCurriculumList);

        List<Curriculum> curriculumByIds = studentService.getCurriculumByIds(studentCurriculumList);
        System.out.println("curriculumByIds = " + curriculumByIds);
    }
}

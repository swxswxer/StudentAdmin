package com.swx;

import com.swx.pojo.Student;
import com.swx.service.StudentService;
import com.swx.service.impl.StudentServiceimpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        StudentService StudentService = new StudentServiceimpl();



//        //查询所有方法测试
//        List<Student> students =  StudentService.selecrAll();
//
//        for (Student x : students){
//            System.out.println(x);
//        }

        //增加学生测试
//        Student student = new Student(11111111,"test", 100, "test", "test");
//        StudentService.add(student);


        //删除学生测试
//        StudentService.delectById(11111111);

        Student student = new Student(2140130011, "wtt", 20, "男", "软件工程一班");
        StudentService.update(student);

    }
}

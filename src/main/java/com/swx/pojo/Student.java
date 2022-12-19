package com.swx.pojo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class Student {

    private int studentid;

    private String name;

    private int age;

    private String sex;

    private String major;


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Student(int studentid, String name, int age, String sex, String major) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.major = major;
    }
}


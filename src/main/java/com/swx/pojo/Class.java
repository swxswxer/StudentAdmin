package com.swx.pojo;

public class Class {
    int id ;
    String classname ;
    String department;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class() {

    }

    public Class(String classname, String department) {
        this.classname = classname;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", classname='" + classname + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

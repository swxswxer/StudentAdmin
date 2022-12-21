package com.swx.pojo;

import java.util.List;

public class AddClassRequest {
    List<Integer> majors ;
    int student_id;

    public List<Integer> getMajors() {
        return majors;
    }

    public void setMajors(List<Integer> majors) {
        this.majors = majors;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public AddClassRequest(List<Integer> majors, int student_id) {
        this.majors = majors;
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "AddClassRequest{" +
                "majors=" + majors +
                ", student_id=" + student_id +
                '}';
    }
}
